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

Vamos exemplificar com o acesso à rota `GET /cursos` da nossa própria API.

1. **Envio da requisição para o servidor:** O cliente manda uma requisição "Listar todos os cursos" para o servidor da 
URL, chegando na camada de controle.
1. **Processamento da requisição:** O controlador daquela rota endereça a requisição para o serviço e o método correspondente - neste caso,
um método `listarCursos` em `CursoService`.
1.  **Consulta ao banco de dados:** O serviço chama a camada de repositório correspondente para fazer a pesquisa de
cursos no banco de dados, que por sua vez os retorna para a camada de serviço.
1. **Tratamento e envio da resposta:** De volta no controlador, os dados são formatados em JSON (JavaScript Object 
Notation) e enviados para o cliente.

## Responsabilidades do back-end

1. Receber os dados enviados pelo cliente;
2. Transformar os dados em um objeto Java;
3. Verificar as regras do curso;
4. Salvar o curso;
5. Devolver uma resposta ao cliente.

## Contrato inicial da API

| Método | Rota         | Operação                | Resposta esperada               |
|--------|--------------|-------------------------|---------------------------------|
| GET    | /cursos      | Listar todos os cursos  | 200 OK                          |
| GET    | /cursos/{id} | Buscar um curso pelo ID | 200 OK ou 404 Not Found         |
| POST   | /cursos      | Cadastrar um curso      | 201 Created                     |
| PUT    | /cursos/{id} | Atualizar um curso      | 200 OK ou 404 Not Found         |
| DELETE | /cursos/{id} | Remover um curso        | 204 No Content ou 404 Not Found |
