package br.newtonpaiva.lab.tcc.application.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.lab.tcc.api.hello.resource.HelloResource;
import br.newtonpaiva.lab.tcc.api.hello.response.HelloResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController implements HelloResource{

	@Override
	public ResponseEntity<HelloResponse> hello() {
		log.info("Chamando o Hello!");
		
		var response = new HelloResponse("Hello REST!");
		
		return ResponseEntity.ok(response);
	}

}
