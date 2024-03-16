package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.config.RequestBuilder;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class AuthTestSteps {

    private Response response;

    @Quando("eu faço uma solicitação POST para \\/auth com as credenciais válidas")
    public void euFacoUmaSolicitacaoPostParaAuthComAsCredenciaisValidas() {
        response =
                RequestBuilder.
                        postRequest("auth.json", "/auth");
    }

    @Entao("a resposta deve conter o status code OK contendo o token OAuth valido")
    public void aRespostaDeveConterOStatusCodeOkContendoOTokenOAuthValido() {
        response
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");
    }
}
