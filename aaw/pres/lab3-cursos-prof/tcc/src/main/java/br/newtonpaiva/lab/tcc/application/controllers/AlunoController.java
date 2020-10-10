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

import br.newtonpaiva.lab.tcc.api.alunos.request.AlunoRequest;
import br.newtonpaiva.lab.tcc.api.alunos.resource.AlunosResource;
import br.newtonpaiva.lab.tcc.api.alunos.response.AlunoResponse;
import br.newtonpaiva.lab.tcc.domain.entity.Aluno;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.service.AlunoService;
import br.newtonpaiva.lab.tcc.domain.service.CursoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class AlunoController implements AlunosResource{

    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private CursoService cursoService;

    @Override
    public ResponseEntity<List<AlunoResponse>> getAll() {
        log.info("GET alunos");
        
        List<Aluno> lista = alunoService.getAlunos();
        
        List<AlunoResponse> response = new ArrayList<AlunoResponse>();
        
        lista.forEach(aluno ->  {
            response.add(AlunoResponse.buildFrom(aluno));
        });
        
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AlunoResponse> getById(Optional<String> id) {
        log.info("GET aluno by ID: {}", id);

        Aluno aluno = alunoService.getById(id.get());
        
        return ResponseEntity.ok(AlunoResponse.buildFrom(aluno));
    }

    @Override
    public ResponseEntity<AlunoResponse> create(@Valid Optional<AlunoRequest> request) {
        log.info("POST criar aluno: {}", request.get());

        Curso curso = cursoService.getById(request.get().getCursoId());
        
        Aluno aluno = new Aluno()
                .withAnoSemestreDeEntrada(request.get().getAnoSemestreDeEntrada())
                .withCurso(curso)
                .withMatricula(request.get().getMatricula())
                .withNomeCompleto(request.get().getNomeCompleto());
        
        aluno = alunoService.create(aluno);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(AlunoResponse.buildFrom(aluno));
    }

    @Override
    public ResponseEntity<AlunoResponse> update(Optional<String> id, Optional<AlunoRequest> request) {
        log.info("PUT atualizar curso: {} {}", id, request);

        Curso curso = cursoService.getById(request.get().getCursoId());

        Aluno aluno = new Aluno()
                .withAnoSemestreDeEntrada(request.get().getAnoSemestreDeEntrada())
                .withCurso(curso)
                .withMatricula(request.get().getMatricula())
                .withNomeCompleto(request.get().getNomeCompleto());

        aluno = alunoService.update(id.get(), aluno);
        
        return ResponseEntity.status(HttpStatus.OK).body(AlunoResponse.buildFrom(aluno));
    }

    @Override
    public ResponseEntity<Void> deleteById(Optional<String> id) {
        log.info("DELETE remover aluno: {}", id);
        
        alunoService.deleteById(id.get());

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
