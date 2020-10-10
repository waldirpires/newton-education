package br.newtonpaiva.lab.tcc.domain.entity;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@Data
@With
@NoArgsConstructor
@EntityScan
public class Professor {

    @Id
    private String id;
    
    private String matricula;
    
    private String nomeCompleto;
    
    private String formação;
    
    private Curso curso;
    
    private LocalDateTime created;
    
    private LocalDateTime modified;
}
