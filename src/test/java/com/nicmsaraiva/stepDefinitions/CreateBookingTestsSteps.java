package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.config.RequestBuilder;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class CreateBookingTestsSteps {
    private Response response;

    @Dado("que eu faça uma requisição POST para o endpoint \\/booking com os dados da reserva")
    public void queEuFacaUmaRequisicaoPostParaOEndpointBookingComOsDadosDaReserva() {
        response
                = RequestBuilder.postRequest("create-booking.json", "/booking");
    }

    @Então("deve retornar o status OK")
    public void deveRetornarOStatusOk() {
        response
                .then()
                .statusCode(200);
    }

    @E("o ID da reserva deve ser retornado")
    public void oIdDaReservaDeveSerRetornado() {
        Integer id = response.then().extract().path("bookingid");
        assertNotNull(id);
    }
}
