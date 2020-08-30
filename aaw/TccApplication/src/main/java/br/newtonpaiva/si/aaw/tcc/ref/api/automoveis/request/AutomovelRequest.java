package br.newtonpaiva.si.aaw.tcc.ref.api.automoveis.request;

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
	
	private String anoDeFabricacao;
	
	private String anoDeModelo;
	
	private int km;

}
