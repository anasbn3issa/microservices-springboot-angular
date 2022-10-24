# FROM openjdk:8
# EXPOSE 8888
# ADD /target/APIGateway-3-0.0.1-SNAPSHOT.jar gateway-service.jar
# ENTRYPOINT ["java","-jar" , "gateway-service.jar"]

#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -q -Dmaven.test.skip -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/app/target/APIGateway-3-0.0.1-SNAPSHOT.jar /usr/local/lib/gateway-service.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/usr/local/lib/gateway-service.jar"]