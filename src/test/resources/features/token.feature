#language: pt
@e2e
Funcionalidade: Autenticação com Token OAuth

  Cenário: Autenticação bem sucedida
    Quando eu faço uma solicitação POST para /auth com as credenciais válidas
    Então a resposta deve conter o status code OK contendo o token OAuth valido