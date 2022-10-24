FROM openjdk:11
EXPOSE 8094
ADD /target/Local-0.0.1-SNAPSHOT.jar local-service.jar
ENTRYPOINT ["java","-jar" , "local-service.jar"]