# FROM openjdk:11
# EXPOSE 8094
# RUN mvn package
# ADD /target/Local-0.0.1-SNAPSHOT.jar local-service.jar
# ENTRYPOINT ["java","-jar" , "local-service.jar"]

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
FROM openjdk:11
COPY --from=build /home/app/target/Local-0.0.1-SNAPSHOT.jar /usr/local/lib/local-service.jar
EXPOSE 8094
ENTRYPOINT ["java","-jar","/usr/local/lib/local-service.jar"]