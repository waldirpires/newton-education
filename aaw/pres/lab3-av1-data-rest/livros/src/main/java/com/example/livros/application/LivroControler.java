package com.example.livros.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.livros.api.LivroRequest;
import com.example.livros.api.LivroResponse;
import com.example.livros.api.LivrosResource;
import com.example.livros.domain.entity.Livro;
import com.example.livros.domain.service.LivroService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LivroControler implements LivrosResource {

    @Autowired
    private LivroService service;

    @Override
    public ResponseEntity<List<LivroResponse>> getAll() {
        log.info("GET livros");

        var livros = service.getLivros();

        var list = new ArrayList<LivroResponse>();

        livros.stream().forEach(l -> {
            list.add(LivroResponse.buildFrom(l));
        });

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<LivroResponse> getById(Optional<String> id) {
        log.info("GET livro by ID: {}", id);

        Livro l = service.getById(id.get());

        return ResponseEntity.ok(LivroResponse.buildFrom(l));
    }

    @Override
    public ResponseEntity<LivroResponse> create(@Valid Optional<LivroRequest> request) {
        log.info("POST criar livro: {}", request);

        log.info(request.get().toString());

        Livro l = new Livro().withAutor(request.get().getAutor())
                .withDataDePublicacao(request.get().getDataDePublicacao()).withEditora(request.get().getEditora())
                .withStatus(request.get().getStatus()).withTitulo(request.get().getTitulo());

        l = service.create(l);

        return ResponseEntity.status(HttpStatus.CREATED).body(LivroResponse.buildFrom(l));
    }

    @Override
    public ResponseEntity<LivroResponse> update(Optional<String> id, Optional<LivroRequest> request) {
        log.info("PUT atualizar livro: {} {}", id, request);

        Livro l = new Livro().withAutor(request.get().getAutor())
                .withDataDePublicacao(request.get().getDataDePublicacao()).withEditora(request.get().getEditora())
                .withStatus(request.get().getStatus()).withTitulo(request.get().getTitulo())
                .withId(request.get().getId());

        l = service.update(id.get(), l);

        return ResponseEntity.status(HttpStatus.OK).body(LivroResponse.buildFrom(l));
    }

    @Override
    public ResponseEntity<Void> deleteById(Optional<String> id) {
        log.info("DELETE remover livro: {}", id);

        service.deleteById(id.get());

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
