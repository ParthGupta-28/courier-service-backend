FROM openjdk:19

ENV PORT 8080

COPY courier-service-backend-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","courier-service-backend-0.0.1-SNAPSHOT.jar"]
