#language: pt
  Funcionalidade: Booking
    Cenário: Obter todas as reservas cadastradas
      Dado que eu faça uma requsição GET para /booking
      Então a resposta deve conter o status code OK com todos as reservas cadastradas