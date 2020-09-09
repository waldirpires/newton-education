package br.newtonpaiva.ead.aaw.lab.automoveis.domain.service;

import static java.lang.String.format;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.newtonpaiva.ead.aaw.lab.automoveis.common.exceptions.NotFoundException;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.entities.Automovel;
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.repo.AutomovelRepo;

@ExtendWith(MockitoExtension.class)
class AutomovelServiceImplTest {

	private AutomovelService unit;
	
	@Mock
	private AutomovelRepo repo;
	
	@BeforeEach
	void setUp() throws Exception {
		unit = new AutomovelServiceImpl(repo);
	}

	@Test
	void getById_WithValidId_ShouldReturnResource() {
		// given
		var id = UUID.randomUUID().toString();
		var auto = new Automovel();
		
		// mock definitions
		
		when(repo.findById(id)).thenReturn(of(auto));
		
		// test
		var result = unit.getById(id);
		
		// assert
		assertEquals(auto, result);
		
		// verify
		verify(repo).findById(id);
	}

	@Test
	void getById_WithNonExistentId_ShouldReturnNotFoundException() {
		// given
		var id = UUID.randomUUID().toString();
		var expectedMsg = format("Automovel com Id %s não encontrado", id);
		
		// mock definitions
		
		when(repo.findById(id)).thenReturn(empty());
		
		// test
		try {
			unit.getById(id);
			fail("Expected a NotFoundException");
		} catch (NotFoundException e) {
			assertEquals(expectedMsg, e.getMessage());
		}
		
		// verify
		verify(repo).findById(id);
	}

}
