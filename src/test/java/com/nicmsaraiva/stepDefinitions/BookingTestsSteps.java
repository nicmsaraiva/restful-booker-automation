package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingTestsSteps {

    Response response;
    @Dado("que eu faça uma requsição GET para \\/booking")
    public void que_eu_faça_uma_requsição_get_para_booking() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
        response = given().contentType(ContentType.JSON).when().get();
    }
    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas")
    public void a_resposta_deve_conter_o_status_code_ok_com_todos_as_reservas_cadastradas() {
        response.then().statusCode(200);
        System.out.println(response.asPrettyString());
    }
}
