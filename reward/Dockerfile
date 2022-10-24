# FROM openjdk:11
# EXPOSE 8085
# ADD /target/reward-0.0.1-SNAPSHOT.jar micro-reward-docker.jar
# ENTRYPOINT ["java", "-jar","micro-reward-docker.jar"]

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
COPY --from=build /home/app/target/reward-0.0.1-SNAPSHOT.jar /usr/local/lib/micro-reward-docker.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/usr/local/lib/micro-reward-docker.jar"]