package br.newtonpaiva.si.aaw.tcc.ref.api.hello.resource;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.newtonpaiva.si.aaw.tcc.ref.api.hello.request.HelloRequest;
import br.newtonpaiva.si.aaw.tcc.ref.api.hello.response.HelloResponse;

public interface HelloResource {

	@RequestMapping(path = "/v1/health")
    @GetMapping
    public ResponseEntity<HelloResponse> healthCheck(@RequestParam Optional<HelloRequest> request);

}

