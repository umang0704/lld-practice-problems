FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the Spring Boot JAR (update name if needed)
COPY build/libs/spring_tempalte-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8005

ENTRYPOINT ["java", "-jar", "app.jar"]
