package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.config.RequestBuilder;
import com.nicmsaraiva.utils.BookingUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetBookingByIdTestSteps {
    private Response response;

    @Dado("que eu faça uma requisição para o endpoint \\/booking\\/id passando o ID da reserva")
    public void queEuFacaUmaRequisicaoParaOEndpointBookingIdPassandoOIdDaReserva() {
        String id = BookingUtils.createNewBooking();
        response =
                RequestBuilder.getRequest("/booking", id);
    }

    @Entao("o sistema deve retornar o status OK")
    public void oSistemaDeveRetornarOStatusOk() {
        response
                .then()
                .statusCode(200);
    }

    @E("os dados da reserva devem incluir:")
    public void osDadosDaReservaDevemIncluir(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMap(String.class, String.class);
        assertEquals(expectedData.get("firstname"), response.path("firstname"));
        assertEquals(expectedData.get("lastname"), response.path("lastname"));
        assertEquals(Integer.valueOf(expectedData.get("totalprice")), response.path("totalprice"));
        assertEquals(Boolean.parseBoolean(expectedData.get("depositpaid")), response.path("depositpaid"));
    }

    @Dado("que eu faça uma requisição para o endpoint \\/booking\\/id passando um ID sem cadastro")
    public void queEuFacaUmaRequisicaoParaOEndpointBookingIdPassandoUmIdSemCadastro() {
        String invalidId = "213123123";
        response
                = RequestBuilder.getRequest("/booking", invalidId);
    }

    @Então("o sistema deve retornar o status Not Found")
    public void oSistemaDeveRetornarOStatusNotFound() {
        response
                .then()
                .statusCode(404);
    }
}
