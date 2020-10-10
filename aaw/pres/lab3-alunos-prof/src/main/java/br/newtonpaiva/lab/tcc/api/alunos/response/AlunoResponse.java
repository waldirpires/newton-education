package br.newtonpaiva.lab.tcc.api.alunos.response;

import java.time.LocalDateTime;

import br.newtonpaiva.lab.tcc.api.cursos.response.CursoResponse;
import br.newtonpaiva.lab.tcc.common.enums.RegimeDeCurso;
import br.newtonpaiva.lab.tcc.domain.entity.Aluno;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class AlunoResponse {

    private String id;
    
    private String matricula;
    
    private String anoSemestreDeEntrada;
    
    private String nomeCompleto;
    
    private Curso curso;
    
    private LocalDateTime created;
    
    private LocalDateTime modified;    
    
    public static AlunoResponse buildFrom(Aluno aluno) {
        return new AlunoResponse()
                .withId(aluno.getId())
                .withAnoSemestreDeEntrada(aluno.getAnoSemestreDeEntrada())
                .withCreated(aluno.getCreated())
                .withCurso(aluno.getCurso())
                .withMatricula(aluno.getMatricula())
                .withModified(aluno.getModified())
                .withNomeCompleto(aluno.getNomeCompleto());
        
    }
}
