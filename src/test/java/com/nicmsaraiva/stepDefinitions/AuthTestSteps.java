package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class AuthTestSteps {

    Response response;

    @Quando("eu faço uma solicitação POST para \\/auth com as credenciais válidas")
    public void eu_faço_uma_solicitação_post_para_auth_com_as_credenciais_válidas() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";
        String payload = "{\"username\": \"admin\", \"password\": \"password123\"}";
        response = given().contentType(ContentType.JSON).body(payload).when().post();
    }

    @Então("a resposta deve conter o status code OK contendo o token OAuth valido")
    public void a_resposta_deve_conter_o_status_code_ok_contendo_o_token_o_auth_valido() {
        response.then().statusCode(200).extract().jsonPath().get("token");
        Assert.assertNotNull(response);
    }
}
