#language: pt
Funcionalidade: Booking - GetBooking

  Cenário: Obter uma reserva pelo id cadastrado
    Dado que eu faça uma requisição para o endpoint /booking/id passando o ID da reserva
    Então o sistema deve retornar o status OK
    E os dados da reserva devem incluir:
      | firstname    | Mark                                     |
      | lastname     | Ericsson                                 |
      | totalprice   | 343                                      |
      | depositpaid  | true                                     |
      | bookingdates | checkin: 2015-06-13, checkout:2018-04-15 |

  Cenário: Obter uma reserva sem cadastro
    Dado que eu faça uma requisição para o endpoint /booking/id passando um ID sem cadastro
    Então o sistema deve retornar o status Not Found


