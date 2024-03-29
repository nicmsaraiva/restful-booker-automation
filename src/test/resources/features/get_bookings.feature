#language: pt
@e2e
Funcionalidade: Booking  - GetBookingIds

  Cenário: Obter todas as reservas cadastradas
    Dado que eu faça uma requsição GET para /booking
    Então a resposta deve conter o status code OK com todos as reservas cadastradas

  Esquema do Cenário: Obter todas as reservas cadastradas com os parâmetros de firstname e lastname enviados
    Dado que eu faça uma requisição GET para /booking com o firstName <firstName> e lastName <lastName>
    Então a resposta deve conter o status code OK com todos as reservas cadastradas com esse firstname e lastname
    Exemplos:
      | firstName | lastName |
      | "sally"   | "brown"  |
      | "nick"    | "owen"   |

  Esquema do Cenário: Obter todas as reservas cadastradas com o parâmetro de data de checkin enviado
    Dado que faça uma requisição GET para /booking com a data de checkin <dataCheckin>
    Então a resposta deve conter o status code OK com todas as reservas com checkin nessa data
    Exemplos:
      | dataCheckin |
      | "2014-03-1" |
      | "2011-01-5" |

  Esquema do Cenário: Obter todas as reservas cadastradas com o parâmetro de data de checkout enviado
    Dado que faça uma requisição GET para /booking com a data de checkout <dataCheckout>
    Então a resposta deve conter o status code OK com todas as reservas com checkout nessa data
    Exemplos:
      | dataCheckout |
      | "2017-02-05" |
      | "2023-07-12" |

  Esquema do Cenário: Obter todas as reservas cadastradas com o parâmetro de data de checkin e checkout enviados
    Dado que faça uma requisição GET para /booking com a data de checkin <dataCheckin> e checkout <dataCheckout>
    Então a resposta deve conter o status code OK com todas as reservas com checkin e checkout nas datas passadas
    Exemplos:
      | dataCheckin  | dataCheckout |
      | "2014-03-12" | "2017-02-05" |
      | "2011-01-5"  | "2023-07-12" |
