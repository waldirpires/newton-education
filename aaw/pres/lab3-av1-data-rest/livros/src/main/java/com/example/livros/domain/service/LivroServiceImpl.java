package com.example.livros.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.livros.common.NotFoundException;
import com.example.livros.domain.entity.Livro;
import com.example.livros.domain.repo.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroRepository repo;
    
    @Override
    public Livro getById(String id) {
        Optional<Livro> resultado = repo.findById(id);
        
        if (resultado.isEmpty()) {
            throw new NotFoundException(
                    String.format("%s com ID [%s] não encontrado.", "Curso", id));
        }
        
        return resultado.get();
    }

    @Override
    public List<Livro> getLivros() {
        return repo.findAll();
    }

    @Override
    public Livro create(Livro livro) {

        livro.setId(UUID.randomUUID().toString());
        
        repo.save(livro);

        return livro;
    }

    @Override
    public Livro update(String id, Livro livro) {

        Livro atual = getById(id);
        
        atual.setAutor(livro.getAutor());
        atual.setDataDePublicacao(livro.getDataDePublicacao());
        atual.setEditora(livro.getEditora());
        atual.setStatus(livro.getStatus());
        atual.setTitulo(livro.getTitulo());
        
        repo.save(atual);
        
        return atual;
    }

    @Override
    public void deleteById(String id) {
        getById(id);

        repo.deleteById(id);        
    }

}
