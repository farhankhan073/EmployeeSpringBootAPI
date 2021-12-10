package com.test.hr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> specialException(
    		CustomException e) throws Exception {

    	ExceptionResponse es =new ExceptionResponse();
    	es.setCode(HttpStatus.BAD_REQUEST.value());
    	es.setMessage(e.getMessage());

        return new ResponseEntity<ExceptionResponse>(es, HttpStatus.BAD_REQUEST);
    }


}
