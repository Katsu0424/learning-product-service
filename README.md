# Project Setup

## TODO
- ktlint by pre-commit
- TestContainers for integration test
- Docker for mysql
- Exposed-json
- CI by github actions
- Migration by sqldef
- openapi
  - put the link on readme
- coroutin(Consider compatibility with mysql, Exposed and Embedded Web Servers)
- Certification
- Cache
- (maybe)K8s, migrate to [modular monolith](https://r-kaga.com/blog/what-is-modular-monolith), microservices

## Tech Stack
- Java 17  
- Kotlin 2.1.0  
- Spring Boot 3.4.0  
- MySQL (TBD)  
- Exposed 0.58.0  
- ktlint 1.5.0  
- Kotest  

## JDK Management
Using [SDKMAN!](https://sdkman.io/) to manage JDK versions.

## Code Lint & Format
```bash
./gradlew ktlintCheck   # Check for lint issues
./gradlew ktlintFormat  # Auto-format code
