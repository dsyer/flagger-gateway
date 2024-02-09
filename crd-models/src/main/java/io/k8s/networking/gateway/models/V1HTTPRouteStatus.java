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
import io.k8s.networking.gateway.models.V1HTTPRouteStatusParentsInner;
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
 * Status defines the current state of HTTPRoute.
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1HTTPRouteStatus {
  public static final String SERIALIZED_NAME_PARENTS = "parents";
  @SerializedName(SERIALIZED_NAME_PARENTS)
  private List<V1HTTPRouteStatusParentsInner> parents = new ArrayList<>();

  public V1HTTPRouteStatus() {
  }

  public V1HTTPRouteStatus parents(List<V1HTTPRouteStatusParentsInner> parents) {
    this.parents = parents;
    return this;
  }

  public V1HTTPRouteStatus addParentsItem(V1HTTPRouteStatusParentsInner parentsItem) {
    if (this.parents == null) {
      this.parents = new ArrayList<>();
    }
    this.parents.add(parentsItem);
    return this;
  }

   /**
   * Parents is a list of parent resources (usually Gateways) that are associated with the route, and the status of the route with respect to each parent. When this route attaches to a parent, the controller that manages the parent must add an entry to this list when the controller first sees the route and should update the entry as appropriate when the route or gateway is modified.   Note that parent references that cannot be resolved by an implementation of this API will not be added to this list. Implementations of this API can only populate Route status for the Gateways/parent resources they are responsible for.   A maximum of 32 Gateways will be represented in this list. An empty list means the route has not been attached to any Gateway.
   * @return parents
  **/
  @jakarta.annotation.Nonnull
  public List<V1HTTPRouteStatusParentsInner> getParents() {
    return parents;
  }

  public void setParents(List<V1HTTPRouteStatusParentsInner> parents) {
    this.parents = parents;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1HTTPRouteStatus v1HTTPRouteStatus = (V1HTTPRouteStatus) o;
    return Objects.equals(this.parents, v1HTTPRouteStatus.parents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1HTTPRouteStatus {\n");
    sb.append("    parents: ").append(toIndentedString(parents)).append("\n");
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
    openapiFields.add("parents");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("parents");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1HTTPRouteStatus
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1HTTPRouteStatus.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1HTTPRouteStatus is not found in the empty JSON string", V1HTTPRouteStatus.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1HTTPRouteStatus.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1HTTPRouteStatus` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : V1HTTPRouteStatus.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("parents").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `parents` to be an array in the JSON string but got `%s`", jsonObj.get("parents").toString()));
      }

      JsonArray jsonArrayparents = jsonObj.getAsJsonArray("parents");
      // validate the required field `parents` (array)
      for (int i = 0; i < jsonArrayparents.size(); i++) {
        V1HTTPRouteStatusParentsInner.validateJsonElement(jsonArrayparents.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1HTTPRouteStatus.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1HTTPRouteStatus' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1HTTPRouteStatus> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1HTTPRouteStatus.class));

       return (TypeAdapter<T>) new TypeAdapter<V1HTTPRouteStatus>() {
           @Override
           public void write(JsonWriter out, V1HTTPRouteStatus value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1HTTPRouteStatus read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1HTTPRouteStatus given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1HTTPRouteStatus
  * @throws IOException if the JSON string is invalid with respect to V1HTTPRouteStatus
  */
  public static V1HTTPRouteStatus fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1HTTPRouteStatus.class);
  }

 /**
  * Convert an instance of V1HTTPRouteStatus to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

