package com.example.livros.api;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.livros.domain.entity.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class LivroResponse {
    
    private String id;
    private String titulo;
    private String autor;
    private String editora;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataDePublicacao;
    
    private int status;
    
    public static LivroResponse buildFrom(Livro l) {
        LivroResponse response = new LivroResponse();
        
        response.setId(l.getId());
        response.setTitulo(l.getTitulo());
        response.setAutor(l.getAutor());
        response.setEditora(l.getEditora());
        response.setDataDePublicacao(l.getDataDePublicacao());
        response.setStatus(l.getStatus());
        
        return response;
    }
}

