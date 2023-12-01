# tapr-2023-equipe2-professor-java

## Executando a Aplicação
!!! importante fazer login em conta no [azure](#docs) !!! 
- Buildar o .jar:
```
mvn clean install -DskipTests
```
- Iniciar o Dapr:
```
dapr run -f .
```
- Simulando a publicação de um evento no tópico de disciplinas:
```
dapr publish --publish-app-id tapr-2023-equipe2-professor-java --pubsub servicebus-pubsub --topic topico-equipe-2-disciplina --data '{"id": "11111","cargaHoraria": 144,"semestre": 4}'
```
- O retorno deve ser:
```
✅  Event published successfully
```
- Ao fazer **GET** para a rota `http://localhost:8080/api/v1/disciplinas` o retorno deve ser a disciplina abaixo:
```json
{
  "id": "11111",
  "cargaHoraria": 144,
  "semestre": 4
}
```

Abaixo segue a documentação da API de Professor.

# Microserviço professor

- Entity Professor:
```json
{
  "id": String,
  "nome": String,
  "documento": String,
  "cep": String,
  "telefone": String,
  "email": String
}
```

| attribute  | type  | unique  | null/blank  | updatable  |
|---|---|---|---|---|
| id  | String  | **true**  | false  | no  |
| nome  | String  | false  | false  | yes  |
| documento  | String  | **true**  | false  | no  |
| cep  | String  | false  | false  | yes  |
| telefone  | String  | false  | false  | yes  |
| email  | String  | false  | false  | yes  |

## `/api/v1/professores`

### **Status 2xx successfull**

| Endpoint  | Method  | Req.Body  | Status  | Resp.Body  | Description  |
|---|---|---|---|---|---|
| `/api/v1/professores`  | `GET`  |   | 200  | Professor[]  | Retorna todos os professores.  |
| `/api/v1/professores`  | `POST`  | Professor  | 201  | Professor  | Cria novo professor.  |
| `**/id/{id}`  | `GET`  |   | 200  | Professor  | Retorna o professor dado um id.  |
| `**/documento/{documento}`  | `GET`  |   | 200  | Professor  | Retorna o professor dado um documento.  |
| `**/update/{id}`  | `PUT`  | UpdateReq  | 200  | Professor  | Atualiza um professor dado um id.  |
| `**/{id}`  | `DELETE`  |   | 204  |   | Deleta um professor dado um id.  |

### **Status 4xx error**

| Endpoint  | Method  | Req.Body  | Status  | Resp.Body  | Description  |
|---|---|---|---|---|---|
| `/api/v1/professores`  | `GET`  |   | 200  | Professor[] | Retorna uma lista vazia.  |
| `/api/v1/professores`  | `POST`  | Professor  | 400, 409  | ErrorMessage  | Bad request or Conflict.  |
| `**/id/{id}`  | `GET`  |   | 404  | ErrorMessage  | Not Found.  |
| `**/documento/{documento}`  | `GET`  |   | 404  | ErrorMessage  |  Not Found.  |
| `**/update/{id}`  | `PUT`  | UpdateReq | 400, 404  | ErrorMessage  | Bad Request or Not Found.  |
| `**/delete/{id}`  | `DELETE`  |   | 404  | ErrorMessage  | Not Found.  |

### Request and Response exemplos (POST, PUT):

### POST `/api/v1/professores`

- Request body:
```json
{
    "nome": "leonardo",
    "documento": "654616846846",
    "cep": "89223-390",
    "telefone": "49 99972-8265",
    "email": "leonardozw@gmail.com"
}
```

- Response:
```json
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 09 Nov 2023 22:56:08 GMT
Connection: close

{
  "id": "ff19ee73-b091-49f4-8290-56739022db2b",
  "nome": "leonardo",
  "documento": "654616846846",
  "cep": "89223-390",
  "telefone": "49 99972-8265",
  "email": "leonardozw@gmail.com"
}
```

### PUT `/api/v1/professores/update/{id}`

- Request body:
```json
{
  "nome": "leonardo ZW",
  "documento": "654616846846",
  "cep": "89223-390",
  "telefone": "49 99972-8265",
  "email": "leonardo@gmail.com"
}
```
- Response:
```json
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 09 Nov 2023 22:59:13 GMT
Connection: close

{
  "id": "ff19ee73-b091-49f4-8290-56739022db2b",
  "nome": "leonardo ZW",
  "documento": "654616846846",
  "cep": "89223-390",
  "telefone": "49 99972-8265",
  "email": "leonardo@gmail.com"
}
```

## docs
### Azure Cli
- [Azure CLI](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli-linux?pivots=apt)
### CosmosDB
- [Introdução](https://learn.microsoft.com/en-us/azure/cosmos-db/introduction)
- [Databases, containers, e items](https://learn.microsoft.com/en-us/azure/cosmos-db/resource-model)
- [Samples](https://github.com/Azure-Samples/azure-spring-data-cosmos-java-sql-api-samples)

```properties
# logar no azure
az login -u user@unville.br

# checar usuario logado
az ad signed-in-user show

# Da a permissão para ler e escrever no cosmos
az cosmosdb sql role assignment create --account-name COSMOSDBACCOUNT --resource-group GRUPODERECURSO --role-assignment-id 00000000-0000-0000-0000-000000000002 --role-definition-name "Cosmos DB Built-in Data Contributor" --scope "/" --principal-id GUIDUSUARIOAD
```

**Dependencias:**
- Cosmos DB:
```properties
<dependency>
  <groupId>com.azure.spring</groupId>
  <artifactId>spring-cloud-azure-starter-data-cosmos</artifactId>
  <version>5.5.0</version>
</dependency>
<dependency>
  <groupId>com.azure</groupId>
  <artifactId>azure-spring-data-cosmos</artifactId>
  <version>5.5.0</version>
</dependency>
```
- Azure identity:
```properties
<dependency>
  <groupId>com.azure</groupId>
  <artifactId>azure-identity</artifactId>
  <version>1.10.0</version>
</dependency>
```
- Springdoc OpenAPI Swagger:
```properties
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.1.0</version>
</dependency>
```
- Lombok:
```properties
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <scope>annotationProcessor</scope>
</dependency>
```
- Validation:
```properties
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
- Dapr sdk:
```properties
<dependency>
  <groupId>io.dapr</groupId>
  <artifactId>dapr-sdk</artifactId>
  <version>1.10.0</version>
</dependency>

<dependency>
  <groupId>io.dapr</groupId>
  <artifactId>dapr-sdk-springboot</artifactId>
  <version>1.10.0</version>
</dependency>
```