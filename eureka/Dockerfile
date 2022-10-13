FROM openjdk:8
EXPOSE 8761
ADD /target/discovery-0.0.1-SNAPSHOT.jar discovery-service.jar
ENTRYPOINT ["java","-jar" , "discovery-service.jar"]