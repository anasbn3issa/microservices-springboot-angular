FROM openjdk:8
EXPOSE 9090
ADD /target/Vaccination-0.0.1-SNAPSHOT.jar vaccination-service.jar
ENTRYPOINT ["java","-jar" , "vaccination-service.jar"]