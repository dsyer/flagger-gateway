## Install Flagger and Demo App

Basic generic install of Flagger:

```
$ kustomize build https://github.com/fluxcd/flagger/kustomize/kubernetes?ref=main | kubectl apply -f -
```

Basic demo app from Kubernetes examples:

```
$ kubectl apply -f config/app.yaml
```

You can curl it on port 9898. It returns the current podinfo:

```
$ kubectl port-forward services/podinfo 9898:9898
$ curl localhost:9898
{
  "hostname": "podinfo-5d5dbc4d84-mwmxm",
  "version": "6.0.0",
  "revision": "",
  "color": "#34577c",
  "logo": "https://raw.githubusercontent.com/stefanprodan/podinfo/gh-pages/cuddle_clap.gif",
  "message": "greetings from podinfo v6.0.0",
  "goos": "linux",
  "goarch": "amd64",
  "runtime": "go1.16.9",
  "num_goroutine": "9",
  "num_cpu": "8"
}
```

## Blue-Green Deployment

```
$ kubectl apply -f config/canary.yaml
```

wait for the canary to have a status of `Initialized`:

```
$ kubectl get canary
NAME     STATUS        WEIGHT   LASTTRANSITIONTIME
podinfo  Initialized   0        2021-10-13T15:47:00Z
```

Update the image:

```
$ kubectl set image deployment/podinfo podinfod=ghcr.io/stefanprodan/podinfo:6.0.1
```

and the canary should start progressing:

```
$ kubectl get canary
NAME     STATUS        WEIGHT   LASTTRANSITIONTIME
podinfo  Progressing   0        2021-10-13T15:47:00Z
```

Ping its canary endpoint hard enough:

```
$ kubectl port-forward service/podinfo-canary 9898:9898
$ ab -c 2 -n 30000 http://localhost:9898/
```

and the canary will succeed (suck seed?).

```
$ kubectl get canaries.flagger.app 
NAME      STATUS      WEIGHT   LASTTRANSITIONTIME
podinfo   Succeeded   0        2024-01-31T08:21:47Z
```

When it succeeds, it will be promoted to primary, and the canary service will stop responding on port 9898. The primary service will start responding on port 9898 and show the current version:

```
$ kubectl port-forward services/podinfo 9898:9898
{
  "hostname": "podinfo-primary-5b5c685949-scqdd",
  "version": "6.0.1",
  "revision": "",
  "color": "#34577c",
  "logo": "https://raw.githubusercontent.com/stefanprodan/podinfo/gh-pages/cuddle_clap.gif",
  "message": "greetings from podinfo v6.0.1",
  "goos": "linux",
  "goarch": "amd64",
  "runtime": "go1.16.9",
  "num_goroutine": "9",
  "num_cpu": "8"
}
```

# Gateway App

```
$ mvn spring-boot:build-image
$ docker tag gateway:0.0.1-SNAPSHOT localhost:5000/gateway
$ docker push localhost:5000/gateway
$ kubectl apply -f config/gateway.yaml
```

Test that the gateway is working:

```
$ kubectl port-forward services/gateway 8080:80
Forwarding from 127.0.0.1:8080 -> 8080
Forwarding from [::1]:8080 -> 8080
$ curl localhost:8080/podinfo/
{
  "hostname": "podinfo-5d5dbc4d84-mwmxm",
  "version": "6.0.1",
  "revision": "",
  "color": "#34577c",
  "logo": "https://raw.githubusercontent.com/stefanprodan/podinfo/gh-pages/cuddle_clap.gif",
  "message": "greetings from podinfo v6.0.1",
  "goos": "linux",
  "goarch": "amd64",
  "runtime": "go1.16.9",
  "num_goroutine": "9",
  "num_cpu": "8"
}
```

The gateway also has a `/canary` endpoint that will return the canary version of podinfo, so you can use that to promote a new version the same way we did with the `podinfo-canary` port forward above.