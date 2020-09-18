package br.newtonpaiva.lab.tcc.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.newtonpaiva.lab.tcc.domain.entity.Curso;

@Repository
public interface CursoRespository extends MongoRepository<Curso, String>{

	public List<Curso> findByArea(String area);
	
}
