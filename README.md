# Project Setup

## TODO
- ktlint by pre-commit
- TestContainers for integration test
- Docker for mysql
- Migration by sqldef
- Certification
- Cache
- (maybe)K8s

## Tech Stack
- Java 17  
- Kotlin 2.1.0  
- Spring Boot 3.4.0  
- MySQL (TBD)  
- Exposed 0.58.0  
- ktlint 1.5.0  
- Kotest  

## JDK Management
Ussing [SDKMAN!](https://sdkman.io/) to manage JDK versions.

## Code Lint & Format
```bash
./gradlew ktlintCheck   # Check for lint issues
./gradlew ktlintFormat  # Auto-format code
