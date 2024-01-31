package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingTestSteps {
    String BASE_URL = "https://restful-booker.herokuapp.com";
    Response response;

    @Dado("que eu faça uma requsição GET para \\/booking")
    public void que_eu_faça_uma_requsição_get_para_booking() {
        response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas")
    public void a_resposta_deve_conter_o_status_code_ok_com_todos_as_reservas_cadastradas() {
        response
                .then()
                .statusCode(200);
        System.out.println("Todas as reservas: " + response.asPrettyString());
    }

    @Dado("que eu faça uma requsição GET para \\/booking com o firstName {string} e lastName {string}")
    public void que_eu_faça_uma_requsição_get_para_booking_com_o_first_name_e_last_name(String string, String string2) {
        response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .queryParam("firstName", string)
                .queryParam("lastName", string2)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas com esse firstname e lastname")
    public void a_resposta_deve_conter_o_status_code_ok_com_todos_as_reservas_cadastradas_com_esse_firstname_e_lastname() {
        response
                .then()
                .statusCode(200);
        System.out.println("Firstname e lastname: " + response.asPrettyString());
    }

    @Dado("que faça uma requisição GET para \\/booking com a data de checkin {string}")
    public void que_faça_uma_requisição_get_para_booking_com_a_data_de_checkin(String string) {
        response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .queryParam("checkin", string)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkin nessa data")
    public void a_resposta_deve_conter_o_status_code_ok_com_todas_as_reservas_com_checkin_nessa_data() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkin: " + response.asPrettyString());
    }

    @Dado("que faça uma requisição GET para \\/booking com a data de checkout {string}")
    public void que_faça_uma_requisição_get_para_booking_com_a_data_de_checkout(String string) {
        response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .queryParam("checkout", string)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkout nessa data")
    public void a_resposta_deve_conter_o_status_code_ok_com_todas_as_reservas_com_checkout_nessa_data() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkout: " + response.asPrettyString());
    }

    @Dado("que faça uma requisição GET para \\/booking com a data de checkin {string} e checkout {string}")
    public void que_faça_uma_requisição_get_para_booking_com_a_data_de_checkin_e_checkout(String checkin, String checkout) {
        response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get("/booking");
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkin e checkout nas datas passadas")
    public void a_resposta_deve_conter_o_status_code_ok_com_todas_as_reservas_com_checkin_e_checkout_nas_datas_passadas() {
        response
                .then()
                .statusCode(200);
        System.out.println("Checkin e checkout: " + response.asPrettyString());
    }
}
