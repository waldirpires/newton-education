package br.newtonpaiva.lab.tcc.domain.entity;

import java.time.LocalDateTime;

import br.newtonpaiva.lab.tcc.common.enums.RegimeDeCurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@Data
@With
@NoArgsConstructor
public class Curso {

	private String id;
	
	private String area;
	
	private String nome;
	
	private RegimeDeCurso regime;
	
	private int numSemestre;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
}
