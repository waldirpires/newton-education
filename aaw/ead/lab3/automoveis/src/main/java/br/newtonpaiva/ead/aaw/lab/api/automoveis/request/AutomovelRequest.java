package br.newtonpaiva.ead.aaw.lab.api.automoveis.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelRequest {
	
	private String id;
	
	private String marca;
	
	private String modelo;
	
	private int anoDeFabricacao;
	
	private int anoDeModelo;
	
	private int km;

}
