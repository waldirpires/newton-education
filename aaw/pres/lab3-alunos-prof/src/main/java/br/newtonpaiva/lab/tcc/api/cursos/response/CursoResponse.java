package br.newtonpaiva.lab.tcc.api.cursos.response;

import java.time.LocalDateTime;

import br.newtonpaiva.lab.tcc.common.enums.RegimeDeCurso;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With
public class CursoResponse {

	private String id;
	
	private String area;
	
	private String nome;
	
	private RegimeDeCurso regime;
	
	private int numSemestre;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	public CursoResponse(Curso curso) {
		this.id = curso.getId();
		this.area = curso.getArea();
		this.nome = curso.getNome();
		this.regime = curso.getRegime();
		this.numSemestre = curso.getNumSemestre();
		this.created = curso.getCreated();
		this.modified = curso.getModified();
	}
}
