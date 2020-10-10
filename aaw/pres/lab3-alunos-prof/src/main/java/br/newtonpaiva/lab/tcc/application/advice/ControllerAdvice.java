package br.newtonpaiva.lab.tcc.application.advice;

import java.time.LocalDateTime;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.newtonpaiva.lab.tcc.api.error.response.ErrorResponse;
import br.newtonpaiva.lab.tcc.common.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {

        log.info(ex.getMessage());

        ErrorResponse response = new ErrorResponse()
                .withError(ex.getClass().getSimpleName())
                .withMessage(ex.getMessage())
                .withStatus(404)
                .withTimestamp(LocalDateTime.now());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(Exception ex) {

        log.info(ex.getMessage());

        ErrorResponse response = new ErrorResponse()
                .withError(ex.getClass().getSimpleName())
                .withMessage(ex.getMessage())
                .withStatus(400)
                .withTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        log.info(ex.getMessage());

        ErrorResponse response = new ErrorResponse()
                .withError(ex.getClass().getSimpleName())
                .withMessage(ex.getMessage())
                .withStatus(500)
                .withTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
