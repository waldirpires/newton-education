package com.example.livros.api;

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

@RequestMapping(path = "/v1/livros")
public interface LivrosResource {

    // GET listagem
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroResponse>> getAll();
    
    // GET by ID
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> getById(@PathVariable Optional<String> id);

    // POST criar
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> create(
            @Valid @RequestBody Optional<LivroRequest> request);
    
    // PUT atualizar
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> update(
            @PathVariable Optional<String> id, 
            @RequestBody Optional<LivroRequest> request
            );
    
    // DELETE excluir
    @DeleteMapping(path = "/{id}")    
    public ResponseEntity<Void> deleteById(@PathVariable Optional<String> id);
}
