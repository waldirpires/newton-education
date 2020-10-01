package com.example.livros.domain.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.livros.domain.entity.Revista;

@RepositoryRestResource(collectionResourceRel = "revistas", path = "revistas")
public interface RevistaRepository extends PagingAndSortingRepository<Revista, String>{
    
    List<Revista> findByEditora(@Param("editora") String editora);

    List<Revista> findByStatus(@Param("status") int status);

    List<Revista> findByAutor(@Param("autor") String autor);

}
