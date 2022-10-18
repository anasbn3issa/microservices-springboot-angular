FROM openjdk:8
EXPOSE 8082
ADD target/SterilizationMS-0.0.1-SNAPSHOT.jar sterilization.jar

ENV REDIS_HOST=redis
ENV REDIS_PORT=6379
ENV REDIS_PASSWORD=

ENTRYPOINT ["java","-jar" , "sterilization.jar"]