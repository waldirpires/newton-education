package br.newtonpaiva.ead.aaw.lab.automoveis.application.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.AutomovelResponse;
import br.newtonpaiva.ead.aaw.lab.automoveis.common.exceptions.NotFoundException;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.entities.Automovel;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.service.AutomovelService;

@ExtendWith(MockitoExtension.class)
class AutomoveisControllerTest {

	private AutomoveisController unit;
	
	@Mock
	private AutomovelService service;
	
	@BeforeEach
	void setUp() throws Exception {
		unit = new AutomoveisController(service);
	}

	@Test
	void getById_withExistingId_shouldReturnResource() {
		// given
		var id = UUID.randomUUID().toString();
		var auto = new Automovel();
		
		// mock definitions
		Mockito.when(service.getById(id)).thenReturn(auto);
		
		// test
		var result = unit.getById(Optional.of(id));
		
		// assert
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(new AutomovelResponse(auto), result.getBody());
		
		// verify
		Mockito.verify(service).getById(id);
	}

	@Test
	void getById_withNonExistingId_shouldReturnNotFound() {
		// given
		var id = UUID.randomUUID().toString();
		
		// mock definitions
		Mockito.when(service.getById(id)).thenThrow(new NotFoundException("Not Found"));
		
		// test
		try {
			unit.getById(Optional.of(id));
			fail("Expected NotFoundException");
		} catch (NotFoundException e) {
			assertEquals("Not Found", e.getMessage());
		}
		
		// verify
		Mockito.verify(service).getById(id);
	}

}
