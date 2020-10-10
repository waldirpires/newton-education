package br.newtonpaiva.lab.tcc.api.cursos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.newtonpaiva.lab.tcc.common.enums.RegimeDeCurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With
public class CursoRequest {

	private String id;
	
	@NotBlank
	private String area;
	
	@NotBlank
	private String nome;

	@NotNull
	private RegimeDeCurso regime;
	
	@NotNull
	private Integer numSemestre;
	
}
