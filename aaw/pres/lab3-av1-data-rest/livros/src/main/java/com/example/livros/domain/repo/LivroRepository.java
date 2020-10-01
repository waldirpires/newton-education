package com.example.livros.domain.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.livros.domain.entity.Livro;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String>{

}
