package com.raman.empdemoglobexcp.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.raman.empdemoglobexcp.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
	{
		return new ResponseEntity<String>("Input Field is Empty, Please look into it ", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException)
	{
		return new ResponseEntity<String>("No Such value Exist, Please change ur request ", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleNoSuchElement(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException)
	{
		return new ResponseEntity<String>("Input type Mistmatch, Please change input type of your request", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
}
