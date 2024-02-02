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
 * ExtensionRef is an optional, implementation-specific extension to the \&quot;filter\&quot; behavior.  For example, resource \&quot;myroutefilter\&quot; in group \&quot;networking.example.net\&quot;). ExtensionRef MUST NOT be used for core and extended filters.   This filter can be used multiple times within the same rule.   Support: Implementation-specific
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef {
  public static final String SERIALIZED_NAME_GROUP = "group";
  @SerializedName(SERIALIZED_NAME_GROUP)
  private String group;

  public static final String SERIALIZED_NAME_KIND = "kind";
  @SerializedName(SERIALIZED_NAME_KIND)
  private String kind;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef() {
  }

  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef group(String group) {
    
    this.group = group;
    return this;
  }

   /**
   * Group is the group of the referent. For example, \&quot;gateway.networking.k8s.io\&quot;. When unspecified or empty string, core API group is inferred.
   * @return group
  **/
  @javax.annotation.Nonnull

  public String getGroup() {
    return group;
  }


  public void setGroup(String group) {
    this.group = group;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef kind(String kind) {
    
    this.kind = kind;
    return this;
  }

   /**
   * Kind is kind of the referent. For example \&quot;HTTPRoute\&quot; or \&quot;Service\&quot;.
   * @return kind
  **/
  @javax.annotation.Nonnull

  public String getKind() {
    return kind;
  }


  public void setKind(String kind) {
    this.kind = kind;
  }


  public HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name is the name of the referent.
   * @return name
  **/
  @javax.annotation.Nonnull

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef = (HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef) o;
    return Objects.equals(this.group, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef.group) &&
        Objects.equals(this.kind, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef.kind) &&
        Objects.equals(this.name, htTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(group, kind, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerExtensionRef {\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
