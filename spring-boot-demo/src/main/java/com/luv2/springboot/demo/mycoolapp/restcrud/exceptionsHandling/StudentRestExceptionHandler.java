package com.luv2.springboot.demo.mycoolapp.restcrud.exceptionsHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.StudentErrorResponse;
import com.luv2.springboot.demo.mycoolapp.restcrud.exceptions.StudentNotFoundException;

@ControllerAdvice 
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe) {
        return new ResponseEntity<StudentErrorResponse>(
            new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), snfe.getMessage(), 
            new Date().getTime()), HttpStatus.NOT_FOUND); 
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) {
        return new ResponseEntity<StudentErrorResponse>(
            new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exp.getMessage(), 
            new Date().getTime()), HttpStatus.BAD_REQUEST); 
    }

}
