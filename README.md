## Getting Started

### Run the application and DB
> [!NOTE]
> If you need to start on your local, please see the [wiki](https://github.com/Katsu0424/play-ground/wiki/start-on-your-local#start-on-your-local)
```bash
docker-compose up --build -d
```

### Run sqldef
You need to install [go](https://go.dev/doc/install) and [sqldef](https://github.com/sqldef/sqldef) in advance before running the following commands.
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
- coroutin(Consider compatibility with mysql, Exposed and Embedded Web Servers)
- Certification(Spring Security, OAuth2.0)
- Cache(Redis)
- ELK
- Kafka
- TestContainers for integration test
- (maybe)K8s, migrate to [modular monolith](https://r-kaga.com/blog/what-is-modular-monolith), microservices

### Tech Stack
- Java 17  
- Kotlin 1.9.24
- Spring Boot 3.4.0  
- MySQL 8.0
- Exposed 0.58.0  
- ktlint 1.5.0  
- Kotest
- sqldef
