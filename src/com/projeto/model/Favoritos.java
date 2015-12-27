package com.projeto.model;

public class Favoritos {
	
	private Long favorPkId;
	private int favorFkServ;
	private int favorFkUsuario;

	public Favoritos(){
		
	}
	
	public Long getFavorPkId() {
		return favorPkId;
	}

	public void setFavorPkId(Long favorPkId) {
		this.favorPkId = favorPkId;
	}

	public int getFavorFkServ() {
		return favorFkServ;
	}

	public void setFavorFkServ(int favorFkServ) {
		this.favorFkServ = favorFkServ;
	}

	public int getFavorFkUsuario() {
		return favorFkUsuario;
	}

	public void setFavorFkUsuario(int favorFkUsuario) {
		this.favorFkUsuario = favorFkUsuario;
	}
	
}
