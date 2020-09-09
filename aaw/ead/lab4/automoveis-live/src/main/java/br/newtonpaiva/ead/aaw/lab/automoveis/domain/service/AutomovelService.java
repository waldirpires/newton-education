package br.newtonpaiva.ead.aaw.lab.automoveis.domain.service;

import java.util.List;

import br.newtonpaiva.ead.aaw.lab.automoveis.api.request.AutomovelRequest;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.entities.Automovel;

public interface AutomovelService {

	Automovel create(AutomovelRequest request);
	
	Automovel update(String id, AutomovelRequest request);
	
	Automovel getById(String id);
	
	void deleteById(String id);
	
	List<Automovel> getAllByMarca(String marca);
	
	List<Automovel> getAllByModelo(String modelo);
	
	List<Automovel> getAll();
	
}
