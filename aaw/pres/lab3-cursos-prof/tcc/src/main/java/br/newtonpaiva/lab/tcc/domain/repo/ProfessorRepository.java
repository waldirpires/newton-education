package br.newtonpaiva.lab.tcc.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.entity.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String>{

    public List<Professor> findByCurso(Curso curso);

}
