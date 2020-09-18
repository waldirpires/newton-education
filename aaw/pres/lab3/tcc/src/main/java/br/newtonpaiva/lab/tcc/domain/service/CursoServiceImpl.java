package br.newtonpaiva.lab.tcc.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.newtonpaiva.lab.tcc.common.exception.NotFoundException;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.repo.CursoRespository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRespository repo;
	
	@Override
	public Curso getById(String id) {
		
		Optional<Curso> resultado = repo.findById(id);
		
		if (resultado.isEmpty()) {
			throw new NotFoundException(
					String.format("%s com ID [%s] não encontrado.", "Curso", id));
		}
		
		return resultado.get();
	}

	@Override
	public List<Curso> getCursos() {
		return repo.findAll();
	}

	@Override
	public Curso create(Curso curso) {
		
		curso.setId(UUID.randomUUID().toString());
		curso.setCreated(LocalDateTime.now());		
		curso.setModified(LocalDateTime.now());		

		repo.save(curso);
		
		return curso;
	}

	@Override
	public Curso update(String id, Curso curso) {

		Curso atual = getById(id);
		
		atual.setArea(curso.getArea());
		atual.setNome(curso.getNome());
		atual.setNumSemestre(curso.getNumSemestre());
		atual.setRegime(curso.getRegime());
		
		atual.setModified(LocalDateTime.now());
		
		repo.save(atual);
		
		return atual;
	}

	@Override
	public void deleteById(String id) {

		getById(id);

		repo.deleteById(id);
	}	

}
