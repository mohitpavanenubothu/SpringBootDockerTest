package com.sbms.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/docker")
@Slf4j
public class MessageRestController {

	@GetMapping("/welcome")
	public String showMsg() {
		String user1 = "Mohit";
		log.info("Inside MessageController");
		LocalDateTime ldt = LocalDateTime.now();
		log.info("Jenkins Test");
		int hour = ldt.getHour();
		if (hour < 12)
			return "Good Morning " + user1;
		else if (hour < 16)
			return "Good Afternoon " + user1;
		else if (hour < 20)
			return "Good Evening " + user1;
		else
			return "Good Night " + user1;
	}

	@GetMapping("/show")
	public ResponseEntity<String> getMsg() {
		log.info("Inside getMessage method of message controller");
		String body = null;
		String user = "Karthik";
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if (hour < 12)
			body = "Good Morning " + user;
		else if (hour < 16)
			body = "Good Afternoon " + user;
		else if (hour < 20)
			body = "Good evening " + user;
		else
			body = "Good Night " + user;
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}

}
