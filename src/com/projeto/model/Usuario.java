package com.projeto.model;

import java.util.Date;

public class Usuario {
	
	private int userPkId;
	private String login;
	private String senha;
	private boolean userStatus;
    private Date dataDesativacao;
	
	public int getUserPkId() {
		return userPkId;
	}

	public void setUserPkId(int userPkId) {
		this.userPkId = userPkId;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String getSenha(){
		return this.senha;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}
	
	
	
	
}
