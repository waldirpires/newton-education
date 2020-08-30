package br.newtonpaiva.ead.aaw.lab.domain.automoveis.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import br.newtonpaiva.ead.aaw.lab.api.automoveis.request.AutomovelRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class Automovel {

	public Automovel(AutomovelRequest request) {
		this.id = request.getId();
		this.marca = request.getMarca();
		this.modelo = request.getModelo();
		this.anoDeFabricacao = request.getAnoDeFabricacao();
		this.anoDeModelo = request.getAnoDeModelo();
		this.km = request.getKm();
	}

	@Id
	private String id;

	private String marca;

	private String modelo;

	private int anoDeFabricacao;

	private int anoDeModelo;

	private int km;

	private LocalDateTime created;

	private LocalDateTime modified;
}
