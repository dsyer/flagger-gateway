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


package com.vmware.tanzu.models;

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
 * V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel {
  public static final String SERIALIZED_NAME_REQUEST_BODY = "requestBody";
  @SerializedName(SERIALIZED_NAME_REQUEST_BODY)
  private Object requestBody;

  public static final String SERIALIZED_NAME_RESPONSES = "responses";
  @SerializedName(SERIALIZED_NAME_RESPONSES)
  private Object responses;

  public V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel() {
  }

  public V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel requestBody(Object requestBody) {
    this.requestBody = requestBody;
    return this;
  }

   /**
   * The request body as specified by https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#requestBodyObject
   * @return requestBody
  **/
  @jakarta.annotation.Nullable
  public Object getRequestBody() {
    return requestBody;
  }

  public void setRequestBody(Object requestBody) {
    this.requestBody = requestBody;
  }


  public V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel responses(Object responses) {
    this.responses = responses;
    return this;
  }

   /**
   * The responses of an operation as specified by https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#responsesObject
   * @return responses
  **/
  @jakarta.annotation.Nullable
  public Object getResponses() {
    return responses;
  }

  public void setResponses(Object responses) {
    this.responses = responses;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel v1SpringCloudGatewayRouteConfigSpecRoutesInnerModel = (V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel) o;
    return Objects.equals(this.requestBody, v1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.requestBody) &&
        Objects.equals(this.responses, v1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.responses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestBody, responses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel {\n");
    sb.append("    requestBody: ").append(toIndentedString(requestBody)).append("\n");
    sb.append("    responses: ").append(toIndentedString(responses)).append("\n");
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
    openapiFields.add("requestBody");
    openapiFields.add("responses");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel is not found in the empty JSON string", V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.class));

       return (TypeAdapter<T>) new TypeAdapter<V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel>() {
           @Override
           public void write(JsonWriter out, V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel
  * @throws IOException if the JSON string is invalid with respect to V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel
  */
  public static V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel.class);
  }

 /**
  * Convert an instance of V1SpringCloudGatewayRouteConfigSpecRoutesInnerModel to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

