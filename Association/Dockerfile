FROM openjdk:8
EXPOSE 8087
ADD /target/Association-0.0.1-SNAPSHOT.jar association-service.jar
ENTRYPOINT ["java","-jar","association-service.jar"]