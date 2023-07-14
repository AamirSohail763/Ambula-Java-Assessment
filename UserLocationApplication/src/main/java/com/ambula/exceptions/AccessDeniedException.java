package com.ambula.exceptions;

public class AccessDeniedException extends RuntimeException{

	private static final long serialVersionUID = 1L;


	public AccessDeniedException() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AccessDeniedException(String message) {
		super(message);
	}

}
