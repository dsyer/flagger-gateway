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
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerMatchesInnerPath;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner;
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
 * HTTPRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.   For example, the match below will match a HTTP request only if its path starts with &#x60;/foo&#x60; AND it contains the &#x60;version: v1&#x60; header:   &#x60;&#x60;&#x60; match:    path:    value: \&quot;/foo\&quot;  headers:  - name: \&quot;version\&quot;    value \&quot;v1\&quot;   &#x60;&#x60;&#x60;
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerMatchesInner {
  public static final String SERIALIZED_NAME_HEADERS = "headers";
  @SerializedName(SERIALIZED_NAME_HEADERS)
  private List<V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> headers;

  /**
   * Method specifies HTTP method matcher. When specified, this route will be matched only if the request has the specified method.   Support: Extended
   */
  @JsonAdapter(MethodEnum.Adapter.class)
  public enum MethodEnum {
    GET("GET"),
    
    HEAD("HEAD"),
    
    POST("POST"),
    
    PUT("PUT"),
    
    DELETE("DELETE"),
    
    CONNECT("CONNECT"),
    
    OPTIONS("OPTIONS"),
    
    TRACE("TRACE"),
    
    PATCH("PATCH");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MethodEnum fromValue(String value) {
      for (MethodEnum b : MethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MethodEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      MethodEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  private MethodEnum method;

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private V1HTTPRouteSpecRulesInnerMatchesInnerPath path;

  public static final String SERIALIZED_NAME_QUERY_PARAMS = "queryParams";
  @SerializedName(SERIALIZED_NAME_QUERY_PARAMS)
  private List<V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> queryParams;

  public V1HTTPRouteSpecRulesInnerMatchesInner() {
  }

  public V1HTTPRouteSpecRulesInnerMatchesInner headers(List<V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> headers) {
    this.headers = headers;
    return this;
  }

  public V1HTTPRouteSpecRulesInnerMatchesInner addHeadersItem(V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner headersItem) {
    if (this.headers == null) {
      this.headers = new ArrayList<>();
    }
    this.headers.add(headersItem);
    return this;
  }

   /**
   * Headers specifies HTTP request header matchers. Multiple match values are ANDed together, meaning, a request must match all the specified headers to select the route.
   * @return headers
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> getHeaders() {
    return headers;
  }

  public void setHeaders(List<V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> headers) {
    this.headers = headers;
  }


  public V1HTTPRouteSpecRulesInnerMatchesInner method(MethodEnum method) {
    this.method = method;
    return this;
  }

   /**
   * Method specifies HTTP method matcher. When specified, this route will be matched only if the request has the specified method.   Support: Extended
   * @return method
  **/
  @jakarta.annotation.Nullable
  public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }


  public V1HTTPRouteSpecRulesInnerMatchesInner path(V1HTTPRouteSpecRulesInnerMatchesInnerPath path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @jakarta.annotation.Nullable
  public V1HTTPRouteSpecRulesInnerMatchesInnerPath getPath() {
    return path;
  }

  public void setPath(V1HTTPRouteSpecRulesInnerMatchesInnerPath path) {
    this.path = path;
  }


  public V1HTTPRouteSpecRulesInnerMatchesInner queryParams(List<V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> queryParams) {
    this.queryParams = queryParams;
    return this;
  }

  public V1HTTPRouteSpecRulesInnerMatchesInner addQueryParamsItem(V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner queryParamsItem) {
    if (this.queryParams == null) {
      this.queryParams = new ArrayList<>();
    }
    this.queryParams.add(queryParamsItem);
    return this;
  }

   /**
   * QueryParams specifies HTTP query parameter matchers. Multiple match values are ANDed together, meaning, a request must match all the specified query parameters to select the route.   Support: Extended
   * @return queryParams
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> getQueryParams() {
    return queryParams;
  }

  public void setQueryParams(List<V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> queryParams) {
    this.queryParams = queryParams;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInnerMatchesInner v1HTTPRouteSpecRulesInnerMatchesInner = (V1HTTPRouteSpecRulesInnerMatchesInner) o;
    return Objects.equals(this.headers, v1HTTPRouteSpecRulesInnerMatchesInner.headers) &&
        Objects.equals(this.method, v1HTTPRouteSpecRulesInnerMatchesInner.method) &&
        Objects.equals(this.path, v1HTTPRouteSpecRulesInnerMatchesInner.path) &&
        Objects.equals(this.queryParams, v1HTTPRouteSpecRulesInnerMatchesInner.queryParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headers, method, path, queryParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerMatchesInner {\n");
    sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    queryParams: ").append(toIndentedString(queryParams)).append("\n");
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
    openapiFields.add("headers");
    openapiFields.add("method");
    openapiFields.add("path");
    openapiFields.add("queryParams");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1HTTPRouteSpecRulesInnerMatchesInner
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1HTTPRouteSpecRulesInnerMatchesInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerMatchesInner is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerMatchesInner.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerMatchesInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerMatchesInner` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("headers") != null && !jsonObj.get("headers").isJsonNull()) {
        JsonArray jsonArrayheaders = jsonObj.getAsJsonArray("headers");
        if (jsonArrayheaders != null) {
          // ensure the json data is an array
          if (!jsonObj.get("headers").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `headers` to be an array in the JSON string but got `%s`", jsonObj.get("headers").toString()));
          }

          // validate the optional field `headers` (array)
          for (int i = 0; i < jsonArrayheaders.size(); i++) {
            V1HTTPRouteSpecRulesInnerMatchesInnerHeadersInner.validateJsonElement(jsonArrayheaders.get(i));
          };
        }
      }
      if ((jsonObj.get("method") != null && !jsonObj.get("method").isJsonNull()) && !jsonObj.get("method").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `method` to be a primitive type in the JSON string but got `%s`", jsonObj.get("method").toString()));
      }
      // validate the optional field `method`
      if (jsonObj.get("method") != null && !jsonObj.get("method").isJsonNull()) {
        MethodEnum.validateJsonElement(jsonObj.get("method"));
      }
      // validate the optional field `path`
      if (jsonObj.get("path") != null && !jsonObj.get("path").isJsonNull()) {
        V1HTTPRouteSpecRulesInnerMatchesInnerPath.validateJsonElement(jsonObj.get("path"));
      }
      if (jsonObj.get("queryParams") != null && !jsonObj.get("queryParams").isJsonNull()) {
        JsonArray jsonArrayqueryParams = jsonObj.getAsJsonArray("queryParams");
        if (jsonArrayqueryParams != null) {
          // ensure the json data is an array
          if (!jsonObj.get("queryParams").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `queryParams` to be an array in the JSON string but got `%s`", jsonObj.get("queryParams").toString()));
          }

          // validate the optional field `queryParams` (array)
          for (int i = 0; i < jsonArrayqueryParams.size(); i++) {
            V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.validateJsonElement(jsonArrayqueryParams.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerMatchesInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerMatchesInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerMatchesInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerMatchesInner.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerMatchesInner>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerMatchesInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerMatchesInner read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerMatchesInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerMatchesInner
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerMatchesInner
  */
  public static V1HTTPRouteSpecRulesInnerMatchesInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerMatchesInner.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerMatchesInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
