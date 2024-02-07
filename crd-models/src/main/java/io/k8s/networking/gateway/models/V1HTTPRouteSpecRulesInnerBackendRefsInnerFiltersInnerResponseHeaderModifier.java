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
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner;
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
 * ResponseHeaderModifier defines a schema for a filter that modifies response headers.   Support: Extended
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier {
  public static final String SERIALIZED_NAME_ADD = "add";
  @SerializedName(SERIALIZED_NAME_ADD)
  private List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> add;

  public static final String SERIALIZED_NAME_REMOVE = "remove";
  @SerializedName(SERIALIZED_NAME_REMOVE)
  private List<String> remove;

  public static final String SERIALIZED_NAME_SET = "set";
  @SerializedName(SERIALIZED_NAME_SET)
  private List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> set;

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier() {
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier add(List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> add) {
    
    this.add = add;
    return this;
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier addAddItem(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner addItem) {
    if (this.add == null) {
      this.add = new ArrayList<>();
    }
    this.add.add(addItem);
    return this;
  }

   /**
   * Add adds the given header(s) (name, value) to the request before the action. It appends to any existing values associated with the header name.   Input:   GET /foo HTTP/1.1   my-header: foo   Config:   add:   - name: \&quot;my-header\&quot;     value: \&quot;bar,baz\&quot;   Output:   GET /foo HTTP/1.1   my-header: foo,bar,baz
   * @return add
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> getAdd() {
    return add;
  }


  public void setAdd(List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> add) {
    this.add = add;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier remove(List<String> remove) {
    
    this.remove = remove;
    return this;
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier addRemoveItem(String removeItem) {
    if (this.remove == null) {
      this.remove = new ArrayList<>();
    }
    this.remove.add(removeItem);
    return this;
  }

   /**
   * Remove the given header(s) from the HTTP request before the action. The value of Remove is a list of HTTP header names. Note that the header names are case-insensitive (see https://datatracker.ietf.org/doc/html/rfc2616#section-4.2).   Input:   GET /foo HTTP/1.1   my-header1: foo   my-header2: bar   my-header3: baz   Config:   remove: [\&quot;my-header1\&quot;, \&quot;my-header3\&quot;]   Output:   GET /foo HTTP/1.1   my-header2: bar
   * @return remove
  **/
  @jakarta.annotation.Nullable
  public List<String> getRemove() {
    return remove;
  }


  public void setRemove(List<String> remove) {
    this.remove = remove;
  }


  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier set(List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> set) {
    
    this.set = set;
    return this;
  }

  public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier addSetItem(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner setItem) {
    if (this.set == null) {
      this.set = new ArrayList<>();
    }
    this.set.add(setItem);
    return this;
  }

   /**
   * Set overwrites the request with the given header (name, value) before the action.   Input:   GET /foo HTTP/1.1   my-header: foo   Config:   set:   - name: \&quot;my-header\&quot;     value: \&quot;bar\&quot;   Output:   GET /foo HTTP/1.1   my-header: bar
   * @return set
  **/
  @jakarta.annotation.Nullable
  public List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> getSet() {
    return set;
  }


  public void setSet(List<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner> set) {
    this.set = set;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier = (V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier) o;
    return Objects.equals(this.add, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.add) &&
        Objects.equals(this.remove, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.remove) &&
        Objects.equals(this.set, v1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.set);
  }

  @Override
  public int hashCode() {
    return Objects.hash(add, remove, set);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier {\n");
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
    sb.append("    set: ").append(toIndentedString(set)).append("\n");
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
    openapiFields.add("add");
    openapiFields.add("remove");
    openapiFields.add("set");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier is not found in the empty JSON string", V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("add") != null && !jsonObj.get("add").isJsonNull()) {
        JsonArray jsonArrayadd = jsonObj.getAsJsonArray("add");
        if (jsonArrayadd != null) {
          // ensure the json data is an array
          if (!jsonObj.get("add").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `add` to be an array in the JSON string but got `%s`", jsonObj.get("add").toString()));
          }

          // validate the optional field `add` (array)
          for (int i = 0; i < jsonArrayadd.size(); i++) {
            V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner.validateJsonObject(jsonArrayadd.get(i).getAsJsonObject());
          };
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("remove") != null && !jsonObj.get("remove").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `remove` to be an array in the JSON string but got `%s`", jsonObj.get("remove").toString()));
      }
      if (jsonObj.get("set") != null && !jsonObj.get("set").isJsonNull()) {
        JsonArray jsonArrayset = jsonObj.getAsJsonArray("set");
        if (jsonArrayset != null) {
          // ensure the json data is an array
          if (!jsonObj.get("set").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `set` to be an array in the JSON string but got `%s`", jsonObj.get("set").toString()));
          }

          // validate the optional field `set` (array)
          for (int i = 0; i < jsonArrayset.size(); i++) {
            V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerRequestHeaderModifierAddInner.validateJsonObject(jsonArrayset.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier
  */
  public static V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier.class);
  }

 /**
  * Convert an instance of V1HTTPRouteSpecRulesInnerBackendRefsInnerFiltersInnerResponseHeaderModifier to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

