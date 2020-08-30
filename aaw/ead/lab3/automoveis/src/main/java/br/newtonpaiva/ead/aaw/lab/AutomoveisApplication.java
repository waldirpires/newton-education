package br.newtonpaiva.ead.aaw.lab;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.newtonpaiva.ead.aaw.lab.domain.automoveis.entity.Automovel;
import br.newtonpaiva.ead.aaw.lab.domain.automoveis.repo.AutomovelRepo;

@SpringBootApplication
public class AutomoveisApplication  implements CommandLineRunner {

	@Autowired
	private AutomovelRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(AutomoveisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// limpar base
		repo.deleteAll();
		
		// salvar alguns automoveis
		repo.save(
				new Automovel()
				.withId(UUID.randomUUID().toString())
				.withMarca("Renault")
				.withModelo("Logan")
				.withAnoDeFabricacao(2010)
				.withAnoDeModelo(2011)
				.withKm(140000)
				);

		// salvar alguns automoveis
		repo.save(
				new Automovel()
				.withId(UUID.randomUUID().toString())
				.withMarca("Renault")
				.withModelo("Duster")
				.withAnoDeFabricacao(2020)
				.withAnoDeModelo(2020)
				.withKm(30000)
				);
		
		// listando os automoveis
		for (Automovel a: repo.findAll()) {
			System.out.println(a);
		}
		
		// listando todos da mesma marca
		for (Automovel a: repo.findByMarca("Renault")) {
			System.out.println(a);
		}
		
		// listando todos da mesma marca
		for (Automovel a: repo.findByModelo("Logan")) {
			System.out.println(a);
		}

	}

}
