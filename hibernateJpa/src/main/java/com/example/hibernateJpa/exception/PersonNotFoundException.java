package com.example.hibernateJpa.exception;

public class PersonNotFoundException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
//	String applicationStatusCode;
	public PersonNotFoundException(String message) {
		super(message);
	}
	

}
