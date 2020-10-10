package br.newtonpaiva.lab.tcc.api.hello.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.newtonpaiva.lab.tcc.api.hello.response.HelloResponse;

@RequestMapping(path = "/v1/hello")
public interface HelloResource {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<HelloResponse> hello();
}
