FROM openjdk:8-jdk-alpine

VOLUME /tmp

RUN echo "Asia/Shanghai" > /etc/timezone

COPY target/*.war /app.war

ENV LANG C.UTF-8

java -Djava.security.egd=file:/dev/./urandom -jar /app.war