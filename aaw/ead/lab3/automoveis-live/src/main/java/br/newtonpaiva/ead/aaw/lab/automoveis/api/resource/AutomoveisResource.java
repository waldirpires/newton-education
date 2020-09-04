package br.newtonpaiva.ead.aaw.lab.automoveis.api.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.newtonpaiva.ead.aaw.lab.automoveis.api.request.AutomovelRequest;
import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.AutomovelResponse;

@RequestMapping(path = "/v1/automoveis")
public interface AutomoveisResource {
	
	
	@GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AutomovelResponse> getById(@PathVariable Optional<String> id);

	
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AutomovelResponse> create(
    		@RequestBody(required = true) @Valid Optional<AutomovelRequest> request
    		);


	@PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AutomovelResponse> update(
    		@PathVariable Optional<UUID> id, @RequestBody Optional<AutomovelRequest> request
    		);


	@DeleteMapping(path = "/{id}")    
    public ResponseEntity<UUID> deleteById(@PathVariable Optional<String> id);

	
	@GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AutomovelResponse>> getAll();

}
