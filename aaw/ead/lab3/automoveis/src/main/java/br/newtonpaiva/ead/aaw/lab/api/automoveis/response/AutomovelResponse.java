package br.newtonpaiva.ead.aaw.lab.api.automoveis.response;

import java.time.LocalDateTime;

import br.newtonpaiva.ead.aaw.lab.domain.automoveis.entity.Automovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelResponse {
	
	public AutomovelResponse(Automovel auto) {
		this.id = auto.getId();
		this.marca = auto.getMarca();
		this.modelo = auto.getModelo();
		this.anoDeFabricacao = auto.getAnoDeFabricacao();
		this.anoDeModelo = auto.getAnoDeModelo();
		this.km = auto.getKm();
		this.created = auto.getCreated();
		this.modified = auto.getModified();
	}
	
	private String id;
	
	private String marca;
	
	private String modelo;
	
	private int anoDeFabricacao;
	
	private int anoDeModelo;
	
	private int km;
	
	private LocalDateTime created;

	private LocalDateTime modified;	

}
