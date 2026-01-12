package com.example.restdemo.exception.handler;

import com.example.restdemo.entity.StudentErrorResponse;
import com.example.restdemo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
        //create student error response

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
