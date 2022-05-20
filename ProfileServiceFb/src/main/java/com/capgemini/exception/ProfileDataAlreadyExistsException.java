package com.capgemini.exception;

public class ProfileDataAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	// default constructor
	public ProfileDataAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public ProfileDataAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
