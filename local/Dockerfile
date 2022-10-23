FROM openjdk:11
EXPOSE 8089
ADD /target/local-0.0.1-SNAPSHOT.jar micro-local-docker.jar
ENTRYPOINT ["java", "-jar","micro-local-docker.jar"]