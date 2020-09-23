package br.newtonpaiva.ead.aaw.lab.automoveis.application.controllers;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.ErrorMessage;
import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.ErrorMessageResponse;
import br.newtonpaiva.ead.aaw.lab.automoveis.common.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class AutomovelControllerAdvice {

	@ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageResponse> handleConstraintProblemException(NotFoundException ex) {
        
		log.info(ex.getMessage());
		
		var msg = new ErrorMessage().withTitle(ex.getClass().getSimpleName()).withDescription(ex.getMessage());
		var response = new ErrorMessageResponse().withCode(NOT_FOUND.value()).withMessages(asList(msg));
		
		return ResponseEntity.status(NOT_FOUND).body(response);
    }	


	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageResponse> handleException(Exception ex) {
        
		log.info(ex.getMessage());
		
		var msg = new ErrorMessage().withTitle(ex.getClass().getSimpleName()).withDescription(ex.getMessage());
		var response = new ErrorMessageResponse().withCode(NOT_FOUND.value()).withMessages(asList(msg));
		
		return ResponseEntity.status(NOT_FOUND).body(response);
    }	
}
