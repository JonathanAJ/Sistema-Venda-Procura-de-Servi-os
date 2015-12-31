package com.projeto.model;

public class Usuario {
	
	private String login;
	private String senha;
	private boolean userStatus;
	
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
	
	
	
	
}
