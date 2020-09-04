package br.newtonpaiva.ead.aaw.lab.automoveis.api.request;


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

	private Integer anoDeFabricacao;

	private Integer anoDeModelo;

	private Integer km;

}
