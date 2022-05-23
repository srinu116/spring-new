package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = -3179418022574795031L;
	
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
