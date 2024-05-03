
FROM maven:3.9.0 AS maven
LABEL MAINTAINER="augustogeria2@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

# For Java 17,
FROM openjdk:17-jdk-alpine

ARG JAR_FILE=ApplicationChallenge-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the ApplicationChallenge-0.0.1-SNAPSHOT.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","ApplicationChallenge-0.0.1-SNAPSHOT.jar"]