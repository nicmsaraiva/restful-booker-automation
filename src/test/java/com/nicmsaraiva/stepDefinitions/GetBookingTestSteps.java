package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.config.RequestBuilder;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class GetBookingTestSteps {
    private Response response;

    @Dado("que eu faça uma requsição GET para \\/booking")
    public void queEuFaçaUmaRequisiçãoGetParaBooking() {
        response =
                RequestBuilder.getRequest("/booking", "");
    }

    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas")
    public void aRespostaDeveConterOStatusCodeOkComTodosAsReservasCadastradas() {
        response
                .then()
                .statusCode(200);
    }

    @Dado("que eu faça uma requisição GET para \\/booking com o firstName {string} e lastName {string}")
    public void queEuFacaUmaRequisicaoGetParaBookingComOFirstNameELastName(String firstName, String lastName) {
        response =
                RequestBuilder.getRequestFirstNameNLastName("/booking", firstName, lastName);
    }

    @Então("a resposta deve conter o status code OK com todos as reservas cadastradas com esse firstname e lastname")
    public void aRespostaDeveConterOStatusCodeOkComTodosAsReservasCadastradasComEsseFirstnameELastname() {
        response
                .then()
                .statusCode(200);
    }

    @Dado("que faça uma requisição GET para \\/booking com a data de checkin {string}")
    public void queFacaUmaRequisicaoGetParaBookingComADataDeCheckin(String checkin) {
        response =
                RequestBuilder.getRequestByCheck("/booking", "checkin", checkin);
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkin nessa data")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckinNessaData() {
        response
                .then()
                .statusCode(200);
    }

    @Dado("que faça uma requisição GET para \\/booking com a data de checkout {string}")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckout(String checkout) {
        response =
                RequestBuilder.getRequestByCheck("/booking", "checkout", checkout);
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkout nessa data")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckoutNessaData() {
        response
                .then()
                .statusCode(200);
    }

    @Dado("que faça uma requisição GET para \\/booking com a data de checkin {string} e checkout {string}")
    public void queFaçaUmaRequisiçãoGetParaBookingComADataDeCheckinECheckout(String checkin, String checkout) {
        response =
                RequestBuilder.getRequestByBothChecks("/booking", checkin, checkout);
    }

    @Então("a resposta deve conter o status code OK com todas as reservas com checkin e checkout nas datas passadas")
    public void aRespostaDeveConterOStatusCodeOkComTodasAsReservasComCheckinECheckoutNasDatasPassadas() {
        response
                .then()
                .statusCode(200);
    }
}
