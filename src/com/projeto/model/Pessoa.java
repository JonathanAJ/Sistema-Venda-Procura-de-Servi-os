package com.projeto.model;

public class Pessoa {
	
	private Long pessoaPkId;
	private String pessoaNomeCompleto;
	private String pessoaSexo;
	private String pessoaCpf;
	private String pessoaCnpj;
	private String pessoaEmail;
	private String pessoaTelefone;
	private String pessoaCep;
	private String pessoaBairro;
	private int pessoaFkCidade;
	private int pessoaFkEstado;
	private int pessoaFkUsuario;
	
	public Pessoa(){
		
	}

	public Long getPessoaPkId() {
		return pessoaPkId;
	}

	public void setPessoaPkId(Long pessoaPkId) {
		this.pessoaPkId = pessoaPkId;
	}

	public String getPessoaNomeCompleto() {
		return pessoaNomeCompleto;
	}

	public void setPessoaNomeCompleto(String pessoaNomeCompleto) {
		this.pessoaNomeCompleto = pessoaNomeCompleto;
	}

	public String getPessoaSexo() {
		return pessoaSexo;
	}

	public void setPessoaSexo(String pessoaSexo) {
		this.pessoaSexo = pessoaSexo;
	}

	public String getPessoaCpf() {
		return pessoaCpf;
	}

	public void setPessoaCpf(String pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}
	
	public String getPessoaCnpj() {
		return pessoaCnpj;
	}

	public void setPessoaCnpj(String pessoaCnpj) {
		this.pessoaCnpj = pessoaCnpj;
	}

	public String getPessoaEmail() {
		return pessoaEmail;
	}

	public void setPessoaEmail(String pessoaEmail) {
		this.pessoaEmail = pessoaEmail;
	}

	public String getPessoaTelefone() {
		return pessoaTelefone;
	}

	public void setPessoaTelefone(String pessoaTelefone) {
		this.pessoaTelefone = pessoaTelefone;
	}

	public String getPessoaCep() {
		return pessoaCep;
	}

	public void setPessoaCep(String pessoaCep) {
		this.pessoaCep = pessoaCep;
	}

	public String getPessoaBairro() {
		return pessoaBairro;
	}

	public void setPessoaBairro(String pessoaBairro) {
		this.pessoaBairro = pessoaBairro;
	}

	public int getPessoaFkCidade() {
		return pessoaFkCidade;
	}

	public void setPessoaFkCidade(int pessoaFkCidade) {
		this.pessoaFkCidade = pessoaFkCidade;
	}

	public int getPessoaFkEstado() {
		return pessoaFkEstado;
	}

	public void setPessoaFkEstado(int pessoaFkEstado) {
		this.pessoaFkEstado = pessoaFkEstado;
	}

	public int getPessoaFkUsuario() {
		return pessoaFkUsuario;
	}

	public void setPessoaFkUsuario(int pessoaFkUsuario) {
		this.pessoaFkUsuario = pessoaFkUsuario;
	}
	

}
