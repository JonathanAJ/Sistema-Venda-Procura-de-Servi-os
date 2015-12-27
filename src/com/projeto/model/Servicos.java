package com.projeto.model;

public class Servicos {

	private Long servPkId;
	private String servNome;
	private String servDescricao;
	private String servValor;
	private int servFkCateg1;
	private int servFkCateg2;
	private int servFkUsuario;
	private String servImagem;
	
	public Servicos(){
		
	}
	
	public Long getServPkId() {
		return servPkId;
	}

	public void setServPkId(Long servPkId) {
		this.servPkId = servPkId;
	}

	public String getServNome() {
		return servNome;
	}

	public void setServNome(String servNome) {
		this.servNome = servNome;
	}

	public String getServDescricao() {
		return servDescricao;
	}

	public void setServDescricao(String servDescricao) {
		this.servDescricao = servDescricao;
	}

	public String getServValor() {
		return servValor;
	}

	public void setServValor(String servValor) {
		this.servValor = servValor;
	}

	public int getServFkCateg1() {
		return servFkCateg1;
	}

	public void setServFkCateg1(int servFkCateg1) {
		this.servFkCateg1 = servFkCateg1;
	}

	public int getServFkCateg2() {
		return servFkCateg2;
	}

	public void setServFkCateg2(int servFkCateg2) {
		this.servFkCateg2 = servFkCateg2;
	}

	public int getServFkUsuario() {
		return servFkUsuario;
	}

	public void setServFkUsuario(int servFkUsuario) {
		this.servFkUsuario = servFkUsuario;
	}

	public String getServImagem() {
		return servImagem;
	}

	public void setServImagem(String servImagem) {
		this.servImagem = servImagem;
	}

}
