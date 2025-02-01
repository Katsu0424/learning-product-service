# Project Setup

## TODO
- Migration by sqldef
- TestContainers for integration test
- CI by github actions
- openapi
  - put the link on readme
- coroutin(Consider compatibility with mysql, Exposed and Embedded Web Servers)
- Certification
- Cache
- (maybe)K8s, migrate to [modular monolith](https://r-kaga.com/blog/what-is-modular-monolith), microservices

## JDK Management
Using [SDKMAN!](https://sdkman.io/) to manage JDK versions.</br>
After installing, you can easily switch to the versions specified in your `.sdkmanrc` by running:
```bash
sdk env
```
and then if you don't have a suitable version for this app, please do below
```bash
sdk env install
```

## bootrun
```bash
docker-compose up --build -d
```

## Tech Stack
- Java 17
- Kotlin 2.1.0
- Spring Boot 3.4.0
- MySQL 8.0
- Exposed 0.58.0
- ktlint 1.5.0
- Kotest

## Code Lint & Format
```bash
./gradlew ktlintCheck   # Check for lint issues
./gradlew ktlintFormat  # Auto-format code
```
