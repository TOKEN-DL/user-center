FROM maven:3.9-jdk-21-alpine as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src



RUN mvn package -DskipTests



CMD ["java","-jar","/app/target/user-center-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]