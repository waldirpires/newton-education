package br.newtonpaiva.ead.aaw.lab.automoveis.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.newtonpaiva.ead.aaw.lab.automoveis.domain.entities.Automovel;

public interface AutomovelRepo extends MongoRepository<Automovel, String> {

	public List<Automovel> findByMarca(String marca);

	public List<Automovel> findByModelo(String modelo);

}
