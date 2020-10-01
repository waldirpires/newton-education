package com.example.livros.application;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.livros.api.error.ErrorResponse;
import com.example.livros.common.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        
        log.info(ex.getMessage());

        ex.printStackTrace();               
        
        var response = new ErrorResponse()
                .withError(ex.getMessage())
                .withMessage(ex.getMessage())
                .withStatus(404)
                .withTimestamp(ZonedDateTime.now());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }   

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        
        log.info(ex.getMessage());
        
        ex.printStackTrace();               

        var response = new ErrorResponse()
                .withError(ex.getMessage())
                .withMessage(ex.getMessage())
                .withStatus(500)
                .withTimestamp(ZonedDateTime.now());
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }   
}