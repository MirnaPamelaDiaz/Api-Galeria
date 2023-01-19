FROM jdk-11.0.12
COPY target/demo-0.0.1-SNAPSHOT.jar galeria.jar
ENTRYPOINT ["java","jar","/galeria.jar"]