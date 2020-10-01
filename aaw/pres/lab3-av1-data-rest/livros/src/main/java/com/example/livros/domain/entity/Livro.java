package com.example.livros.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class Livro {
    
    @Id
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private LocalDateTime dataDePublicacao;
    private int status;
}
