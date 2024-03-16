package com.nicmsaraiva.config;

import com.nicmsaraiva.utils.JsonUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public static Response postRequest(String jsonName, String basePath) {
        return
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath(basePath)
                        .contentType(ContentType.JSON)
                        .body(JsonUtils.json2String(jsonName))
                        .when()
                        .post();
    }

    public static Response getRequest(String params, String basePath) {
        return null;
    }
}
