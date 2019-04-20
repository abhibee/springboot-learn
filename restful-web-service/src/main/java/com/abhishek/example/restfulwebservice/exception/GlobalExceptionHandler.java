package com.abhishek.example.restfulwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abhishek.example.restfulwebservice.users.UserNotFoundException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){		
		ExceptionResponseTemplate expResp=new ExceptionResponseTemplate(ex.getMessage(),new Date(),req.getDescription(true) );
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException ex, WebRequest req){		
		ExceptionResponseTemplate expResp=new ExceptionResponseTemplate(ex.getMessage(),new Date(),req.getDescription(true) );
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponseTemplate expResp=new ExceptionResponseTemplate("Validation failed",new Date(),ex.getBindingResult().getFieldErrors().toString() );
		return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);		
		
//		return handleExceptionInternal(ex, null, headers, status, request);
	}

	
}
