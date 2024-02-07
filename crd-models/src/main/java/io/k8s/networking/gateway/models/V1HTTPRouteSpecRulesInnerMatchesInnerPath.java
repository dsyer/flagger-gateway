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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

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
import java.util.Map.Entry;
import java.util.Set;

import io.kubernetes.client.openapi.JSON;

/**
 * Path specifies a HTTP request path matcher. If this field is not specified, a default prefix match on the \&quot;/\&quot; path is provided.
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerMatchesInnerPath {
  /**
   * Type specifies how to match against the path Value.   Support: Core (Exact, PathPrefix)   Support: Implementation-specific (RegularExpression)
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    EXACT("Exact"),
    
    PATHPREFIX("PathPrefix"),
    
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
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public V1HTTPRouteSpecRulesInnerMatchesInnerPath() {
  }

  public V1HTTPRouteSpecRulesInnerMatchesInnerPath type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Type specifies how to match against the path Value.   Support: Core (Exact, PathPrefix)   Support: Implementation-specific (RegularExpression)
   * @return type
  **/
  @jakarta.annotation.Nullable
  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  public V1HTTPRouteSpecRulesInnerMatchesInnerPath value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Value of the HTTP path to match against.
   * @return value
  **/
  @jakarta.annotation.Nullable
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
    V1HTTPRouteSpecRulesInnerMatchesInnerPath v1HTTPRouteSpecRulesInnerMatchesInnerPath = (V1HTTPRouteSpecRulesInnerMatchesInnerPath) o;
    return Objects.equals(this.type, v1HTTPRouteSpecRulesInnerMatchesInnerPath.type) &&
        Objects.equals(this.value, v1HTTPRouteSpecRulesInnerMatchesInnerPath.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerMatchesInnerPath {\n");
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
    openapiFields.add("type");
    openapiFields.add("value");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to V1HTTPRouteSpecRulesInnerMatchesInnerPath
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!V1HTTPRouteSpecRulesInnerMatchesInnerPath.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerMatchesInnerPath is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerMatchesInnerPath.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerMatchesInnerPath.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerMatchesInnerPath` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("value") != null && !jsonObj.get("value").isJsonNull()) && !jsonObj.get("value").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerMatchesInnerPath.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerMatchesInnerPath' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerMatchesInnerPath> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerMatchesInnerPath.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerMatchesInnerPath>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerMatchesInnerPath value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerMatchesInnerPath read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerMatchesInnerPath given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerMatchesInnerPath
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerMatchesInnerPath
  */
  public static V1HTTPRouteSpecRulesInnerMatchesInnerPath fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerMatchesInnerPath.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerMatchesInnerPath to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

