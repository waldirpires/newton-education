package br.newtonpaiva.lab.tcc.domain.service;

import java.util.List;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.entity.Professor;

public interface ProfessorService {

    Professor getById(String id);
    
    List<Professor> getProfessores();
    
    List<Professor> getAllByCurso(Curso curso);
    
    Professor create(Professor Professor);
    
    Professor update(String id, Professor Professor);
    
    void deleteById(String id);
}
