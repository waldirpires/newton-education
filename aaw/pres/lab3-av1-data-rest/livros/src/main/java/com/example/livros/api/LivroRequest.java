package com.example.livros.api;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class LivroRequest {
    
    private String id;
    
    @NotEmpty
    private String titulo;
    
    @NotEmpty
    private String autor;
    
    @NotEmpty
    private String editora;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    private LocalDateTime dataDePublicacao;
    
    @NotNull
    private Integer status;
}