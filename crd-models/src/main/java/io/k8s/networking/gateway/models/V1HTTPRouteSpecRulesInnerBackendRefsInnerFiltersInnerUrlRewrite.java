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
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewritePath;
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
 * URLRewrite defines a schema for a filter that modifies a request during forwarding.   Support: Extended
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite {
  public static final String SERIALIZED_NAME_HOSTNAME = "hostname";
  @SerializedName(SERIALIZED_NAME_HOSTNAME)
  private String hostname;

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewritePath path;

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite() {
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Hostname is the value to be used to replace the Host header value during forwarding.   Support: Extended
   * @return hostname
  **/
  @jakarta.annotation.Nullable
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite path(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewritePath path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @jakarta.annotation.Nullable
  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewritePath getPath() {
    return path;
  }

  public void setPath(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewritePath path) {
    this.path = path;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite = (V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite) o;
    return Objects.equals(this.hostname, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.hostname) &&
        Objects.equals(this.path, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite {\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
    openapiFields.add("hostname");
    openapiFields.add("path");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("hostname") != null && !jsonObj.get("hostname").isJsonNull()) && !jsonObj.get("hostname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `hostname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("hostname").toString()));
      }
      // validate the optional field `path`
      if (jsonObj.get("path") != null && !jsonObj.get("path").isJsonNull()) {
        V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewritePath.validateJsonElement(jsonObj.get("path"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite
  */
  public static V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerUrlRewrite to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

