/*
 * HTTPRoute
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1alpha1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.kubernetes.client.examples.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * Path defines parameters used to modify the path of the incoming request. The modified path is then used to construct the &#x60;Location&#x60; header. When empty, the request path is used as-is.   Support: Extended
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath {
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
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath() {
  }

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath replaceFullPath(String replaceFullPath) {
    
    this.replaceFullPath = replaceFullPath;
    return this;
  }

   /**
   * ReplaceFullPath specifies the value with which to replace the full path of a request during a rewrite or redirect.
   * @return replaceFullPath
  **/
  @javax.annotation.Nullable

  public String getReplaceFullPath() {
    return replaceFullPath;
  }


  public void setReplaceFullPath(String replaceFullPath) {
    this.replaceFullPath = replaceFullPath;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath replacePrefixMatch(String replacePrefixMatch) {
    
    this.replacePrefixMatch = replacePrefixMatch;
    return this;
  }

   /**
   * ReplacePrefixMatch specifies the value with which to replace the prefix match of a request during a rewrite or redirect. For example, a request to \&quot;/foo/bar\&quot; with a prefix match of \&quot;/foo\&quot; and a ReplacePrefixMatch of \&quot;/xyz\&quot; would be modified to \&quot;/xyz/bar\&quot;.   Note that this matches the behavior of the PathPrefix match type. This matches full path elements. A path element refers to the list of labels in the path split by the &#x60;/&#x60; separator. When specified, a trailing &#x60;/&#x60; is ignored. For example, the paths &#x60;/abc&#x60;, &#x60;/abc/&#x60;, and &#x60;/abc/def&#x60; would all match the prefix &#x60;/abc&#x60;, but the path &#x60;/abcd&#x60; would not.   ReplacePrefixMatch is only compatible with a &#x60;PathPrefix&#x60; HTTPRouteMatch. Using any other HTTPRouteMatch type on the same HTTPRouteRule will result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;.   Request Path | Prefix Match | Replace Prefix | Modified Path -------------|--------------|----------------|---------- /foo/bar     | /foo         | /xyz           | /xyz/bar /foo/bar     | /foo         | /xyz/          | /xyz/bar /foo/bar     | /foo/        | /xyz           | /xyz/bar /foo/bar     | /foo/        | /xyz/          | /xyz/bar /foo         | /foo         | /xyz           | /xyz /foo/        | /foo         | /xyz           | /xyz/ /foo/bar     | /foo         | &lt;empty string&gt; | /bar /foo/        | /foo         | &lt;empty string&gt; | / /foo         | /foo         | &lt;empty string&gt; | / /foo/        | /foo         | /              | / /foo         | /foo         | /              | /
   * @return replacePrefixMatch
  **/
  @javax.annotation.Nullable

  public String getReplacePrefixMatch() {
    return replacePrefixMatch;
  }


  public void setReplacePrefixMatch(String replacePrefixMatch) {
    this.replacePrefixMatch = replacePrefixMatch;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Type defines the type of path modifier. Additional types may be added in a future release of the API.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.
   * @return type
  **/
  @javax.annotation.Nonnull

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
    HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath = (HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath) o;
    return Objects.equals(this.replaceFullPath, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.replaceFullPath) &&
        Objects.equals(this.replacePrefixMatch, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.replacePrefixMatch) &&
        Objects.equals(this.type, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replaceFullPath, replacePrefixMatch, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath {\n");
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

}

