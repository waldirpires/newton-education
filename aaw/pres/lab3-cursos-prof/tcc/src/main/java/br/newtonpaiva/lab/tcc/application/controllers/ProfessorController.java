package br.newtonpaiva.lab.tcc.application.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.lab.tcc.api.professores.request.ProfessorRequest;
import br.newtonpaiva.lab.tcc.api.professores.resource.ProfessoresResource;
import br.newtonpaiva.lab.tcc.api.professores.response.ProfessorResponse;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.entity.Professor;
import br.newtonpaiva.lab.tcc.domain.service.CursoService;
import br.newtonpaiva.lab.tcc.domain.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class ProfessorController implements ProfessoresResource{

    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private CursoService cursoService;

    @Override
    public ResponseEntity<List<ProfessorResponse>> getAll() {
        log.info("GET alunos");
        
        List<Professor> lista = professorService.getProfessores();
        
        List<ProfessorResponse> response = new ArrayList<ProfessorResponse>();
        
        lista.forEach(aluno ->  {
            response.add(ProfessorResponse.buildFrom(aluno));
        });
        
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ProfessorResponse> getById(Optional<String> id) {
        log.info("GET professor by ID: {}", id);

        Professor professor = professorService.getById(id.get());
        
        return ResponseEntity.ok(ProfessorResponse.buildFrom(professor));
    }

    @Override
    public ResponseEntity<ProfessorResponse> create(@Valid Optional<ProfessorRequest> request) {
        log.info("POST criar professor: {}", request.get());

        Curso curso = cursoService.getById(request.get().getCursoId());

        Professor professor = new Professor()
                .withCurso(curso)
                .withMatricula(request.get().getMatricula())
                .withNomeCompleto(request.get().getNomeCompleto())
                .withFormação(request.get().getFormação());
        
        professor = professorService.create(professor);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfessorResponse.buildFrom(professor));
    }

    @Override
    public ResponseEntity<ProfessorResponse> update(Optional<String> id, Optional<ProfessorRequest> request) {
        log.info("PUT atualizar professor: {} {}", id, request);

        Curso curso = cursoService.getById(request.get().getCursoId());

        Professor professor = new Professor()
                .withCurso(curso)
                .withMatricula(request.get().getMatricula())
                .withNomeCompleto(request.get().getNomeCompleto())
                .withFormação(request.get().getFormação());

        professor = professorService.update(id.get(), professor);
        
        return ResponseEntity.status(HttpStatus.OK).body(ProfessorResponse.buildFrom(professor));
    }

    @Override
    public ResponseEntity<Void> deleteById(Optional<String> id) {
        log.info("DELETE remover professor: {}", id);
        
        professorService.deleteById(id.get());

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
