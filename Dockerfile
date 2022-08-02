FROM openjdk:17

MAINTAINER filatov.tech

COPY target/best-rest-1.0.jar best-rest-1.0.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/best-rest-1.0.jar"]