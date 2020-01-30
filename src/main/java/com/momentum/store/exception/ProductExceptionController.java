package com.momentum.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductCodeNotfoundException.class)
	public ResponseEntity<Object> exception(ProductCodeNotfoundException exception) {
		return new ResponseEntity<>("Product Code not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
		return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InsufficientPointException.class)
	public ResponseEntity<Object> exception(InsufficientPointException exception) {
		return new ResponseEntity<>("You do not have sufficient points", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoProductProvidedException.class)
	public ResponseEntity<Object> exception(NoProductProvidedException exception) {
		return new ResponseEntity<>("You have not provided any product. Please select a product", HttpStatus.NOT_FOUND);
	}
}