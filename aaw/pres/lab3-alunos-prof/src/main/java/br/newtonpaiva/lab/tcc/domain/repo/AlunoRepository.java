package br.newtonpaiva.lab.tcc.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.newtonpaiva.lab.tcc.domain.entity.Aluno;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String>{

    public List<Aluno> findByCurso(Curso curso);
    
}
