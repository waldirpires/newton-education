package br.newtonpaiva.ead.aaw.lab.domain.automoveis.service;

import java.util.List;

import br.newtonpaiva.ead.aaw.lab.api.automoveis.request.AutomovelRequest;
import br.newtonpaiva.ead.aaw.lab.domain.automoveis.entity.Automovel;

public interface AutomovelService {

	Automovel create(AutomovelRequest request);
	
	Automovel update(String id, AutomovelRequest request);
	
	Automovel getById(String id);
	
	void deleteById(String id);
	
	List<Automovel> getAllByMarca(String marca);
	
	List<Automovel> getAllByModelo(String modelo);
	
	List<Automovel> getAll();
	
}
