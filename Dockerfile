FROM semeru-11.0.14.1
COPY target/demo-0.0.1-SNAPSHOT.jar galeria.jar
ENTRYPOINT ["java","jar","/galeria.jar"]