#language: pt
Funcionalidade: Booking - GetBooking

  Cenário: Obter uma reserva pelo id cadastrado
    Dado que eu faça uma requisição para o endpoint /booking/id passando o ID da reserva
    Então o sistema deve retornar o status OK
    E os dados da reserva devem incluir:
      | firstname    | Nick                                     |
      | lastname     | Owen                                 |
      | totalprice   | 446                                      |
      | depositpaid  | false                                     |
      | bookingdates | checkin: 2024-02-10, checkout:2024-03-11 |

  Cenário: Obter uma reserva sem cadastro
    Dado que eu faça uma requisição para o endpoint /booking/id passando um ID sem cadastro
    Então o sistema deve retornar o status Not Found


