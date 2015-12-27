package com.projeto.model;

public class Categoria {
	
	private Long categPkId;
	private String categNome;
	
	public Categoria(){
		
	}
		
	public void setCategNome(String categNome){
		this.categNome = categNome;
	}
	
	public String getCategNome(){
		return this.categNome;
	}

	public void setCategPkId(Long categPkId) {
		this.categPkId = categPkId;
	}
	
	public Long getCategPkId() {
		return categPkId;
	}

	@Override
    public String toString() {
        return categNome;
    }
	
}
