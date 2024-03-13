#language: pt
@e2e
Funcionalidade: Booking - UpdateBooking

  Cenário: Atualizar dados de uma reserva com sucesso
    Dado que exista uma reserva cadastrada no sistema
    Quando eu faço uma solicitação PUT para o endpoint /booking/id passando o id da reserva com os novos dados alterados
    Então o sistema deve retornar o status code OK
    E deve retornar a reserva com os dados alterados
