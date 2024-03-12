package com.nicmsaraiva.stepDefinitions;

import com.nicmsaraiva.utils.CreateBooking;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class UpdateBookingTestsSteps {
    private String updatedUser = "{\"firstname\":\"Nick\",\"lastname\":\"J. Owen\",\"totalprice\":211,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2024-02-10\",\"checkout\":\"2024-03-11\"},\"additionalneeds\":\"Breakfast\"}";
    private String baseUrl = "https://restful-booker.herokuapp.com/";
    private CreateBooking createBooking = new CreateBooking();
    private String id;
    private Response response;

    @Dado("queExistaUmaReservaCadastradaNoSistema")
    public void queExistaUmaReservaCadastradaNoSistema() {
        id = createBooking.createNewBooking();
        System.out.println("Booking created, id: " + id);
    }

    @Quando("euFaçoUmaSolicitaçãoPUTParaOEndpointBookingIdPassandoOIdDaReservaComOsNovosDadosAlterados")
    public void euFaçoUmaSolicitaçãoPutParaOEndpointBookingIdPassandoOIdDaReservaComOsNovosDadosAlterados() {
        response = given()
                .baseUri(baseUrl)
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(updatedUser)
                .when()
                .put(id);
    }

    @Então("oSistemaDeveRetornarOStatusCodeOK")
    public void oSistemaDeveRetornarOStatusCodeOk() {
        response
                .then()
                .statusCode(200);
    }

    @Então("deveRetornarAReservaComOsDadosAlterados")
    public void deveRetornarAReservaComOsDadosAlterados() {
        String lastname = response.then().extract().path("lastname");
        String totalprice = response.then().extract().path("totalprice").toString();
        String depositpaid = response.then().extract().path("depositpaid").toString();

        Assert.assertEquals("J. Owen", lastname);
        Assert.assertEquals("211", totalprice);
        Assert.assertTrue(Boolean.parseBoolean(depositpaid));
    }
}