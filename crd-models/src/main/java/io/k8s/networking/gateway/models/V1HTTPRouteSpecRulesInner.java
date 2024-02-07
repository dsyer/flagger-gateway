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
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerBackendRefsInner;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerMatchesInner;
import java.io.IOException;
import java.util.ArrayList;
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
import java.util.Map.Entry;
import java.util.Set;

import io.kubernetes.client.openapi.JSON;

/**
 * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInner {
  public static final String SERIALIZED_NAME_BACKEND_REFS = "backendRefs";
  @SerializedName(SERIALIZED_NAME_BACKEND_REFS)
  private List<V1HTTPRouteSpecRulesInnerBackendRefsInner> backendRefs;

  public static final String SERIALIZED_NAME_FILTERS = "filters";
  @SerializedName(SERIALIZED_NAME_FILTERS)
  private List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner> filters;

  public static final String SERIALIZED_NAME_MATCHES = "matches";
  @SerializedName(SERIALIZED_NAME_MATCHES)
  private List<V1HTTPRouteSpecRulesInnerMatchesInner> matches;

  public V1HTTPRouteSpecRulesInner() {
  }

  public V1HTTPRouteSpecRulesInner backendRefs(List<V1HTTPRouteSpecRulesInnerBackendRefsInner> backendRefs) {
    
    this.backendRefs = backendRefs;
    return this;
  }

  public V1HTTPRouteSpecRulesInner addBackendRefsItem(V1HTTPRouteSpecRulesInnerBackendRefsInner backendRefsItem) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList<>();
    }
    this.backendRefs.add(backendRefsItem);
    return this;
  }

   /**
   * BackendRefs defines the backend(s) where matching requests should be sent.   Failure behavior here depends on how many BackendRefs are specified and how many are invalid.   If *all* entries in BackendRefs are invalid, and there are also no filters specified in this route rule, *all* traffic which matches this rule MUST receive a 500 status code.   See the HTTPBackendRef definition for the rules about what makes a single HTTPBackendRef invalid.   When a HTTPBackendRef is invalid, 500 status codes MUST be returned for requests that would have otherwise been routed to an invalid backend. If multiple backends are specified, and some are invalid, the proportion of requests that would otherwise have been routed to an invalid backend MUST receive a 500 status code.   For example, if two backends are specified with equal weights, and one is invalid, 50 percent of traffic must receive a 500. Implementations may choose how that 50 percent is determined.   Support: Core for Kubernetes Service   Support: Extended for Kubernetes ServiceImport   Support: Implementation-specific for any other resource   Support for weight: Core
   * @return backendRefs
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerBackendRefsInner> getBackendRefs() {
    return backendRefs;
  }


  public void setBackendRefs(List<V1HTTPRouteSpecRulesInnerBackendRefsInner> backendRefs) {
    this.backendRefs = backendRefs;
  }


  public V1HTTPRouteSpecRulesInner filters(List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner> filters) {
    
    this.filters = filters;
    return this;
  }

  public V1HTTPRouteSpecRulesInner addFiltersItem(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner filtersItem) {
    if (this.filters == null) {
      this.filters = new ArrayList<>();
    }
    this.filters.add(filtersItem);
    return this;
  }

   /**
   * Filters define the filters that are applied to requests that match this rule.   Wherever possible, implementations SHOULD implement filters in the order they are specified.   Implementations MAY choose to implement this ordering strictly, rejecting any combination or order of filters that can not be supported. If implementations choose a strict interpretation of filter ordering, they MUST clearly document that behavior.   To reject an invalid combination or order of filters, implementations SHOULD consider the Route Rules with this configuration invalid. If all Route Rules in a Route are invalid, the entire Route would be considered invalid. If only a portion of Route Rules are invalid, implementations MUST set the \&quot;PartiallyInvalid\&quot; condition for the Route.   Conformance-levels at this level are defined based on the type of filter:   - ALL core filters MUST be supported by all implementations. - Implementers are encouraged to support extended filters. - Implementation-specific custom filters have no API guarantees across   implementations.   Specifying the same filter multiple times is not supported unless explicitly indicated in the filter.   All filters are expected to be compatible with each other except for the URLRewrite and RequestRedirect filters, which may not be combined. If an implementation can not support other combinations of filters, they must clearly document that limitation. In cases where incompatible or unsupported filters are specified and cause the &#x60;Accepted&#x60; condition to be set to status &#x60;False&#x60;, implementations may use the &#x60;IncompatibleFilters&#x60; reason to specify this configuration error.   Support: Core
   * @return filters
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner> getFilters() {
    return filters;
  }


  public void setFilters(List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner> filters) {
    this.filters = filters;
  }


  public V1HTTPRouteSpecRulesInner matches(List<V1HTTPRouteSpecRulesInnerMatchesInner> matches) {
    
    this.matches = matches;
    return this;
  }

  public V1HTTPRouteSpecRulesInner addMatchesItem(V1HTTPRouteSpecRulesInnerMatchesInner matchesItem) {
    if (this.matches == null) {
      this.matches = new ArrayList<>();
    }
    this.matches.add(matchesItem);
    return this;
  }

   /**
   * Matches define conditions used for matching the rule against incoming HTTP requests. Each match is independent, i.e. this rule will be matched if **any** one of the matches is satisfied.   For example, take the following matches configuration:   &#x60;&#x60;&#x60; matches: - path:     value: \&quot;/foo\&quot;   headers:   - name: \&quot;version\&quot;     value: \&quot;v2\&quot; - path:     value: \&quot;/v2/foo\&quot; &#x60;&#x60;&#x60;   For a request to match against this rule, a request must satisfy EITHER of the two conditions:   - path prefixed with &#x60;/foo&#x60; AND contains the header &#x60;version: v2&#x60; - path prefix of &#x60;/v2/foo&#x60;   See the documentation for HTTPRouteMatch on how to specify multiple match conditions that should be ANDed together.   If no matches are specified, the default is a prefix path match on \&quot;/\&quot;, which has the effect of matching every HTTP request.   Proxy or Load Balancer routing configuration generated from HTTPRoutes MUST prioritize matches based on the following criteria, continuing on ties. Across all rules specified on applicable Routes, precedence must be given to the match having:   * \&quot;Exact\&quot; path match. * \&quot;Prefix\&quot; path match with largest number of characters. * Method match. * Largest number of header matches. * Largest number of query param matches.   Note: The precedence of RegularExpression path matches are implementation-specific.   If ties still exist across multiple Routes, matching precedence MUST be determined in order of the following criteria, continuing on ties:   * The oldest Route based on creation timestamp. * The Route appearing first in alphabetical order by   \&quot;{namespace}/{name}\&quot;.   If ties still exist within an HTTPRoute, matching precedence MUST be granted to the FIRST matching rule (in list order) with a match meeting the above criteria.   When no rules matching a request have been successfully attached to the parent a request is coming from, a HTTP 404 status code MUST be returned.
   * @return matches
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerMatchesInner> getMatches() {
    return matches;
  }


  public void setMatches(List<V1HTTPRouteSpecRulesInnerMatchesInner> matches) {
    this.matches = matches;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInner v1HTTPRouteSpecRulesInner = (V1HTTPRouteSpecRulesInner) o;
    return Objects.equals(this.backendRefs, v1HTTPRouteSpecRulesInner.backendRefs) &&
        Objects.equals(this.filters, v1HTTPRouteSpecRulesInner.filters) &&
        Objects.equals(this.matches, v1HTTPRouteSpecRulesInner.matches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(backendRefs, filters, matches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInner {\n");
    sb.append("    backendRefs: ").append(toIndentedString(backendRefs)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    matches: ").append(toIndentedString(matches)).append("\n");
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
    openapiFields.add("backendRefs");
    openapiFields.add("filters");
    openapiFields.add("matches");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to V1HTTPRouteSpecRulesInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!V1HTTPRouteSpecRulesInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInner is not found in the empty JSON string", V1HTTPRouteSpecRulesInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("backendRefs") != null && !jsonObj.get("backendRefs").isJsonNull()) {
        JsonArray jsonArraybackendRefs = jsonObj.getAsJsonArray("backendRefs");
        if (jsonArraybackendRefs != null) {
          // ensure the json data is an array
          if (!jsonObj.get("backendRefs").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `backendRefs` to be an array in the JSON string but got `%s`", jsonObj.get("backendRefs").toString()));
          }

          // validate the optional field `backendRefs` (array)
          for (int i = 0; i < jsonArraybackendRefs.size(); i++) {
            V1HTTPRouteSpecRulesInnerBackendRefsInner.validateJsonObject(jsonArraybackendRefs.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("filters") != null && !jsonObj.get("filters").isJsonNull()) {
        JsonArray jsonArrayfilters = jsonObj.getAsJsonArray("filters");
        if (jsonArrayfilters != null) {
          // ensure the json data is an array
          if (!jsonObj.get("filters").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `filters` to be an array in the JSON string but got `%s`", jsonObj.get("filters").toString()));
          }

          // validate the optional field `filters` (array)
          for (int i = 0; i < jsonArrayfilters.size(); i++) {
            V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInner.validateJsonObject(jsonArrayfilters.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("matches") != null && !jsonObj.get("matches").isJsonNull()) {
        JsonArray jsonArraymatches = jsonObj.getAsJsonArray("matches");
        if (jsonArraymatches != null) {
          // ensure the json data is an array
          if (!jsonObj.get("matches").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `matches` to be an array in the JSON string but got `%s`", jsonObj.get("matches").toString()));
          }

          // validate the optional field `matches` (array)
          for (int i = 0; i < jsonArraymatches.size(); i++) {
            V1HTTPRouteSpecRulesInnerMatchesInner.validateJsonObject(jsonArraymatches.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInner.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInner>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInner
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInner
  */
  public static V1HTTPRouteSpecRulesInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInner.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

