FROM openjdk:latest
COPY target/healthcheck-service-0.0.1.jar healthcheck-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/healthcheck-service-0.0.1.jar"]