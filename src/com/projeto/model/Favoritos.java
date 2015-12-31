package com.projeto.model;

public class Favoritos {
	
	private Long favoritoPkId;
	private int favoritoFkServ;
	private int favoritoFkUsuario;

	public Favoritos(){
		
	}
	
	public Long getFavoritoPkId() {
		return favoritoPkId;
	}

	public void setFavoritoPkId(Long favoritoPkId) {
		this.favoritoPkId = favoritoPkId;
	}

	public int getFavoritoFkServ() {
		return favoritoFkServ;
	}

	public void setFavorFkServ(int favoritoFkServ) {
		this.favoritoFkServ = favoritoFkServ;
	}

	public int getFavoritoFkUsuario() {
		return favoritoFkUsuario;
	}

	public void setFavoritoFkUsuario(int favoritoFkUsuario) {
		this.favoritoFkUsuario = favoritoFkUsuario;
	}
	
}
