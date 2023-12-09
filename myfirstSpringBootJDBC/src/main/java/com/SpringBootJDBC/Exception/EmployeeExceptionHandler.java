package com.SpringBootJDBC.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)

	public final ResponseEntity<Exception> handleEmployeeException(Exception ex, WebRequest request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------Exception comming my custome data--------");

		ApplicationInfoError applicationInfoError = new ApplicationInfoError(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
