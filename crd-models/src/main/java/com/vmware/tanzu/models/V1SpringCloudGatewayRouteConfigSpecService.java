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


package com.vmware.tanzu.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Kubernetes Service to route traffic to specified &#x60;spec.routes&#x60;.
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1SpringCloudGatewayRouteConfigSpecService {
  public static final String SERIALIZED_NAME_FILTERS = "filters";
  @SerializedName(SERIALIZED_NAME_FILTERS)
  private List<String> filters;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NAMESPACE = "namespace";
  @SerializedName(SERIALIZED_NAME_NAMESPACE)
  private String namespace;

  public static final String SERIALIZED_NAME_PORT = "port";
  @SerializedName(SERIALIZED_NAME_PORT)
  private Integer port;

  public static final String SERIALIZED_NAME_PREDICATES = "predicates";
  @SerializedName(SERIALIZED_NAME_PREDICATES)
  private List<String> predicates;

  public static final String SERIALIZED_NAME_SSO_ENABLED = "ssoEnabled";
  @SerializedName(SERIALIZED_NAME_SSO_ENABLED)
  private Boolean ssoEnabled;

  public static final String SERIALIZED_NAME_TOKEN_RELAY = "tokenRelay";
  @SerializedName(SERIALIZED_NAME_TOKEN_RELAY)
  private Boolean tokenRelay;

  public static final String SERIALIZED_NAME_URI = "uri";
  @SerializedName(SERIALIZED_NAME_URI)
  private String uri;

  public V1SpringCloudGatewayRouteConfigSpecService() {
  }

  public V1SpringCloudGatewayRouteConfigSpecService filters(List<String> filters) {
    this.filters = filters;
    return this;
  }

  public V1SpringCloudGatewayRouteConfigSpecService addFiltersItem(String filtersItem) {
    if (this.filters == null) {
      this.filters = new ArrayList<>();
    }
    this.filters.add(filtersItem);
    return this;
  }

   /**
   * (Optional) Filters to be prepended to all routes.
   * @return filters
  **/
  @jakarta.annotation.Nullable
  public List<String> getFilters() {
    return filters;
  }

  public void setFilters(List<String> filters) {
    this.filters = filters;
  }


  public V1SpringCloudGatewayRouteConfigSpecService name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of a service to route to. Takes lower precedence than &#x60;uri&#x60;. Either &#x60;name&#x60; or &#x60;uri&#x60; are required unless all routes define their own uri. 
   * @return name
  **/
  @jakarta.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public V1SpringCloudGatewayRouteConfigSpecService namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * (Optional) If not set will use the RouteConfig&#39;s namespace.
   * @return namespace
  **/
  @jakarta.annotation.Nullable
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }


  public V1SpringCloudGatewayRouteConfigSpecService port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * (Optional) If not set will use one of the available service ports.
   * @return port
  **/
  @jakarta.annotation.Nullable
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }


  public V1SpringCloudGatewayRouteConfigSpecService predicates(List<String> predicates) {
    this.predicates = predicates;
    return this;
  }

  public V1SpringCloudGatewayRouteConfigSpecService addPredicatesItem(String predicatesItem) {
    if (this.predicates == null) {
      this.predicates = new ArrayList<>();
    }
    this.predicates.add(predicatesItem);
    return this;
  }

   /**
   * (Optional) Predicates to be prepended to all routes.
   * @return predicates
  **/
  @jakarta.annotation.Nullable
  public List<String> getPredicates() {
    return predicates;
  }

  public void setPredicates(List<String> predicates) {
    this.predicates = predicates;
  }


  public V1SpringCloudGatewayRouteConfigSpecService ssoEnabled(Boolean ssoEnabled) {
    this.ssoEnabled = ssoEnabled;
    return this;
  }

   /**
   * (Optional) Define SSO validation for all routes.
   * @return ssoEnabled
  **/
  @jakarta.annotation.Nullable
  public Boolean getSsoEnabled() {
    return ssoEnabled;
  }

  public void setSsoEnabled(Boolean ssoEnabled) {
    this.ssoEnabled = ssoEnabled;
  }


  public V1SpringCloudGatewayRouteConfigSpecService tokenRelay(Boolean tokenRelay) {
    this.tokenRelay = tokenRelay;
    return this;
  }

   /**
   * Pass currently-authenticated user&#39;s identity token to all routes.
   * @return tokenRelay
  **/
  @jakarta.annotation.Nullable
  public Boolean getTokenRelay() {
    return tokenRelay;
  }

  public void setTokenRelay(Boolean tokenRelay) {
    this.tokenRelay = tokenRelay;
  }


  public V1SpringCloudGatewayRouteConfigSpecService uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * A URI to apply to all routes. Takes precedence over name. Either &#x60;name&#x60; or &#x60;uri&#x60; are required unless all routes define their own uri. Routes can override this value. 
   * @return uri
  **/
  @jakarta.annotation.Nullable
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1SpringCloudGatewayRouteConfigSpecService v1SpringCloudGatewayRouteConfigSpecService = (V1SpringCloudGatewayRouteConfigSpecService) o;
    return Objects.equals(this.filters, v1SpringCloudGatewayRouteConfigSpecService.filters) &&
        Objects.equals(this.name, v1SpringCloudGatewayRouteConfigSpecService.name) &&
        Objects.equals(this.namespace, v1SpringCloudGatewayRouteConfigSpecService.namespace) &&
        Objects.equals(this.port, v1SpringCloudGatewayRouteConfigSpecService.port) &&
        Objects.equals(this.predicates, v1SpringCloudGatewayRouteConfigSpecService.predicates) &&
        Objects.equals(this.ssoEnabled, v1SpringCloudGatewayRouteConfigSpecService.ssoEnabled) &&
        Objects.equals(this.tokenRelay, v1SpringCloudGatewayRouteConfigSpecService.tokenRelay) &&
        Objects.equals(this.uri, v1SpringCloudGatewayRouteConfigSpecService.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filters, name, namespace, port, predicates, ssoEnabled, tokenRelay, uri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1SpringCloudGatewayRouteConfigSpecService {\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    predicates: ").append(toIndentedString(predicates)).append("\n");
    sb.append("    ssoEnabled: ").append(toIndentedString(ssoEnabled)).append("\n");
    sb.append("    tokenRelay: ").append(toIndentedString(tokenRelay)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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
    openapiFields.add("filters");
    openapiFields.add("name");
    openapiFields.add("namespace");
    openapiFields.add("port");
    openapiFields.add("predicates");
    openapiFields.add("ssoEnabled");
    openapiFields.add("tokenRelay");
    openapiFields.add("uri");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1SpringCloudGatewayRouteConfigSpecService
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1SpringCloudGatewayRouteConfigSpecService.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1SpringCloudGatewayRouteConfigSpecService is not found in the empty JSON string", V1SpringCloudGatewayRouteConfigSpecService.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1SpringCloudGatewayRouteConfigSpecService.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1SpringCloudGatewayRouteConfigSpecService` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("filters") != null && !jsonObj.get("filters").isJsonNull() && !jsonObj.get("filters").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `filters` to be an array in the JSON string but got `%s`", jsonObj.get("filters").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("namespace") != null && !jsonObj.get("namespace").isJsonNull()) && !jsonObj.get("namespace").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `namespace` to be a primitive type in the JSON string but got `%s`", jsonObj.get("namespace").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("predicates") != null && !jsonObj.get("predicates").isJsonNull() && !jsonObj.get("predicates").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `predicates` to be an array in the JSON string but got `%s`", jsonObj.get("predicates").toString()));
      }
      if ((jsonObj.get("uri") != null && !jsonObj.get("uri").isJsonNull()) && !jsonObj.get("uri").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `uri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uri").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1SpringCloudGatewayRouteConfigSpecService.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1SpringCloudGatewayRouteConfigSpecService' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1SpringCloudGatewayRouteConfigSpecService> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1SpringCloudGatewayRouteConfigSpecService.class));

       return (TypeAdapter<T>) new TypeAdapter<V1SpringCloudGatewayRouteConfigSpecService>() {
           @Override
           public void write(JsonWriter out, V1SpringCloudGatewayRouteConfigSpecService value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1SpringCloudGatewayRouteConfigSpecService read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1SpringCloudGatewayRouteConfigSpecService given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1SpringCloudGatewayRouteConfigSpecService
  * @throws IOException if the JSON string is invalid with respect to V1SpringCloudGatewayRouteConfigSpecService
  */
  public static V1SpringCloudGatewayRouteConfigSpecService fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1SpringCloudGatewayRouteConfigSpecService.class);
  }

 /**
  * Convert an instance of V1SpringCloudGatewayRouteConfigSpecService to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
