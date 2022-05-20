package com.capgemini.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Value(value = "${data.exception.dataExists}")
	private String dataExists;

	@ExceptionHandler(value = PostDataAlreadyExistsException.class)
	public ResponseEntity<String> PostDataAlreadyExistsException(PostDataAlreadyExistsException pae) {
		return new ResponseEntity<String>(dataExists, HttpStatus.CONFLICT);
	}

	@Value(value = "${data.exception.dataNotFound}")
	private String dataNotFound;

	@ExceptionHandler(value = PostIdNotFound.class)
	public ResponseEntity<String> PostIdNotFound(PostIdNotFound pin) {
		return new ResponseEntity<String>(dataNotFound, HttpStatus.CONFLICT);
	}
}
