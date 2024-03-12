package com.nicmsaraiva.stepDefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class AuthTestSteps {

    private Response response;

    @Quando("euFaçoUmaSolicitaçãoPOSTParaAuthComAsCredenciaisVálidas")
    public void euFacoUmaSolicitacaoPostParaAuthComAsCredenciaisValidas() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";

        String payload = "{\"username\": \"admin\", \"password\": \"password123\"}";

        response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    @Então("aRespostaDeveConterOStatusCodeOKContendoOTokenOAuthValido")
    public void aRespostaDeveConterOStatusCodeOkContendoOTokenOAuthValido() {
        response
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");
        Assert.assertNotNull(response);
    }
}
