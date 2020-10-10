package br.newtonpaiva.lab.tcc.api.alunos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With
public class AlunoRequest {

    private String matricula;
    
    private String anoSemestreDeEntrada;
    
    private String nomeCompleto;
    
    private String cursoId;
}
