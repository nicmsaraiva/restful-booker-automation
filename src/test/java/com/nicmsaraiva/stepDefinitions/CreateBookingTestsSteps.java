package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class CreateBookingTestsSteps {
    Response response;
    String jsonBody = "{\"firstname\":\"Nick\",\"lastname\":\"Owen\",\"totalprice\":446,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2024-02-10\",\"checkout\":\"2024-03-11\"},\"additionalneeds\":\"Breakfast\"}";
    String BASE_URL = "https://restful-booker.herokuapp.com/";


    @Dado("que eu faça uma requisição POST para o endpoint \\/booking com os dados da reserva")
    public void que_eu_faça_uma_requisição_post_para_o_endpoint_booking_com_os_dados_da_reserva() {
        response =
                given()
                        .baseUri(BASE_URL)
                        .basePath("/booking")
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                        .when()
                        .post();
    }
    @Então("deve retornar o status OK")
    public void deveRetornarOStatusOK() {
        response
                .then()
                .statusCode(200);
    }

    @E("o ID da reserva deve ser retornado")
    public void oIDDaReservaDeveSerRetornado() {
        Integer id = response.then().extract().path("bookingid");
        assertNotNull(id);
    }
}
