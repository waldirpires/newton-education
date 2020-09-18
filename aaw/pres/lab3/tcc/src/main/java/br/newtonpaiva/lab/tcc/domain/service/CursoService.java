package br.newtonpaiva.lab.tcc.domain.service;

import java.util.List;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;

public interface CursoService {

	Curso getById(String id);
	
	List<Curso> getCursos();
	
	Curso create(Curso curso);
	
	Curso update(String id, Curso curso);
	
	void deleteById(String id);
}
