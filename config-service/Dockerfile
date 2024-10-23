FROM openjdk:21-oracle
COPY target/*.jar app.jar
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "app.jar"]