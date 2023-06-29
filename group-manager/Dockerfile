FROM maven:3.8.1-openjdk-17-slim as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17.0.1-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/gr*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8887
EXPOSE 443
EXPOSE 27017
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"] 