# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

ENV URL_BANCO jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE
ENV USUARIO senha_bd

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]