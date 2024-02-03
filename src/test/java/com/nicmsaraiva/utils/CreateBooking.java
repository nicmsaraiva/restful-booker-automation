package com.nicmsaraiva.utils;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class CreateBooking {

    String BASE_URL = "https://restful-booker.herokuapp.com/";
    String jsonBody = "{\"firstname\":\"Nick\",\"lastname\":\"Owen\",\"totalprice\":446,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2024-02-10\",\"checkout\":\"2024-03-11\"},\"additionalneeds\":\"Breakfast\"}";

    public String createNewBooking() {
        return given()
                .baseUri(BASE_URL)
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid").toString();
    }
}
