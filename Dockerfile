FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/mini-project-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/mini-project.jar"]