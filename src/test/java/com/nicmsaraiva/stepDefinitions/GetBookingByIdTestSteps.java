package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetBookingByIdTestSteps {
    Response response;
    String id = "1";

    @Dado("que eu faça uma requisição para o endpoint \\/booking\\/id passando o ID da reserva")
    public void que_eu_faça_uma_requisição_para_o_endpoint_booking_id_passando_o_id_da_reserva() {
        response = given()
                .baseUri("https://restful-booker.herokuapp.com/booking/")
                .contentType(ContentType.JSON)
                .when()
                .get(id);
    }

    @Então("o sistema deve retornar o status OK")
    public void o_sistema_deve_retornar_o_status_ok() {
        response
                .then()
                .statusCode(200);
    }

    @E("os dados da reserva devem incluir:")
    public void os_dados_da_reserva_devem_incluir(io.cucumber.datatable.DataTable dataTable) {
        String firstName = response.path("firstname");
        String lastName = response.path("lastname");
        Integer totalPrice = response.path("totalprice");
        Boolean depositPaid = response.path("depositpaid");

        assertEquals("Mark", firstName);
        assertEquals("Ericsson", lastName);
        assertEquals(Integer.valueOf(343), totalPrice);
        assertTrue(depositPaid);

    }
}
