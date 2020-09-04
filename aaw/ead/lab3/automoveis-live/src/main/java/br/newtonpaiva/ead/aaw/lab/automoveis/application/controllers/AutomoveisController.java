package br.newtonpaiva.ead.aaw.lab.automoveis.application.controllers;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.ead.aaw.lab.automoveis.api.request.AutomovelRequest;
import br.newtonpaiva.ead.aaw.lab.automoveis.api.resource.AutomoveisResource;
import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.AutomovelResponse;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.service.AutomovelService;

@RestController
@Validated
public class AutomoveisController implements AutomoveisResource{

	@Autowired
	private AutomovelService service;
	
	@Override
	public ResponseEntity<AutomovelResponse> getById(Optional<String> id) {
		
		var automovel = service.getById(id.get());
		
		return status(OK).body(new AutomovelResponse(automovel));
	}

	@Override
	public ResponseEntity<AutomovelResponse> create(Optional<AutomovelRequest> request) {
		
		if (request.isEmpty()) {
			return status(BAD_REQUEST).body(null);
		}
		
		var auto = service.create(request.get());
		
		return status(CREATED).body(new AutomovelResponse(auto));
	}

	@Override
	public ResponseEntity<AutomovelResponse> update(Optional<UUID> id, Optional<AutomovelRequest> request) {
		
		if (request.isEmpty()) {
			return status(BAD_REQUEST).body(null);
		}

		var auto = service.update(id.get().toString(), request.get());
		
		return status(OK).body(new AutomovelResponse(auto));
	}

	@Override
	public ResponseEntity<UUID> deleteById(Optional<String> id) {


		service.deleteById(id.get());
		
		return new ResponseEntity<UUID>(NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<AutomovelResponse>> getAll() {

		var lista = new ArrayList<AutomovelResponse>();
				

		var automoveis = service.getAll();
		
		automoveis.forEach(auto -> {
			lista.add(new AutomovelResponse(auto));
		});
				
		
		return status(OK).body(lista);
	}

}
