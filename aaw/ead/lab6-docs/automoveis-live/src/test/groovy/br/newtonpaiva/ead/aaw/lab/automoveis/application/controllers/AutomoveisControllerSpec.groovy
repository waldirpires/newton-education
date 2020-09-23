package br.newtonpaiva.ead.aaw.lab.automoveis.application.controllers;

import static org.junit.jupiter.api.Assertions.fail

import org.junit.Before
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.AutomovelResponse
import br.newtonpaiva.ead.aaw.lab.automoveis.common.exceptions.NotFoundException
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.entities.Automovel
import br.newtonpaiva.ead.aaw.lab.automoveis.domain.service.AutomovelService
import spock.lang.Specification

class AutomoveisControllerSpec extends Specification{

	
//	@Test
//	void test() {
//		given:
//		def a = 1
//		when:
//		def b = 2
//		then:
//		fail("Not yet implemented")
//	}

	@Test
	def "getById - with Valid Params - Should Return The Resource" () {
		given:
		def service = Mock(AutomovelService.class)

    	def unit = new AutomoveisController(service)
		def uuid = UUID.randomUUID().toString();
		def auto = new Automovel().withId(uuid);
		
		1 * service.getById(uuid) >> auto
		
		when:
		def result = unit.getById(Optional.of(uuid))
		
		then:
		result.status == HttpStatus.OK
		result.body == new AutomovelResponse(auto)
	}

	@Test
	def "getById - with inexisting resource - Should Return not found" () {
		given:
		def service = Mock(AutomovelService.class)

		def unit = new AutomoveisController(service)
		def uuid = UUID.randomUUID().toString();

		service.getById(_) >> { 
			throw new NotFoundException("Not Found")
		}
				
		when:
		unit.getById(Optional.of(uuid))
		
		then:
		thrown(NotFoundException)
	}

}
