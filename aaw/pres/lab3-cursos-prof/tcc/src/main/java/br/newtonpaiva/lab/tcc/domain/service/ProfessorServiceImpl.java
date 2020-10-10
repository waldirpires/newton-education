package br.newtonpaiva.lab.tcc.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.newtonpaiva.lab.tcc.common.exception.NotFoundException;
import br.newtonpaiva.lab.tcc.domain.entity.Professor;
import br.newtonpaiva.lab.tcc.domain.entity.Curso;
import br.newtonpaiva.lab.tcc.domain.repo.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    @Autowired
    private ProfessorRepository repo;
    
    @Override
    public Professor getById(String id) {
        Optional<Professor> resultado = repo.findById(id);
        
        if (resultado.isEmpty()) {
            throw new NotFoundException(
                    String.format("%s com ID [%s] não encontrado.", "Professor", id));
        }
        
        return resultado.get();
    }

    @Override
    public List<Professor> getProfessores() {
        return repo.findAll();
    }

    @Override
    public List<Professor> getAllByCurso(Curso curso) {
        return repo.findByCurso(curso);
    }

    @Override
    public Professor create(Professor Professor) {
        Professor.setId(UUID.randomUUID().toString());
        
        LocalDateTime now = LocalDateTime.now();
        Professor.setCreated(now);
        Professor.setModified(now);
        
        repo.save(Professor);
        
        return Professor;
    }

    @Override
    public Professor update(String id, Professor professor) {
        Professor atual = getById(id);
        
        atual.setCurso(professor.getCurso());
        atual.setMatricula(professor.getMatricula());
        atual.setNomeCompleto(professor.getNomeCompleto());
        atual.setFormação(professor.getFormação());
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
