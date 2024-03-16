package com.nicmsaraiva.config;

import com.nicmsaraiva.utils.JsonUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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

    public static Response getRequest(String basePath, String id) {
        RequestSpecification request =
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath(basePath)
                        .contentType(ContentType.JSON);

        if (id != null) {
            return request.get(id);
        } else {
            return request.get();
        }
    }

    public static Response getRequestFirstNameNLastName(String basePath, String firstNameParam, String lastNameParam) {
        return
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath(basePath)
                        .contentType(ContentType.JSON)
                        .queryParam("firstName", firstNameParam)
                        .queryParam("lastName", lastNameParam)
                        .when()
                        .get();
    }

    public static Response getRequestByCheck(String basePath, String parameterNameCheck, String check) {
        RequestSpecification request =
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath(basePath)
                        .contentType(ContentType.JSON);
        if (parameterNameCheck.equals("checkin")) {
            return request.param("checkin", check).get();
        } else {
            return request.param("checkout", check).get();
        }
    }

    public static Response getRequestByBothChecks(String basePath, String checkin, String checkout) {
        return
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath(basePath)
                        .contentType(ContentType.JSON)
                        .queryParam("checkin", checkin)
                        .queryParam("checkout", checkout)
                        .when()
                        .get();
    }

    public static Response putRequestById(String jsonName, String basePath, String id) {
        return
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath(basePath)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(JsonUtils.json2String(jsonName))
                        .when()
                        .put(id);
    }
}
