package com.projeto.model;

public class Estado {
	
	private Long estadoPkId;
	private String estadoNome;
	private String estadoSigla;
	
	public Estado(){
		
	}

	public Long getEstadoPkId() {
		return estadoPkId;
	}

	public void setEstadoPkId(Long estadoPkId) {
		this.estadoPkId = estadoPkId;
	}

	public String getEstadoNome() {
		return estadoNome;
	}

	public void setEstadoNome(String estadoNome) {
		this.estadoNome = estadoNome;
	}

	public String getEstadoSigla() {
		return estadoSigla;
	}

	public void setEstadoSigla(String estadoSigla) {
		this.estadoSigla = estadoSigla;
	}
	
}
