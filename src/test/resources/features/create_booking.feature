#language: pt
@e2e
Funcionalidade: Booking - CreateBooking

  Cenário: Criar uma nova reserva com sucesso
    Dado que eu faça uma requisição POST para o endpoint /booking com os dados da reserva
    Então deve retornar o status OK
    E o ID da reserva deve ser retornado