package com.projeto.model;

public class Cidade {
	  
	private Long cidPkId;
	private String cidNome;
	private int cidFkEstado;
	
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

	public int getCidFkEstado() {
		return cidFkEstado;
	}

	public void setCidFkEstado(int cidFkEstado) {
		this.cidFkEstado = cidFkEstado;
	}
}
