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
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath;
import java.io.IOException;

/**
 * RequestRedirect defines a schema for a filter that responds to the request with an HTTP redirection.   Support: Core
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect {
  public static final String SERIALIZED_NAME_HOSTNAME = "hostname";
  @SerializedName(SERIALIZED_NAME_HOSTNAME)
  private String hostname;

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath path;

  public static final String SERIALIZED_NAME_PORT = "port";
  @SerializedName(SERIALIZED_NAME_PORT)
  private Integer port;

  /**
   * Scheme is the scheme to be used in the value of the &#x60;Location&#x60; header in the response. When empty, the scheme of the request is used.   Scheme redirects can affect the port of the redirect, for more information, refer to the documentation for the port field of this filter.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.   Support: Extended
   */
  @JsonAdapter(SchemeEnum.Adapter.class)
  public enum SchemeEnum {
    HTTP("http"),
    
    HTTPS("https");

    private String value;

    SchemeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SchemeEnum fromValue(String value) {
      for (SchemeEnum b : SchemeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SchemeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SchemeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SchemeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SchemeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SCHEME = "scheme";
  @SerializedName(SERIALIZED_NAME_SCHEME)
  private SchemeEnum scheme;

  /**
   * StatusCode is the HTTP status code to be used in response.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.   Support: Core
   */
  @JsonAdapter(StatusCodeEnum.Adapter.class)
  public enum StatusCodeEnum {
    NUMBER_301(301),
    
    NUMBER_302(302);

    private Integer value;

    StatusCodeEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusCodeEnum fromValue(Integer value) {
      for (StatusCodeEnum b : StatusCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusCodeEnum read(final JsonReader jsonReader) throws IOException {
        Integer value =  jsonReader.nextInt();
        return StatusCodeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS_CODE = "statusCode";
  @SerializedName(SERIALIZED_NAME_STATUS_CODE)
  private StatusCodeEnum statusCode;

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect() {
  }

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect hostname(String hostname) {
    
    this.hostname = hostname;
    return this;
  }

   /**
   * Hostname is the hostname to be used in the value of the &#x60;Location&#x60; header in the response. When empty, the hostname in the &#x60;Host&#x60; header of the request is used.   Support: Core
   * @return hostname
  **/
  @javax.annotation.Nullable

  public String getHostname() {
    return hostname;
  }


  public void setHostname(String hostname) {
    this.hostname = hostname;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect path(HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath getPath() {
    return path;
  }


  public void setPath(HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirectPath path) {
    this.path = path;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect port(Integer port) {
    
    this.port = port;
    return this;
  }

   /**
   * Port is the port to be used in the value of the &#x60;Location&#x60; header in the response.   If no port is specified, the redirect port MUST be derived using the following rules:   * If redirect scheme is not-empty, the redirect port MUST be the well-known   port associated with the redirect scheme. Specifically \&quot;http\&quot; to port 80   and \&quot;https\&quot; to port 443. If the redirect scheme does not have a   well-known port, the listener port of the Gateway SHOULD be used. * If redirect scheme is empty, the redirect port MUST be the Gateway   Listener port.   Implementations SHOULD NOT add the port number in the &#39;Location&#39; header in the following cases:   * A Location header that will use HTTP (whether that is determined via   the Listener protocol or the Scheme field) _and_ use port 80. * A Location header that will use HTTPS (whether that is determined via   the Listener protocol or the Scheme field) _and_ use port 443.   Support: Extended
   * minimum: 1
   * maximum: 65535
   * @return port
  **/
  @javax.annotation.Nullable

  public Integer getPort() {
    return port;
  }


  public void setPort(Integer port) {
    this.port = port;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect scheme(SchemeEnum scheme) {
    
    this.scheme = scheme;
    return this;
  }

   /**
   * Scheme is the scheme to be used in the value of the &#x60;Location&#x60; header in the response. When empty, the scheme of the request is used.   Scheme redirects can affect the port of the redirect, for more information, refer to the documentation for the port field of this filter.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.   Support: Extended
   * @return scheme
  **/
  @javax.annotation.Nullable

  public SchemeEnum getScheme() {
    return scheme;
  }


  public void setScheme(SchemeEnum scheme) {
    this.scheme = scheme;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect statusCode(StatusCodeEnum statusCode) {
    
    this.statusCode = statusCode;
    return this;
  }

   /**
   * StatusCode is the HTTP status code to be used in response.   Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.   Unknown values here must result in the implementation setting the Accepted Condition for the Route to &#x60;status: False&#x60;, with a Reason of &#x60;UnsupportedValue&#x60;.   Support: Core
   * @return statusCode
  **/
  @javax.annotation.Nullable

  public StatusCodeEnum getStatusCode() {
    return statusCode;
  }


  public void setStatusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect = (HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect) o;
    return Objects.equals(this.hostname, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect.hostname) &&
        Objects.equals(this.path, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect.path) &&
        Objects.equals(this.port, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect.port) &&
        Objects.equals(this.scheme, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect.scheme) &&
        Objects.equals(this.statusCode, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect.statusCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, path, port, scheme, statusCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestRedirect {\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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
