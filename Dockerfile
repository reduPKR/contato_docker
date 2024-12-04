FROM openjdk:17-jdk

WORKDIR /app

COPY target/contato-0.0.1-SNAPSHOT.jar contato-app.jar

EXPOSE 8080
EXPOSE 8082

CMD ["java", "-jar", "contato-app.jar"]
