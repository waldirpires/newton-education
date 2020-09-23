package br.newtonpaiva.ead.aaw.lab.automoveis.integration;

import static io.restassured.RestAssured.given
import static io.restassured.http.ContentType.JSON
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

import br.newtonpaiva.ead.aaw.lab.automoveis.AutomoveisLiveApplication
import br.newtonpaiva.ead.aaw.lab.automoveis.api.response.AutomovelResponse
import spock.lang.Specification

@SpringBootTest(
    classes = [AutomoveisLiveApplication.class],
    webEnvironment = RANDOM_PORT)
class AutomoveisIntegrationSpec extends Specification{

	@LocalServerPort
	int port

	def static CONTEXT_PATH = '/v1/automoveis'

	def createRequest() {
		given()
			.log()
			.all()
			.port(port)
			.accept(JSON)
			.contentType(JSON)
			.urlEncodingEnabled(false)
	}

	def "get automoveis" () {
        when:
        def response =
            createRequest()
                .when()
                .get(CONTEXT_PATH)
                .thenReturn()

        then:
        response.statusCode == HttpStatus.OK.value()
		def automoveis = response.body().as(AutomovelResponse[].class)
	}

	def "get automovel by ID - with no automovel - should return not found" () {
		when:
		def response =
			createRequest()
				.when()
				.get(CONTEXT_PATH.concat("/".concat(UUID.randomUUID().toString())))
				.thenReturn()

		then:
		response.statusCode == HttpStatus.NOT_FOUND.value()
	}

}