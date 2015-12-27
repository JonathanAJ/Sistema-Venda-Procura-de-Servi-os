package com.projeto.model;

public class Cidade {
	  
	private Long cidPkId;
	private String cidNome;
	private int cidFkEstadoUf;
	private String cidCodigoMunicipio;
	
	public Cidade(){
		
	}
	
	public Long getCidPkId() {
		return cidPkId;
	}

	public void setCidPkId(Long cidPkId) {
		this.cidPkId = cidPkId;
	}

	public String getCidNome() {
		return cidNome;
	}

	public void setCidNome(String cidNome) {
		this.cidNome = cidNome;
	}

	public int getCidFkEstadoUf() {
		return cidFkEstadoUf;
	}

	public void setCidFkEstadoUf(int cidFkEstadoUf) {
		this.cidFkEstadoUf = cidFkEstadoUf;
	}

	public String getCidCodigoMunicipio() {
		return cidCodigoMunicipio;
	}

	public void setCidCodigoMunicipio(String cidCodigoMunicipio) {
		this.cidCodigoMunicipio = cidCodigoMunicipio;
	}
}
