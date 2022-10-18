FROM openjdk:8
EXPOSE 8082
ADD target/SterilizationMS-0.0.1-SNAPSHOT.jar sterilization.jar
ENTRYPOINT ["java","-jar" , "sterilization.jar"]