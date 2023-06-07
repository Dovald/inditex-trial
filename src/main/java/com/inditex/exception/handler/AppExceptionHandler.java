package com.inditex.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.inditex.dto.ErrorDTO;
import com.inditex.exception.DateException;
import com.inditex.exception.InvalidProductException;

@ControllerAdvice
public class AppExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { DateException.class })
    protected ResponseEntity<Object> handleDateException(RuntimeException ex, WebRequest request) {
    	
    	ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setErrorMessage(ex.getMessage());
        
        return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
    @ExceptionHandler(value = { InvalidProductException.class })
    protected ResponseEntity<Object> handleInvalidProductException(RuntimeException ex, WebRequest request) {
    	
    	ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setErrorMessage(ex.getMessage());
        
        return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}