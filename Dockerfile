FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY build/libs/play-ground-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
