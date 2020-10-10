package br.newtonpaiva.lab.tcc.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.newtonpaiva.lab.tcc.common.exception.NotFoundException;
import br.newtonpaiva.lab.tcc.domain.entity.Aluno;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.repo.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repo;
    
    @Override
    public Aluno getById(String id) {
        Optional<Aluno> resultado = repo.findById(id);
        
        if (resultado.isEmpty()) {
            throw new NotFoundException(
                    String.format("%s com ID [%s] não encontrado.", "Aluno", id));
        }
        
        return resultado.get();
    }

    @Override
    public List<Aluno> getAlunos() {
        return repo.findAll();
    }

    @Override
    public List<Aluno> getAllByCurso(Curso curso) {
        return repo.findByCurso(curso);
    }

    @Override
    public Aluno create(Aluno aluno) {
        aluno.setId(UUID.randomUUID().toString());
        
        LocalDateTime now = LocalDateTime.now();
        aluno.setCreated(now);
        aluno.setModified(now);
        
        repo.save(aluno);
        
        return aluno;
    }

    @Override
    public Aluno update(String id, Aluno aluno) {
        Aluno atual = getById(id);
        
        atual.setAnoSemestreDeEntrada(aluno.getAnoSemestreDeEntrada());
        atual.setCurso(aluno.getCurso());
        atual.setMatricula(aluno.getMatricula());
        atual.setNomeCompleto(aluno.getNomeCompleto());
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
