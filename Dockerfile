

FROM maven:3.9.2-eclipse-temurin-17


WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/task-0.0.1-SNAPSHOT.jar"]