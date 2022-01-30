FROM openjdk:8
VOLUME /tmp
EXPOSE 4060
ADD target/springbootdocker-0.0.1-SNAPSHOT.jar springbootdocker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","springbootdocker-0.0.1-SNAPSHOT.jar"]