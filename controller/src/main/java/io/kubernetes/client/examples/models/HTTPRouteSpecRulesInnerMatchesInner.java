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
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerMatchesInnerHeadersInner;
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerMatchesInnerPath;
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HTTPRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.   For example, the match below will match a HTTP request only if its path starts with &#x60;/foo&#x60; AND it contains the &#x60;version: v1&#x60; header:   &#x60;&#x60;&#x60; match:    path:    value: \&quot;/foo\&quot;  headers:  - name: \&quot;version\&quot;    value \&quot;v1\&quot;   &#x60;&#x60;&#x60;
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HTTPRouteSpecRulesInnerMatchesInner {
  public static final String SERIALIZED_NAME_HEADERS = "headers";
  @SerializedName(SERIALIZED_NAME_HEADERS)
  private List<HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> headers;

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
  }

  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  private MethodEnum method;

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private HTTPRouteSpecRulesInnerMatchesInnerPath path;

  public static final String SERIALIZED_NAME_QUERY_PARAMS = "queryParams";
  @SerializedName(SERIALIZED_NAME_QUERY_PARAMS)
  private List<HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> queryParams;

  public HTTPRouteSpecRulesInnerMatchesInner() {
  }

  public HTTPRouteSpecRulesInnerMatchesInner headers(List<HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> headers) {
    
    this.headers = headers;
    return this;
  }

  public HTTPRouteSpecRulesInnerMatchesInner addHeadersItem(HTTPRouteSpecRulesInnerMatchesInnerHeadersInner headersItem) {
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
  @javax.annotation.Nullable

  public List<HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> getHeaders() {
    return headers;
  }


  public void setHeaders(List<HTTPRouteSpecRulesInnerMatchesInnerHeadersInner> headers) {
    this.headers = headers;
  }


  public HTTPRouteSpecRulesInnerMatchesInner method(MethodEnum method) {
    
    this.method = method;
    return this;
  }

   /**
   * Method specifies HTTP method matcher. When specified, this route will be matched only if the request has the specified method.   Support: Extended
   * @return method
  **/
  @javax.annotation.Nullable

  public MethodEnum getMethod() {
    return method;
  }


  public void setMethod(MethodEnum method) {
    this.method = method;
  }


  public HTTPRouteSpecRulesInnerMatchesInner path(HTTPRouteSpecRulesInnerMatchesInnerPath path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable

  public HTTPRouteSpecRulesInnerMatchesInnerPath getPath() {
    return path;
  }


  public void setPath(HTTPRouteSpecRulesInnerMatchesInnerPath path) {
    this.path = path;
  }


  public HTTPRouteSpecRulesInnerMatchesInner queryParams(List<HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> queryParams) {
    
    this.queryParams = queryParams;
    return this;
  }

  public HTTPRouteSpecRulesInnerMatchesInner addQueryParamsItem(HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner queryParamsItem) {
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
  @javax.annotation.Nullable

  public List<HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> getQueryParams() {
    return queryParams;
  }


  public void setQueryParams(List<HTTPRouteSpecRulesInnerMatchesInnerQueryParamsInner> queryParams) {
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
    HTTPRouteSpecRulesInnerMatchesInner htTPRouteSpecRulesInnerMatchesInner = (HTTPRouteSpecRulesInnerMatchesInner) o;
    return Objects.equals(this.headers, htTPRouteSpecRulesInnerMatchesInner.headers) &&
        Objects.equals(this.method, htTPRouteSpecRulesInnerMatchesInner.method) &&
        Objects.equals(this.path, htTPRouteSpecRulesInnerMatchesInner.path) &&
        Objects.equals(this.queryParams, htTPRouteSpecRulesInnerMatchesInner.queryParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headers, method, path, queryParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HTTPRouteSpecRulesInnerMatchesInner {\n");
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

}
