# FROM openjdk:8
# EXPOSE 8091
# ADD /target/Vaccination-0.0.1-SNAPSHOT.jar vaccination-service.jar
# ENTRYPOINT ["java","-jar" , "vaccination-service.jar"]

#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -q -Dmaven.test.skip -f /home/app/pom.xml clean package

ENV REDIS_HOST=redis
ENV REDIS_PORT=6379
ENV REDIS_PASSWORD=

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/app/target/Vaccination-0.0.1-SNAPSHOT.jar /usr/local/lib/vaccination-service.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/usr/local/lib/vaccination-service.jar"]