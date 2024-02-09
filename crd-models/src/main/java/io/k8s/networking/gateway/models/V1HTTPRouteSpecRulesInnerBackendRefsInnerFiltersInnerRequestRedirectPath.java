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
 * Path defines parameters used to modify the path of the incoming request. The modified path is then used to construct the &#x60;Location&#x60; header. When empty, the request path is used as-is.   Support: Extended
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath {
  public static final String SERIALIZED_NAME_REPLACE_FULL_PATH = "replaceFullPath";
  @SerializedName(SERIALIZED_NAME_REPLACE_FULL_PATH)
  private String replaceFullPath;

  public static final String SERIALIZED_NAME_REPLACE_PREFIX_MATCH = "replacePrefixMatch";
  @SerializedName(SERIALIZED_NAME_REPLACE_PREFIX_MATCH)
  private String replacePrefixMatch;

  /**
   * Type defines the type of path modifier. Additional types may be added in a future release of the API.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    REPLACEFULLPATH("ReplaceFullPath"),
    
    REPLACEPREFIXMATCH("ReplacePrefixMatch");

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

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath() {
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath replaceFullPath(String replaceFullPath) {
    this.replaceFullPath = replaceFullPath;
    return this;
  }

   /**
   * ReplaceFullPath specifies the value with which to replace the full path of a request during a rewrite or redirect.
   * @return replaceFullPath
  **/
  @jakarta.annotation.Nullable
  public String getReplaceFullPath() {
    return replaceFullPath;
  }

  public void setReplaceFullPath(String replaceFullPath) {
    this.replaceFullPath = replaceFullPath;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath replacePrefixMatch(String replacePrefixMatch) {
    this.replacePrefixMatch = replacePrefixMatch;
    return this;
  }

   /**
   * ReplacePrefixMatch specifies the value with which to replace the prefix match of a request during a rewrite or redirect. For example, a request to \&quot;/foo/bar\&quot; with a prefix match of \&quot;/foo\&quot; and a ReplacePrefixMatch of \&quot;/xyz\&quot; would be modified to \&quot;/xyz/bar\&quot;.   Note that this matches the behavior of the PathPrefix match type. This matches full path elements. A path element refers to the list of labels in the path split by the &#x60;/&#x60; separator. When specified, a trailing &#x60;/&#x60; is ignored. For example, the paths &#x60;/abc&#x60;, &#x60;/abc/&#x60;, and &#x60;/abc/def&#x60; would all match the prefix &#x60;/abc&#x60;, but the path &#x60;/abcd&#x60; would not.   ReplacePrefixMatch is only compatible with a &#x60;PathPrefix&#x60; HTTPRouteMatch. Using any other HTTPRouteMatch type on the same HTTPRouteRule will result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;.   Request Path | Prefix Match | Replace Prefix | Modified Path -------------|--------------|----------------|---------- /foo/bar     | /foo         | /xyz           | /xyz/bar /foo/bar     | /foo         | /xyz/          | /xyz/bar /foo/bar     | /foo/        | /xyz           | /xyz/bar /foo/bar     | /foo/        | /xyz/          | /xyz/bar /foo         | /foo         | /xyz           | /xyz /foo/        | /foo         | /xyz           | /xyz/ /foo/bar     | /foo         | &lt;empty string&gt; | /bar /foo/        | /foo         | &lt;empty string&gt; | / /foo         | /foo         | &lt;empty string&gt; | / /foo/        | /foo         | /              | / /foo         | /foo         | /              | /
   * @return replacePrefixMatch
  **/
  @jakarta.annotation.Nullable
  public String getReplacePrefixMatch() {
    return replacePrefixMatch;
  }

  public void setReplacePrefixMatch(String replacePrefixMatch) {
    this.replacePrefixMatch = replacePrefixMatch;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type defines the type of path modifier. Additional types may be added in a future release of the API.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.
   * @return type
  **/
  @jakarta.annotation.Nonnull
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath = (V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath) o;
    return Objects.equals(this.replaceFullPath, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.replaceFullPath) &&
        Objects.equals(this.replacePrefixMatch, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.replacePrefixMatch) &&
        Objects.equals(this.type, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replaceFullPath, replacePrefixMatch, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath {\n");
    sb.append("    replaceFullPath: ").append(toIndentedString(replaceFullPath)).append("\n");
    sb.append("    replacePrefixMatch: ").append(toIndentedString(replacePrefixMatch)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
    openapiFields.add("replaceFullPath");
    openapiFields.add("replacePrefixMatch");
    openapiFields.add("type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("type");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("replaceFullPath") != null && !jsonObj.get("replaceFullPath").isJsonNull()) && !jsonObj.get("replaceFullPath").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `replaceFullPath` to be a primitive type in the JSON string but got `%s`", jsonObj.get("replaceFullPath").toString()));
      }
      if ((jsonObj.get("replacePrefixMatch") != null && !jsonObj.get("replacePrefixMatch").isJsonNull()) && !jsonObj.get("replacePrefixMatch").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `replacePrefixMatch` to be a primitive type in the JSON string but got `%s`", jsonObj.get("replacePrefixMatch").toString()));
      }
      if (!jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      // validate the required field `type`
      TypeEnum.validateJsonElement(jsonObj.get("type"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath
  */
  public static V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
