package br.newtonpaiva.lab.tcc.api.professores.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.newtonpaiva.lab.tcc.api.professores.request.ProfessorRequest;
import br.newtonpaiva.lab.tcc.api.professores.response.ProfessorResponse;

@RequestMapping(path = "/v1/professores")
public interface ProfessoresResource {

    // GET listagem
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessorResponse>> getAll();
    
    // GET by ID
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessorResponse> getById(@PathVariable Optional<String> id);

    // POST criar
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessorResponse> create(
            @Valid @RequestBody Optional<ProfessorRequest> request);
    
    // PUT atualizar
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessorResponse> update(
            @PathVariable Optional<String> id, 
            @RequestBody Optional<ProfessorRequest> request
            );
    
    // DELETE excluir
    @DeleteMapping(path = "/{id}")    
    public ResponseEntity<Void> deleteById(@PathVariable Optional<String> id);
}
