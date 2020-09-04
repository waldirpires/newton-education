package br.newtonpaiva.lab.tcc.application.cursos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.lab.tcc.api.cursos.request.CursoRequest;
import br.newtonpaiva.lab.tcc.api.cursos.resource.CursosResource;
import br.newtonpaiva.lab.tcc.api.cursos.response.CursoResponse;
import br.newtonpaiva.lab.tcc.common.exception.NotFoundException;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class CursoController implements CursosResource{

	private Map<String, Curso> cursos = new HashMap<String, Curso>();
	
	@Override
	public ResponseEntity<List<CursoResponse>> getAll() {
		log.info("GET cursos");
		
		// recupero a lista persistida
		List<Curso> lista = new ArrayList<Curso>(cursos.values());
		
		// preparando o corpo da minha respota REST/JSON
		List<CursoResponse> response = new ArrayList<CursoResponse>();
		
		// para cada curso que eu tenho, coverter de curso para curso-response
		lista.forEach(curso -> {
			response.add(new CursoResponse(curso));
		});
		
		// devolvendo a resposta
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<CursoResponse> getById(Optional<String> id) {
		log.info("GET curso by ID: {}", id);

		Curso curso = cursos.get(id.get());
		
		if (curso == null) {
			// retornar HTTP 404
			throw new NotFoundException(id.get());
		}
		
		return ResponseEntity.ok(new CursoResponse(curso));
	}

	@Override
	public ResponseEntity<CursoResponse> create(Optional<CursoRequest> request) {
		log.info("POST criar curso: {}", request);
		
		// criando um obj curso a partir da requisição JSON
		Curso curso = new Curso()
				.withArea(request.get().getArea())
				.withId(UUID.randomUUID().toString())
				.withNome(request.get().getNome())
				.withNumSemestre(request.get().getNumSemestre())
				.withRegime(request.get().getRegime());
		
		curso.setCreated(LocalDateTime.now());
		curso.setModified(LocalDateTime.now());
		
		// salvar em memória
		cursos.put(curso.getId(), curso);
		
		// devolver a resposta do curso criado
		return ResponseEntity.status(HttpStatus.CREATED).body(new CursoResponse(curso));
	}

	@Override
	public ResponseEntity<CursoResponse> update(
			Optional<String> id, 
			Optional<CursoRequest> request
			) {
		log.info("PUT atualizar curso: {} {}", id, request);

		// validar se o objeto já existe
		Curso curso = cursos.get(id.get());
		
		if (curso == null) {
			// retornar HTTP 404
			throw new NotFoundException(id.get());
		}
		
		curso = curso
				.withArea(request.get().getArea())
				.withNome(request.get().getNome())
				.withNumSemestre(request.get().getNumSemestre())
				.withRegime(request.get().getRegime());

		curso.setModified(LocalDateTime.now());

		// salvar em memória
		cursos.put(curso.getId(), curso);
		
		// devolver a resposta do curso criado
		return ResponseEntity.status(HttpStatus.OK).body(new CursoResponse(curso));
	}

	@Override
	public ResponseEntity<Void> deleteById(Optional<String> id) {
		log.info("DELETE remover curso: {}", id);

		// validar se o objeto já existe
		Curso curso = cursos.get(id.get());
		
		if (curso == null) {
			// retornar HTTP 404
			throw new NotFoundException(id.get());
		}

		cursos.remove(id.get());
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
