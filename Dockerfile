### STAGE 1: Build  ###
FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY src /workspace/src
COPY pom.xml /workspace
RUN mvn -f /workspace/pom.xml clean package

### STAGE 2: Run ###
FROM openjdk:8-jdk-alpine
COPY --from=build /workspace/target/WebNewsBackend-0.0.1-SNAPSHOT.jar /workspace/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/workspace/app.jar"]
#WORKDIR root
#COPY target/*.jar root/
#ENTRYPOINT ["java","-jar","root/SpringWebDocker.jar"]