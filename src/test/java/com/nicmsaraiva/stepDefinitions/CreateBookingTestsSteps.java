package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class CreateBookingTestsSteps {
    private Response response;
    private String jsonBody = "{\"firstname\":\"Nick\",\"lastname\":\"Owen\",\"totalprice\":446,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2024-02-10\",\"checkout\":\"2024-03-11\"},\"additionalneeds\":\"Breakfast\"}";
    private String baseUrl = "https://restful-booker.herokuapp.com/";

    @Dado("queEuFaçaUmaRequisiçãoPOSTParaOEndpointBookingComOsDadosDaReserva")
    public void queEuFacaUmaRequisicaoPostParaOEndpointBookingComOsDadosDaReserva() {
        response = given()
                .baseUri(baseUrl)
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post();
    }

    @Então("deveRetornarOStatusOK")
    public void deveRetornarOStatusOk() {
        response
                .then()
                .statusCode(200);
    }

    @E("oIDDaReservaDeveSerRetornado")
    public void oIdDaReservaDeveSerRetornado() {
        Integer id = response.then().extract().path("bookingid");
        assertNotNull(id);
    }
}
