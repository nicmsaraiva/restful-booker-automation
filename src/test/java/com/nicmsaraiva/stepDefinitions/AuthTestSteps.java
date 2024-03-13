package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.config.RequestBuilder;
import com.nicmsaraiva.payloads.Payload;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class AuthTestSteps {

    private Response response;

    @Quando("eu faço uma solicitação POST para \\/auth com as credenciais válidas")
    public void euFacoUmaSolicitacaoPostParaAuthComAsCredenciaisValidas() {

        response =
                RequestBuilder.postRequest(Payload.auth, "/auth");
    }

    @Então("a resposta deve conter o status code OK contendo o token OAuth valido")
    public void aRespostaDeveConterOStatusCodeOkContendoOTokenOAuthValido() {
        response
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");
    }
}
