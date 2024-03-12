package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.utils.CreateBooking;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetBookingByIdTestSteps {
    private CreateBooking createBooking = new CreateBooking();
    private Response response;
    private String baseUrl = "https://restful-booker.herokuapp.com/";

    @Dado("queEuFaçaUmaRequisiçãoParaOEndpointBookingIdPassandoOIdDaReserva")
    public void queEuFaçaUmaRequisiçãoParaOEndpointBookingIdPassandoOIdDaReserva() {
        String id = createBooking.createNewBooking();
        response = given()
                .baseUri(baseUrl)
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when()
                .get(id);
    }

    @Então("oSistemaDeveRetornarOStatusOK")
    public void oSistemaDeveRetornarOStatusOk() {
        response
                .then()
                .statusCode(200);
    }

    @E("osDadosDaReservaDevemIncluir")
    public void osDadosDaReservaDevemIncluir(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String > expectedData = dataTable.asMap(String.class, String.class);
        String firstName = response.path("firstname");
        String lastName = response.path("lastname");
        Integer totalPrice = response.path("totalprice");
        Boolean depositPaid = response.path("depositpaid");

        assertEquals(expectedData.get("firstname"), firstName);
        assertEquals(expectedData.get("lastname"), lastName);
        assertEquals(Integer.valueOf(expectedData.get("totalprice")), totalPrice);
        assertEquals(Boolean.parseBoolean(expectedData.get("depositpaid")), depositPaid);
    }

    @Dado("queEuFaçaUmaRequisiçãoParaOEndpointBookingIdPassandoUmIdSemCadastro")
    public void queEuFaçaUmaRequisiçãoParaOEndpointBookingIdPassandoUmIdSemCadastro() {
        String idInvalid = "213123123";
        response = given()
                .baseUri(baseUrl)
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when()
                .get(idInvalid);
    }

    @Então("oSistemaDeveRetornarOStatusNotFound")
    public void oSistemaDeveRetornarOStatusNotFound() {
        response
                .then()
                .statusCode(404);
    }
}
