FROM openjdk:11
WORKDIR /app
COPY target/fincraft-assignment-0.0.1-SNAPSHOT.jar fincraft-assignment.jar
ENTRYPOINT ["java", "-jar", "fincraft-assignment.jar"]
