package com.projeto.model;

public class EstadoUf {
	
	private Long esufPkId;
	private String esufNome;
	private String esufSigla;
	
	public EstadoUf(){
		
	}

	public Long getEsufPkId() {
		return esufPkId;
	}

	public void setEsufPkId(Long esufPkId) {
		this.esufPkId = esufPkId;
	}

	public String getEsufNome() {
		return esufNome;
	}

	public void setEsufNome(String esufNome) {
		this.esufNome = esufNome;
	}

	public String getEsufSigla() {
		return esufSigla;
	}

	public void setEsufSigla(String esufSigla) {
		this.esufSigla = esufSigla;
	}
	
}
