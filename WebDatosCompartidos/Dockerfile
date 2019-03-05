FROM openjdk:8-jdk-alpine
COPY /target/datos-compartidos-service-1.0.jar /datos-compartidos-service-1.0.jar
ENTRYPOINT ["java","-Djava.segurity.egd=file:/dev/./urandom","-Dspring.profiles.active=cloud","-jar","/datos-compartidos-service-1.0.jar"]
EXPOSE 8080 