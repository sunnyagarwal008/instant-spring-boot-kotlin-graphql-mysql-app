# instant-spring-boot-kotlin-graphql-mysql-app

## Technologies and Frameworks
* [Kotlin](https://kotlinlang.org/)
* [Gradle](https://gradle.org/): Build tool
* [Spring Boot](https://spring.io/projects/spring-boot) 
* [MySQL](https://www.mysql.com/)
* [GraphQL](https://graphql.org/)
* [GraphiQL](https://github.com/graphql/graphiql): An in-browser IDE for exploring GraphQL.

## Highlights
* [Flyway](https://flywaydb.org/): For database migrations
* [TestContainers](https://www.testcontainers.org/): Docker containers for integration tests
* JWT Authentication for endpoints

#### Security
JWT authentication is enabled for all endpoints

Authenticate to get JWT token, it's set in response header
```
➜ ✗ http http://localhost:8080/authenticate\?username\=user\&password\=password
HTTP/1.1 200
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJ0YXhpZnktYXBwIiwiYXVkIjoidGF4aWZ5LWFwcCIsInN1YiI6InVzZXIiLCJleHAiOjE1NTg2ODE1NjEsInJvbGUiOlsiUk9MRV9VU0VSIl19.PT8dSLZi3TXGa7Wly83F8-aMghLdCVglBhtyPjFCLyKy5jBKv-vlJ1_76I8euvYL7MhrLbGkO1I4Zk_pQMmYqw
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Content-Length: 0
Date: Tue, 14 May 2019 07:06:01 GMT
Expires: 0

Pragma: no-cache
X-Content-Type-Options: nosniff
X-Frame-Options: DENY
X-XSS-Protection: 1; mode=block
```

Now to use GraphiQL to run graphql queries, we need to set the Authorization header using  [ModHeader](https://chrome.google.com/webstore/detail/modheader/idgpnmonknjnojddfkpgkljpfnnfcklj?hl=en) chrome extension 

![Set ModHeader](/screenshots/ModHeader.png?raw=true "Setting Authorization Header")

![GraphiQL Mutation Query](/screenshots/GraphiQLMutation.png?raw=true "GraphiQL Mutation Query")


## TODO list
- [X] Spring Boot Kotlin WebApp with GraphQL
- [X] Add Spring actuator metrics for JVM and application metrics including GraphQL
- [X] Add authentication using JWT
- [X] Add support to use GraphiQL with JWT
- [X] Add MySQL support using Spring data JPA
- [X] Create a complex schema type with query and mutations
- [X] Add Flyway, migrations via rest endpoint
- [ ] Add support to generate data classes from schema
- [X] Setup MySQL docker container for integration tests
- [X] Add integrations tests with graphql client
- [ ] Make this a multi module gradle project
- [X] Create profile for WebServer and Worker nodes
- [X] Add distributed scheduler
- [X] Enable access logs 
