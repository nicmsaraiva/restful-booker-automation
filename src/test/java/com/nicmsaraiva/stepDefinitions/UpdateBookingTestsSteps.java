package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.config.RequestBuilder;
import com.nicmsaraiva.utils.BookingUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.junit.Assert;

public class UpdateBookingTestsSteps {
    private String bookingId;
    private Response response;

    @Dado("que exista uma reserva cadastrada no sistema")
    public void queExistaUmaReservaCadastradaNoSistema() {
        bookingId = BookingUtils.createNewBooking();
        System.out.println("Booking created, id: " + bookingId);
    }

    @Quando("eu faço uma solicitação PUT para o endpoint \\/booking\\/id passando o id da reserva com os novos dados alterados")
    public void euFacoUmaSolicitacaoPutParaOEndpointBookingIdPassandoOIdDaReservaComOsNovosDadosAlterados() {
        response =
                RequestBuilder.putRequestById("update-booking.json", "/booking", bookingId);
    }

    @Então("o sistema deve retornar o status code OK")
    public void oSistemaDeveRetornarOStatusCodeOk() {
        response
                .then()
                .statusCode(200);
    }

    @Entao("deve retornar a reserva com os dados alterados")
    public void deveRetornarAReservaComOsDadosAlterados() {
        Assert.assertEquals("J. Owen", response.then().extract().path("lastname"));
        Assert.assertEquals("211", response.then().extract().path("totalprice").toString());
        Assert.assertTrue(Boolean.parseBoolean(response.then().extract().path("depositpaid").toString()));
    }
}
