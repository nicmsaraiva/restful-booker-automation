package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingTestSteps {
    private String baseUrl = "https://restful-booker.herokuapp.com";
    private Response response;

    @Dado("queEuFaçaUmaRequisiçãoGETParaBooking")
    public void queEuFaçaUmaRequisiçãoGetParaBooking() {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when()
                .get("/booking");
    }

    @Então("aRespostaDeveConterOStatusCodeOKComTodosAsReservasCadastradas")
    public void aRespostaDeveConterOStatusCodeOkComTodosAsReservasCadastradas() {
        response
                .then()
                .statusCode(200);
        System.out.println("Todas as reservas: " + response.asPrettyString());
    }

    @Dado("queEuFaçaUmaRequisiçãoGETParaBookingComOFirstNameELastName")
    public void queEuFaçaUmaRequisiçãoGetParaBookingComOFirstNameELastName(String firstName, String lastName) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("firstName", firstName)
                .queryParam("lastName", lastName)
                .when()
                .get("/booking");
    }

    @Então("aRespostaDeveConterOStatusCodeOKComTodosAsReservasCadastradasComEsseFirstnameELastname")
    public void aRespostaDeveConterOStatusCodeOkComTodosAsReservasCadastradasComEsseFirstnameELastname() {
        response
                .then()
                .statusCode(200);
        System.out.println("Firstname e lastname: " + response.asPrettyString());
    }

    @Dado("queFaçaUmaRequisiçãoGETParaBookingComADataDeCheckin")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckin(String checkin) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("checkin", checkin)
                .when()
                .get("/booking");
    }

    @Então("aRespostaDeveConterOStatusCodeOKComTodasAsReservasComCheckinNessaData")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckinNessaData() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkin: " + response.asPrettyString());
    }

    @Dado("queFaçaUmaRequisiçãoGETParaBookingComADataDeCheckout")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckout(String checkout) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("checkout", checkout)
                .when()
                .get("/booking");
    }

    @Então("aRespostaDeveConterOStatusCodeOKComTodasAsReservasComCheckoutNessaData")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckoutNessaData() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkout: " + response.asPrettyString());
    }

    @Dado("queFaçaUmaRequisiçãoGETParaBookingComADataDeCheckinECheckout")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckinECheckout(String checkin, String checkout) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get("/booking");
    }

    @Então("aRespostaDeveConterOStatusCodeOKComTodasAsReservasComCheckinECheckoutNasDatasPassadas")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckinECheckoutNasDatasPassadas() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkin e checkout: " + response.asPrettyString());
    }
}
