# tapr-2023-equipe2-professor-java

## Api `/api/v1/professores`

### **Status 2xx successfull**

| Endpoint  | Method  | Req.Body  | Status  | Resp.Body  | Description  |
|---|---|---|---|---|---|
| `/api/v1/professores`  | `GET`  |   | 200  | Professor[]  | Returns all Professors.  |
| `/api/v1/professores`  | `POST`  | Professor  | 201  | Professor  | Creates a new Professor  |
| `**/id/{id}`  | `GET`  |   | 200  | Professor  | Get the Professor with the given id.  |
| `**/documento/{documento}`  | `GET`  |   | 200  | Professor  | Get the documento with the given documento.  |
| `**/update/{id}`  | `PUT`  | UpdateReq  | 200  | Professor  | Updates existing professor.  |
| `**/{id}`  | `DELETE`  |   | 204  |   | Deletes the professor with the given id.  |

### **Status 4xx error**

| Endpoint  | Method  | Req.Body  | Status  | Resp.Body  | Description  |
|---|---|---|---|---|---|
| `/api/v1/professores`  | `GET`  |   | 200  | Professor[] | Returns empty array.  |
| `/api/v1/professores`  | `POST`  | Professor  | 400, 409  | ErrorMessage  | Bad request or Conflict.  |
| `**/id/{id}`  | `GET`  |   | 404  | ErrorMessage  | Not Found.  |
| `**/documento/{documento}`  | `GET`  |   | 404  | ErrorMessage  |  Not Found.  |
| `**/update/{id}`  | `PUT`  | UpdateReq | 400, 404  | ErrorMessage  | Bad Request or Not Found.  |
| `**/delete/{id}`  | `DELETE`  |   | 404  | ErrorMessage  | Not Found.  |

### Request and Response examples:

### Post `/api/v1/professores`

- Request body:
```
{
    "nome": "leonardo",
    "documento": "654616846846",
    "cep": "89223-390",
    "telefone": "49 99972-8265",
    "email": "leonardozw@gmail.com",
    "dataNascimento": "2000-05-27"
}
```

- Response:
```
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 09 Nov 2023 22:56:08 GMT
Connection: close

{
  "id": "bc498ae7-6d37-447c-bbbc-2625196576d8",
  "nome": "leonardo",
  "documento": "654616846846",
  "cep": "89223-390",
  "telefone": "49 99972-8265",
  "email": "leonardozw@gmail.com",
  "dataNascimento": "2000-05-27",
  "createdAt": "2023-11-09T22:56:08.393895900Z",
  "lastUpdatedAt": null
}
```

### PUT `/api/v1/professores/update/{id}`

- Request body:
```
{
  "nome": "leonardo ZW",
  "documento": "654616846846",
  "cep": "89223-390",
  "telefone": "49 99972-8265",
  "email": "leonardo@gmail.com",
  "dataNascimento": "2000-05-27"
}
```
- Response:
```
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 09 Nov 2023 22:59:13 GMT
Connection: close

{
  "id": "bc498ae7-6d37-447c-bbbc-2625196576d8",
  "nome": "leonardo ZW",
  "documento": "654616846846",
  "cep": "89223-390",
  "telefone": "49 99972-8265",
  "email": "leonardo@gmail.com",
  "dataNascimento": "2000-05-27",
  "createdAt": "2023-11-09T22:56:08.393895900Z",
  "lastUpdatedAt": "2023-11-09T22:59:13.163133100Z"
}
```

## Docs

[Azure CLI DOCS](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli-linux?pivots=apt)
### CosmosDB
- [Introdução](https://learn.microsoft.com/en-us/azure/cosmos-db/introduction)
- [Databases, containers, and items](https://learn.microsoft.com/en-us/azure/cosmos-db/resource-model)
- [Samples](https://github.com/Azure-Samples/azure-spring-data-cosmos-java-sql-api-samples)

```properties
#logar no azure
az login -u user@unville.br

#checar usuario logado
az ad signed-in-user show

#gives permission to read and write on cosmos
az cosmosdb sql role assignment create --account-name COSMOSDBACCOUNT --resource-group GRUPODERECURSO --role-assignment-id 00000000-0000-0000-0000-000000000002 --role-definition-name "Cosmos DB Built-in Data Contributor" --scope "/" --principal-id GUIDUSUARIOAD
```

**Dependencies:**
- Cosmos DB related dependencies:
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
- Azure identity related dependency:
```properties
		<dependency>
			<groupId>com.azure</groupId>
			<artifactId>azure-identity</artifactId>
			<version>1.10.0</version>
		</dependency>
```
- Springdoc OpenAPI Swagger dependency:
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