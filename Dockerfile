FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/client-person-devsu-0.0.1-SNAPSHOT.jar client-person.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "client-person.jar"]