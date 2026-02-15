FROM maven:3.8.7-openjdk-18-slim as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src



RUN mvn package -DskipTests



CMD ["java","-jar","/app/target/user-center-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]