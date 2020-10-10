package br.newtonpaiva.lab.tcc.api.professores.request;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With
public class ProfessorRequest {

    private String matricula;

    private String nomeCompleto;
    
    private String formação;
    
    private String cursoId;
}
