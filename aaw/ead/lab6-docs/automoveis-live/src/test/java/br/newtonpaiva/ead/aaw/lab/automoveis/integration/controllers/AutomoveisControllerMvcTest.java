package br.newtonpaiva.ead.aaw.lab.automoveis.integration.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.newtonpaiva.ead.aaw.lab.automoveis.application.controllers.AutomoveisController;
import br.newtonpaiva.ead.aaw.lab.automoveis.common.exceptions.NotFoundException;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.entities.Automovel;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.service.AutomovelService;

@WebMvcTest(AutomoveisController.class)
class AutomoveisControllerMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AutomovelService service;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_getById_WithValidParams_shouldReturnResource() throws Exception {
		// given
		var id = UUID.randomUUID().toString();
		var auto = new Automovel().withId(id);

		// mock definitions
		Mockito.when(service.getById(id)).thenReturn(auto);

		// test
		this.mockMvc.perform(
				get(String.format("/v1/automoveis/%s", id)))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	void test_getById_WithInValidParams_shouldReturnNotFound() throws Exception {
		// given
		var id = UUID.randomUUID().toString();

		// mock definitions
		Mockito.when(service.getById(id)).thenThrow(new NotFoundException("Not Found"));

		// test
		this.mockMvc.perform(
				get(String.format("/v1/automoveis/%s", id)))
		.andDo(print())
		.andExpect(status().isNotFound());
	}

}
