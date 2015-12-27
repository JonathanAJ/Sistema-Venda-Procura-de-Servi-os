package com.projeto.model;

public class TipoContato {
	
	private Long tipocontPkId;
	private String tipocontTipo;
		
	public TipoContato(){
		
	}
	
	public Long getTipocontPkId() {
		return tipocontPkId;
	}

	public void setTipocontPkId(Long tipocontPkId) {
		this.tipocontPkId = tipocontPkId;
	}

	public String getTipocontTipo() {
		return tipocontTipo;
	}

	public void setTipocontTipo(String tipocontTipo) {
		this.tipocontTipo = tipocontTipo;
	}


}
