package com.sbms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentErrorHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(StudentNotFoundException snf) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), snf.getMessage(), "404- Student Not Found");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in execution");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
