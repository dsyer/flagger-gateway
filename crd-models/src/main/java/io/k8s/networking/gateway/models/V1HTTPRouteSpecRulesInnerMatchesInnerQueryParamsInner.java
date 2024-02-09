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
 * HTTPQueryParamMatch describes how to select a HTTP route by matching HTTP query parameters.
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  /**
   * Type specifies how to match against the value of the query parameter.   Support: Extended (Exact)   Support: Implementation-specific (RegularExpression)   Since RegularExpression QueryParamMatchType has Implementation-specific conformance, implementations can support POSIX, PCRE or any other dialects of regular expressions. Please read the implementation&#39;s documentation to determine the supported dialect.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    EXACT("Exact"),
    
    REGULAREXPRESSION("RegularExpression");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      TypeEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner() {
  }

  public V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name is the name of the HTTP query param to be matched. This must be an exact string match. (See https://tools.ietf.org/html/rfc7230#section-2.7.3).   If multiple entries specify equivalent query param names, only the first entry with an equivalent name MUST be considered for a match. Subsequent entries with an equivalent query param name MUST be ignored.   If a query param is repeated in an HTTP request, the behavior is purposely left undefined, since different data planes have different capabilities. However, it is *recommended* that implementations should match against the first value of the param if the data plane supports it, as this behavior is expected in other load balancing contexts outside of the Gateway API.   Users SHOULD NOT route traffic based on repeated query params to guard themselves against potential differences in the implementations.
   * @return name
  **/
  @jakarta.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type specifies how to match against the value of the query parameter.   Support: Extended (Exact)   Support: Implementation-specific (RegularExpression)   Since RegularExpression QueryParamMatchType has Implementation-specific conformance, implementations can support POSIX, PCRE or any other dialects of regular expressions. Please read the implementation&#39;s documentation to determine the supported dialect.
   * @return type
  **/
  @jakarta.annotation.Nullable
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  public V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Value is the value of HTTP query param to be matched.
   * @return value
  **/
  @jakarta.annotation.Nonnull
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner v1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner = (V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner) o;
    return Objects.equals(this.name, v1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.name) &&
        Objects.equals(this.type, v1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.type) &&
        Objects.equals(this.value, v1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("type");
    openapiFields.add("value");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("value");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      // validate the optional field `type`
      if (jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) {
        TypeEnum.validateJsonElement(jsonObj.get("type"));
      }
      if (!jsonObj.get("value").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner
  */
  public static V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

