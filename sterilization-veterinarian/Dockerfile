# FROM openjdk:8
# EXPOSE 8082
# ADD target/SterilizationMS-0.0.1-SNAPSHOT.jar sterilization.jar

# ENTRYPOINT ["java","-jar" , "sterilization.jar"]

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
ENV petMS.base = http://gateway:8888/pets
ENV vetoMS.base = http://gateway:8888/veterinarians

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/app/target/SterilizationMS-0.0.1-SNAPSHOT.jar /usr/local/lib/sterilization.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/local/lib/sterilization.jar"]