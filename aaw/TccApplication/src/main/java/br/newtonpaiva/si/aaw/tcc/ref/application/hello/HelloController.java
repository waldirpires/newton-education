package br.newtonpaiva.si.aaw.tcc.ref.application.hello;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.si.aaw.tcc.ref.api.hello.request.HelloRequest;
import br.newtonpaiva.si.aaw.tcc.ref.api.hello.resource.HelloResource;
import br.newtonpaiva.si.aaw.tcc.ref.api.hello.response.HelloResponse;

@RestController
public class HelloController implements HelloResource {

	@Override
	public ResponseEntity<HelloResponse> healthCheck(Optional<HelloRequest> request) {
		
		return ResponseEntity.ok(new HelloResponse("test"));
	}

}
