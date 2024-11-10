FROM openjdk:latest

WORKDIR /app

COPY target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.devtools.restart.enabled=true", "app.jar"]