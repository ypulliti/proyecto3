FROM openjdk:11.0.15
ARG JAR_FILE=target/bc30-project02-part04-business-microservice04-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} bc30-project02-part04-business-microservice04-0.0.1-SNAPSHOT.jar
EXPOSE 8094
ENTRYPOINT ["java","-jar","/bc30-project02-part04-business-microservice04-0.0.1-SNAPSHOT.jar"]