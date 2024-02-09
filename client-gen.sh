#!/bin/bash

set -euo pipefail

readonly CLIENT_GEN_DIR="/tmp/kubernetes-client-gen"
readonly PROJECT_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

readonly LOCAL_MANIFEST_FILE_1=$PROJECT_ROOT/config/httproute.yaml
readonly LOCAL_MANIFEST_FILE_2=$PROJECT_ROOT/config/gatewayroute.yaml

readonly GWY_PACKAGE=io/k8s/networking/gateway
readonly SCG_PACKAGE=com/vmware/tanzu
readonly GENERATED_SOURCES_PATH=src/main/java
readonly SWAGGER_DEFINITIONS=$PROJECT_ROOT/build/swagger
readonly GENERATOR_OUTPUT=$PROJECT_ROOT/build/gen

deleteExisting() {
  deleteCrd
  rm -Rf "$CLIENT_GEN_DIR"
  rm -Rf "$GENERATOR_OUTPUT"
  rm -Rf "$SWAGGER_DEFINITIONS"
  rm -Rf "$PROJECT_ROOT/crd-models/$GENERATED_SOURCES_PATH/"*
}

applyCrd() {
  kubectl apply --validate=false -f "$LOCAL_MANIFEST_FILE_1"
  kubectl apply --validate=false -f "$LOCAL_MANIFEST_FILE_2"
}

deleteCrd() {
  kubectl delete -f "$LOCAL_MANIFEST_FILE_1" 2>&1 || true
  kubectl delete -f "$LOCAL_MANIFEST_FILE_2" 2>&1 || true
}

generate() {
  # git clone https://github.com/kubernetes-client/gen ${CLIENT_GEN_DIR}|| true
  # If we need hot-fixes, we can point to a fork while PRs are pending in upstream
  # git clone -b 'add-date-and-library' https://github.com/abelsromero/gen ${CLIENT_GEN_DIR}|| true
  git clone https://github.com/kubernetes-client/gen ${CLIENT_GEN_DIR}|| true

  cd $CLIENT_GEN_DIR/openapi
  # Checkout the commit immediately prior to the commit referenced on the next line, which updated the openapi generator and causes our generated models to not compile
  # https://github.com/kubernetes-client/gen/commit/e2334cc3a4b05b9058469fd38af7eb720bc537ae
  # git checkout 9701a7c9ae41c489c1839a10069e6b0c79803d72
  # master on 2024/02/07
  git checkout 84f2bc9e34129f92606a00fccb8c5c62204012b9
  mkdir -p "$PROJECT_ROOT/build"
  kubectl get --raw="/openapi/v2" > "$SWAGGER_DEFINITIONS"
  while ! (grep -Fq '"HTTPRoute"' "$SWAGGER_DEFINITIONS" && grep -Fq '"SpringCloudGatewayRouteConfig"' "$SWAGGER_DEFINITIONS"); do
    echo "Waiting for CRD to be applied..."
    sleep 1
    kubectl get --raw="/openapi/v2" > "$SWAGGER_DEFINITIONS"
  done

  export OPENAPI_GENERATOR_COMMIT=v7.3.0

  bash java-crd-cmd.sh -n io.k8s.networking.gateway -p io.k8s.networking.gateway -l 2 -h true -o "$GENERATOR_OUTPUT" -g true < "$SWAGGER_DEFINITIONS"
  bash java-crd-cmd.sh -n com.vmware.tanzu -p com.vmware.tanzu -l 2 -h true -o "$GENERATOR_OUTPUT" -g true < "$SWAGGER_DEFINITIONS"
}

copyToProject() {
  cp -Rf "$GENERATOR_OUTPUT/src/main/java"/* "$PROJECT_ROOT/crd-models/$GENERATED_SOURCES_PATH"
  rm -rf "$PROJECT_ROOT/crd-models/$GENERATED_SOURCES_PATH"/io/kubernetes
}

deleteExisting
applyCrd
generate
copyToProject
deleteCrd