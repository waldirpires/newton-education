package br.newtonpaiva.si.aaw.tcc.ref.application.automoveis.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.si.aaw.tcc.ref.api.automoveis.request.AutomovelRequest;
import br.newtonpaiva.si.aaw.tcc.ref.api.automoveis.resource.AutomoveisResource;
import br.newtonpaiva.si.aaw.tcc.ref.api.automoveis.response.AutomovelResponse;
import br.newtonpaiva.si.aaw.tcc.ref.domain.automoveis.entities.Automovel;

@RestController
public class AutomoveisController implements AutomoveisResource{

	private Map<UUID, Automovel> automoveis = new HashMap<UUID, Automovel>();
	
	@Override
	public ResponseEntity<AutomovelResponse> getById(Optional<String> id) {
		
		var automovel = automoveis.get(UUID.fromString(id.get()));
		
		if (automovel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(new AutomovelResponse(automovel));
	}

	@Override
	public ResponseEntity<AutomovelResponse> create(Optional<AutomovelRequest> request) {
		
		if (request.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		if (request.get().getId() == null || request.get().getId().trim().isEmpty()) {
			request.get().setId(UUID.randomUUID().toString());
		}
		
		Automovel value = new Automovel(request.get());
		automoveis.put(UUID.fromString(request.get().getId()), value);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new AutomovelResponse(value));
	}

	@Override
	public ResponseEntity<AutomovelResponse> update(Optional<UUID> id, Optional<AutomovelRequest> request) {
		if (request.isEmpty() || request.get().getId() == null || request.get().getId().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		var automovel = automoveis.get(UUID.fromString(request.get().getId()));
		
		if (automovel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}		
		
		Automovel value = new Automovel(request.get());
		automoveis.put(UUID.fromString(request.get().getId()), value);
		
		return ResponseEntity.status(HttpStatus.OK).body(new AutomovelResponse(value));
	}

	@Override
	public ResponseEntity<UUID> deleteById(Optional<String> id) {

		UUID uuid = UUID.fromString(id.get());
		var automovel = automoveis.get(uuid);
		
		if (automovel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}		

		automoveis.remove(uuid);
		
		return new ResponseEntity<UUID>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<AutomovelResponse>> getAll() {

		var lista = new ArrayList<AutomovelResponse>();
				

		automoveis.keySet().forEach(key -> {
			lista.add(new AutomovelResponse(automoveis.get(key)));
		});
				
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

}
