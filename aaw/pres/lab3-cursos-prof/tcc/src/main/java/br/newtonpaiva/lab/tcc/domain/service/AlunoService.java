package br.newtonpaiva.lab.tcc.domain.service;

import java.util.List;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.entity.Aluno;

public interface AlunoService {

    Aluno getById(String id);
    
    List<Aluno> getAlunos();
    
    List<Aluno> getAllByCurso(Curso curso);
    
    Aluno create(Aluno Aluno);
    
    Aluno update(String id, Aluno Aluno);
    
    void deleteById(String id);
}
