package br.newtonpaiva.ead.aaw.lab.domain.automoveis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.newtonpaiva.ead.aaw.lab.api.automoveis.request.AutomovelRequest;
import br.newtonpaiva.ead.aaw.lab.common.exception.NotFoundException;
import br.newtonpaiva.ead.aaw.lab.domain.automoveis.entity.Automovel;
import br.newtonpaiva.ead.aaw.lab.domain.automoveis.repo.AutomovelRepo;
import br.newtonpaiva.ead.aaw.lab.domain.automoveis.service.AutomovelService;

@Component
public class AutomovelServiceImpl implements AutomovelService {

	@Autowired
	private AutomovelRepo repo;
	
	@Override
	public void deleteById(String id) {
		
		getById(id);
		
		repo.deleteById(id);
	}

	@Override
	public Automovel create(AutomovelRequest request) {
		
		Automovel a = new Automovel(request);
		
		LocalDateTime now = LocalDateTime.now();
		a.setCreated(now);
		a.setModified(now);
		a.setId(UUID.randomUUID().toString());
		
		repo.save(a);
		
		return a;
	}

	@Override
	public Automovel update(String id, AutomovelRequest request) {

		var a = getById(id);
		
		a.setAnoDeFabricacao(request.getAnoDeFabricacao());
		a.setAnoDeModelo(request.getAnoDeModelo());
		a.setKm(request.getKm());
		a.setMarca(request.getMarca());
		a.setModelo(request.getModelo());
		
		a.setModified(LocalDateTime.now());
		
		repo.save(a);
		
		return a;
	}

	@Override
	public Automovel getById(String id) {
		
		Optional<Automovel> a = repo.findById(id);
		
		if (a.isEmpty()) {
			throw new NotFoundException(String.format("Automovel com ID [%s] não encontrado.", id));
		}
		
		return a.get();
	}

	@Override
	public List<Automovel> getAllByMarca(String marca) {
		return repo.findByMarca(marca);
	}

	@Override
	public List<Automovel> getAllByModelo(String modelo) {
		return repo.findByModelo(modelo);
	}

	@Override
	public List<Automovel> getAll() {
		return repo.findAll();
	}

}
