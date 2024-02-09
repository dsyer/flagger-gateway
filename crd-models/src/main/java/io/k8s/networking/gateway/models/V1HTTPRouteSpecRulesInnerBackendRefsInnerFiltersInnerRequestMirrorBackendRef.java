/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.27.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.k8s.networking.gateway.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.kubernetes.client.openapi.JSON;

/**
 * BackendRef references a resource where mirrored requests are sent.   Mirrored requests must be sent only to a single destination endpoint within this BackendRef, irrespective of how many endpoints are present within this BackendRef.   If the referent cannot be found, this BackendRef is invalid and must be dropped from the Gateway. The controller must ensure the \&quot;ResolvedRefs\&quot; condition on the Route status is set to &#x60;status: False&#x60; and not configure this backend in the underlying implementation.   If there is a cross-namespace reference to an *existing* object that is not allowed by a ReferenceGrant, the controller must ensure the \&quot;ResolvedRefs\&quot;  condition on the Route is set to &#x60;status: False&#x60;, with the \&quot;RefNotPermitted\&quot; reason and not configure this backend in the underlying implementation.   In either error case, the Message of the &#x60;ResolvedRefs&#x60; Condition should be used to provide more detail about the problem.   Support: Extended for Kubernetes Service   Support: Implementation-specific for any other resource
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef {
  public static final String SERIALIZED_NAME_GROUP = "group";
  @SerializedName(SERIALIZED_NAME_GROUP)
  private String group;

  public static final String SERIALIZED_NAME_KIND = "kind";
  @SerializedName(SERIALIZED_NAME_KIND)
  private String kind;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NAMESPACE = "namespace";
  @SerializedName(SERIALIZED_NAME_NAMESPACE)
  private String namespace;

  public static final String SERIALIZED_NAME_PORT = "port";
  @SerializedName(SERIALIZED_NAME_PORT)
  private Integer port;

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef() {
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef group(String group) {
    this.group = group;
    return this;
  }

   /**
   * Group is the group of the referent. For example, \&quot;gateway.networking.k8s.io\&quot;. When unspecified or empty string, core API group is inferred.
   * @return group
  **/
  @jakarta.annotation.Nullable
  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef kind(String kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Kind is the Kubernetes resource kind of the referent. For example \&quot;Service\&quot;.   Defaults to \&quot;Service\&quot; when not specified.   ExternalName services can refer to CNAME DNS records that may live outside of the cluster and as such are difficult to reason about in terms of conformance. They also may not be safe to forward to (see CVE-2021-25740 for more information). Implementations SHOULD NOT support ExternalName Services.   Support: Core (Services with a type other than ExternalName)   Support: Implementation-specific (Services with type ExternalName)
   * @return kind
  **/
  @jakarta.annotation.Nullable
  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name is the name of the referent.
   * @return name
  **/
  @jakarta.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * Namespace is the namespace of the backend. When unspecified, the local namespace is inferred.   Note that when a namespace different than the local namespace is specified, a ReferenceGrant object is required in the referent namespace to allow that namespace&#39;s owner to accept the reference. See the ReferenceGrant documentation for details.   Support: Core
   * @return namespace
  **/
  @jakarta.annotation.Nullable
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Port specifies the destination port number to use for this resource. Port is required when the referent is a Kubernetes Service. In this case, the port number is the service port number, not the target port. For other resources, destination port might be derived from the referent resource or this field.
   * minimum: 1
   * maximum: 65535
   * @return port
  **/
  @jakarta.annotation.Nullable
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef = (V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef) o;
    return Objects.equals(this.group, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.group) &&
        Objects.equals(this.kind, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.kind) &&
        Objects.equals(this.name, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.name) &&
        Objects.equals(this.namespace, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.namespace) &&
        Objects.equals(this.port, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.port);
  }

  @Override
  public int hashCode() {
    return Objects.hash(group, kind, name, namespace, port);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef {\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("group");
    openapiFields.add("kind");
    openapiFields.add("name");
    openapiFields.add("namespace");
    openapiFields.add("port");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("group") != null && !jsonObj.get("group").isJsonNull()) && !jsonObj.get("group").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `group` to be a primitive type in the JSON string but got `%s`", jsonObj.get("group").toString()));
      }
      if ((jsonObj.get("kind") != null && !jsonObj.get("kind").isJsonNull()) && !jsonObj.get("kind").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `kind` to be a primitive type in the JSON string but got `%s`", jsonObj.get("kind").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("namespace") != null && !jsonObj.get("namespace").isJsonNull()) && !jsonObj.get("namespace").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `namespace` to be a primitive type in the JSON string but got `%s`", jsonObj.get("namespace").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef
  */
  public static V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestMirrorBackendRef to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

