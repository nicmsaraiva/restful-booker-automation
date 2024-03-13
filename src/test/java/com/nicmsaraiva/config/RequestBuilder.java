package com.nicmsaraiva.config;

import com.nicmsaraiva.payloads.Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public static Response postRequest(String payload, String basePath) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(Payload.auth)
                        .when()
                        .post();
    }

    public static Response getRequest(String params, String basePath) {
        return null;
    }
}
