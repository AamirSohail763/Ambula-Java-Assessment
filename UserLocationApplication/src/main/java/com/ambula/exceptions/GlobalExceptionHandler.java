package com.ambula.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserException.class)    //For user related exceptions
	public ResponseEntity<ErrorDetails> UserExceptionHandler(UserException ue, WebRequest wr){
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDate.now());
		err.setMessage(ue.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)    //For access related exceptions
	public ResponseEntity<ErrorDetails> AccessDeniedExceptionHandler(AccessDeniedException ae, WebRequest wr){
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDate.now());
		err.setMessage(ae.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(Exception.class)       //For all other exceptions
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception e, WebRequest wr){
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDate.now());
		err.setMessage(e.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

}
