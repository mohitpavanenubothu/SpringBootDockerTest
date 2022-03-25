#From <image>
FROM openjdk:11

#Temp folder to run the APP
VOLUME /tmp

#Provide port number to run the application
EXPOSE 4060

#adding the jar file location to mapping name/alias name
ADD target/spring-boot-docker.jar spring-boot-docker.jar

#Jar Execution command
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]

#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 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
