FROM openjdk:11
EXPOSE 8085
ADD /target/reward-0.0.1-SNAPSHOT.jar micro-reward-docker.jar
ENTRYPOINT ["java", "-jar","micro-reward-docker.jar"]