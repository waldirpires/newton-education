package br.newtonpaiva.si.aaw.tcc.ref.api.automoveis.response;

import br.newtonpaiva.si.aaw.tcc.ref.domain.automoveis.entities.Automovel;
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
	}
	
	private String id;
	
	private String marca;
	
	private String modelo;
	
	private String anoDeFabricacao;
	
	private String anoDeModelo;
	
	private int km;

}
