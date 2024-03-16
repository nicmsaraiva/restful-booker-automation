package com.nicmsaraiva.utils;

import com.nicmsaraiva.config.Constants;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class BookingUtils {
    public static String createNewBooking() {
        return
                given()
                        .baseUri(Constants.BASE_URI)
                        .basePath("/booking")
                        .contentType(ContentType.JSON)
                        .body(JsonUtils.json2String("create-booking.json"))
                .when()
                        .post()
                .then()
                        .statusCode(200)
                        .extract()
                        .path("bookingid").toString();
    }
}
