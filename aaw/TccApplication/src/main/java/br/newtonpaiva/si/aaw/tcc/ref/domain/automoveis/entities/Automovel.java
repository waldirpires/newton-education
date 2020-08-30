package br.newtonpaiva.si.aaw.tcc.ref.domain.automoveis.entities;

import java.time.LocalDateTime;

import br.newtonpaiva.si.aaw.tcc.ref.api.automoveis.request.AutomovelRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Automovel {

	public Automovel(AutomovelRequest request) {
		this.id = request.getId();
		this.marca = request.getMarca();
		this.modelo = request.getModelo();
		this.anoDeFabricacao = request.getAnoDeFabricacao();
		this.anoDeModelo = request.getAnoDeModelo();
		this.km = request.getKm();
	}

	private String id;

	private String marca;

	private String modelo;

	private String anoDeFabricacao;

	private String anoDeModelo;

	private int km;

	private LocalDateTime created;

	private LocalDateTime modified;
}
