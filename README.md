# tapr-2023-equipe2-professor-java

## Autenticação no AZURE
[Azure CLI DOCS](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli-linux?pivots=apt)

```properties
#logar no azure
az login -u "user@unville.br"

#checar usuario logado
az ad signed-in-user show
```

Dependencies:
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