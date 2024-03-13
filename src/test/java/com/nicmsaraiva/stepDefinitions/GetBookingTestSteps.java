package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingTestSteps {
    private String baseUrl = "https://restful-booker.herokuapp.com";
    private Response response;

    @Dado("que eu faça uma requsição GET para \\/booking")
    public void queEuFaçaUmaRequisiçãoGetParaBooking() {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas")
    public void aRespostaDeveConterOStatusCodeOkComTodosAsReservasCadastradas() {
        response
                .then()
                .statusCode(200);
        System.out.println("Todas as reservas: " + response.asPrettyString());
    }

    @Dado("que eu faça uma requisição GET para \\\\/booking com o firstName {string} e lastName {string}")
    public void queEuFaçaUmaRequisiçãoGetParaBookingComOFirstNameELastName(String firstName, String lastName) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("firstName", firstName)
                .queryParam("lastName", lastName)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas com esse firstname e lastname")
    public void aRespostaDeveConterOStatusCodeOkComTodosAsReservasCadastradasComEsseFirstnameELastname() {
        response
                .then()
                .statusCode(200);
        System.out.println("Firstname e lastname: " + response.asPrettyString());
    }

    @Dado("que faça uma requisição GET para \\\\/booking com a data de checkin {string}")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckin(String checkin) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("checkin", checkin)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkin nessa data")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckinNessaData() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkin: " + response.asPrettyString());
    }

    @Dado("que faça uma requisição GET para \\\\/booking com a data de checkout {string}")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckout(String checkout) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("checkout", checkout)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkout nessa data")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckoutNessaData() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkout: " + response.asPrettyString());
    }

    @Dado("que faça uma requisição GET para \\\\/booking com a data de checkin {string} e checkout {string}")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckinECheckout(String checkin, String checkout) {
        response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkin e checkout nas datas passadas")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckinECheckoutNasDatasPassadas() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkin e checkout: " + response.asPrettyString());
    }
}
