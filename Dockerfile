FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -v
COPY . .

RUN apt-get install maven -y
RUN mvn clean install


FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/gereaulas-0.0.1-SNAPSHOT.jar gereaulas_app.jar

ENTRYPOINT [ "java", "-jar", "gereaulas_app.jar" ]