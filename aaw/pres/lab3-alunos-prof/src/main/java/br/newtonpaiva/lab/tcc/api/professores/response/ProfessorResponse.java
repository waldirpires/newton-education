package br.newtonpaiva.lab.tcc.api.professores.response;

import java.time.LocalDateTime;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class ProfessorResponse {

    private String id;
    
    private String matricula;
    
    private String nomeCompleto;
    
    private String formação;
    
    private Curso curso;
    
    private LocalDateTime created;
    
    private LocalDateTime modified;
    
    public static ProfessorResponse buildFrom(Professor professor) {
        return new ProfessorResponse()
                .withCreated(professor.getCreated())
                .withCurso(professor.getCurso())
                .withFormação(professor.getFormação())
                .withId(professor.getId())
                .withModified(professor.getModified())
                .withNomeCompleto(professor.getNomeCompleto());
        
    }
}
