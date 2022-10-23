FROM openjdk:8
EXPOSE 8888
ADD /target/APIGateway-3-0.0.1-SNAPSHOT.jar gateway-service.jar
ENTRYPOINT ["java","-jar" , "gateway-service.jar"]