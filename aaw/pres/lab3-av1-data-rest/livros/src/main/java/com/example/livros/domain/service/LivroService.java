package com.example.livros.domain.service;

import java.util.List;

import com.example.livros.domain.entity.Livro;

public interface LivroService {

    Livro getById(String id);
    
    List<Livro> getLivros();
    
    Livro create(Livro livro);
    
    Livro update(String id, Livro livro);
    
    void deleteById(String id);
}
