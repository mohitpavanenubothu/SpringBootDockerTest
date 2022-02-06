package com.sbms.util;

public class DockerSteps {
	
	/*E:\SpringWS\GithubWS\SpringBootDockerTest>docker --version
	Docker version 20.10.12, build e91ed57
	
	E:\SpringWS\GithubWS\SpringBootDockerTest>docker login
	
	#FROM <image>
	FROM openjdk:11
	#Temp Run location
	VOLUME /tmp
	#Provide Port Information
	EXPOSE 4060
	#Jar location to mapping name
	ADD target/spring-boot-docker.jar spring-boot-docker.jar
	#Jar Execution command
	ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
	
	docker build -f Dockerfile -t spring-boot-docker.jar .
	docker tag spring-boot-docker mohitpavanenubothu/mohitrepotest:latest
	docker push mohitpavanenubothu/mohitrepotest:latest*/

}
