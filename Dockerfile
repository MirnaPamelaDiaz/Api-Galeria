FROM amazoncorretto:11-alpine-jdk
COPY target/demo-0.0.1-SNAPSHOT.jar galeria.jar
ENTRYPOINT ["java","jar","/galeria.jar"]