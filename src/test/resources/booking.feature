#language: pt
Funcionalidade: Booking

  Cenário: Obter todas as reservas cadastradas
    Dado que eu faça uma requsição GET para /booking
    Então a resposta deve conter o status code OK com todos as reservas cadastradas

  Esquema do Cenário: Obter todas as reservas cadastradas com os parametros de firstname e lastname enviados
    Dado que eu faça uma requsição GET para /booking com o firstName <firstName> e lastName <lastName>
    Então a resposta deve conter o status code OK com todos as reservas cadastradas com esse firstname e lastname
    Exemplos:
      | firstName | lastName |
      | "sally"   | "brown"  |
      | "nick"    | "owen"   |

  Esquema do Cenario: Obter todas as reservas cadastradas com o parametro de data de checkin enviado
    Dado que faça uma requisição GET para /booking com a data de checkin <dataCheckin>
    Então a resposta deve conter o status code OK com todas as reservadas com checkin nessa data
    Exemplos:
      | dataCheckin |
      | "2014-03-1" |
      | "2011-01-5" |