# instant-spring-boot-kotlin-graphql-mysql-app

## Technologies and Frameworks
* [Kotlin](https://kotlinlang.org/)
* [Gradle](https://gradle.org/): Build tool
* [Spring Boot](https://spring.io/projects/spring-boot) 
* [MySQL](https://www.mysql.com/)
* [GraphQL](https://graphql.org/)
* [GraphiQL](https://github.com/graphql/graphiql): An in-browser IDE for exploring GraphQL.

## Feature Highlights
* [Flyway](https://flywaydb.org/): For database migrations
* [TestContainers](https://www.testcontainers.org/): Docker containers for integration tests
* Application logging via logback (`src/main/resources/logback-spring.xml`)
* Access logs using logback (`src/main/resources/logback-access.xml`)
* Distributed Spring Scheduler using [ShedLock](https://github.com/lukas-krecan/ShedLock)
* Amazing local dev loop using dockerized mysql instance wired up to gradle bootRun

#### Security
JWT authentication is enabled for all endpoints, authentication is in-memory for now but can be replaced by db based `CustomUserDetailsService`

## How to run locally

All you have to do is run gradle bootRun task, this spins up a mysql docker container.  
```
./gradlew bootRun
```
Flyway creates the db schema on startup. 

Since the endpoints are protected, we need to get the JWT token first
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

![Set ModHeader](screenshots/ModHeader.png)

The application can now be accessed at 
```
http://localhost:8080/graphiql
``` 

Sample GraphQL mutation query

![GraphiQL Mutation Query](screenshots/GraphiQLMutation.png)

## Running Integration Tests
```
./gradlew test
```

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
