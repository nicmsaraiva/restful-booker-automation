package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.utils.CreateBooking;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetBookingByIdTestSteps {
    CreateBooking createBooking = new CreateBooking();
    Response response;
    String BASE_URL = "https://restful-booker.herokuapp.com/";

    @Dado("que eu faça uma requisição para o endpoint \\/booking\\/id passando o ID da reserva")
    public void que_eu_faça_uma_requisição_para_o_endpoint_booking_id_passando_o_id_da_reserva() {
        String id = createBooking.createNewBooking();
        response =
                given()
                        .baseUri(BASE_URL)
                        .basePath("/booking")
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

        assertEquals("Nick", firstName);
        assertEquals("Owen", lastName);
        assertEquals(Integer.valueOf(446), totalPrice);
        assertFalse(depositPaid);
    }

    @Dado("que eu faça uma requisição para o endpoint \\/booking\\/id passando um ID sem cadastro")
    public void que_eu_faça_uma_requisição_para_o_endpoint_booking_id_passando_um_id_sem_cadastro() {
        String idInvalid = "213123123";
        response =
                given()
                        .baseUri(BASE_URL)
                        .basePath("/booking")
                        .contentType(ContentType.JSON)
                        .when()
                        .get(idInvalid);
    }

    @Então("o sistema deve retornar o status Not Found")
    public void o_sistema_deve_retornar_o_status_not_found() {
        response
                .then()
                .statusCode(404);
    }
}
