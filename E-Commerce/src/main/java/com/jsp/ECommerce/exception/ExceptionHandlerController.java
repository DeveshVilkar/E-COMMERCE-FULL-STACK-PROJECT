package com.jsp.ECommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsp.ECommerce.model.ResponseStructure;

@ControllerAdvice
public class ExceptionHandlerController {
	@ExceptionHandler(value=CustomException.class)
	public ResponseEntity<String> handleCustomException(CustomException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AuthenticationFailedException.class)
	public ResponseEntity<String> handleUpdateFailException(AuthenticationFailedException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFound(ProductNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
