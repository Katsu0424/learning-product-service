## Getting Started

### Run the application and DB
> [!NOTE]
> If you need to start on your local, please see the [wiki](https://github.com/Katsu0424/test-containers/wiki/start-on-your-local#start-on-your-local)
```bash
docker-compose up --build -d
```

### Run sqldef
You need to install [sqldef](https://github.com/sqldef/sqldef) in advance before running the following commands.
```bash
# dry-run to check the diff
mysqldef -umy_user -pmy_pass my_database --dry-run < db/migration/v0.sql
# execution
mysqldef -umy_user -pmy_pass my_database < db/migration/v0.sql
```

### Code Lint & Format
```bash
./gradlew ktlintCheck   # Check for lint issues
./gradlew ktlintFormat  # Auto-format code
```

## Others

### TODO
- Docker for mysql
- Exposed-json
- Migration by sqldef
- TestContainers for integration test
- CI by github actions
- openapi
  - put the link on readme
- coroutin(Consider compatibility with mysql, Exposed and Embedded Web Servers)
- Certification
- Cache
- (maybe)K8s, migrate to [modular monolith](https://r-kaga.com/blog/what-is-modular-monolith), microservices

### Tech Stack
- Java 17  
- Kotlin 2.1.0  
- Spring Boot 3.4.0  
- MySQL (TBD)  
- Exposed 0.58.0  
- ktlint 1.5.0  
- Kotest
