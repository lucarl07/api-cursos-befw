# Atividade Prática Integrada: API de Cursos

Um projeto da disciplina Back-End Frameworks, feito por Luiz Carlos Jr.

## Sumário

(T.B.D)

## Fluxo cliente e servidor

> O que acontece quando o cliente consulta - isso é, solicita acessar - um endpoint?

Quando um usuário, normalmente em um website ou dashboard, realiza uma mecânica - ex.: pesquisa por um produto, clica
num botão de "Criar conta", etc - que demanda uma resposta do servidor, o seguinte fluxo sempre acontece:

```text
Cliente -> requisição HTTP -> back-end -> resposta HTTP -> cliente
```

Vamos exemplificar com o acesso à rota `GET /cursos` na nossa própria API.

1. **Envio da requisição para o servidor:** 
2. **Validação e tratamento da requisição:**
3. **Consulta ao banco de dados:**
4. **Envio da resposta para o cliente:**
5. **Tratamento final da resposta:**

## Responsabilidades do back-end

Nesse modelo, nós abstraímos um pouco da possível complexidade presente no back-end (especialmente dentro da API) para
falar de duas partes em específico: a **API** e o **banco de dados**.

Uma API, ou **Application Programming Interface**, consiste num sistema intermediário entre uma interface de exibição
(que existe no lado do cliente) e um conjunto de dados, definindo regras para acessá-los e devolvê-los, permitindo assim
uma comunicação padronizada e segura no fluxo cliente e servidor. **O projeto presente nesse repositório *é uma API*,
que usa a linguagem Java e o framework Spring**.

No nosso fluxo, ao receber uma requisição HTTP, ela e quaisquer dados enviados com ela irão chegar para a API, que
designará a operação para o módulo correspondente, podendo aceitá-la ou rejeitá-la com base em critérios (ex.: ao fazer
login, campos `username` e `password` devem existir no corpo da requisição), restrições (a operação
`DELETE /alunos/{alunoId}` só pode ser realizada por um administrador, tendo um token que identifica sua função no
cabeçalho da *request*) e validações (para criar uma conta, o valor do campo `password` deve ter no mínimo 8 caracteres).

## Contrato inicial da API

(T.B.D)
