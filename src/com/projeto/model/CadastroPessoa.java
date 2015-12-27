package com.projeto.model;

public class CadastroPessoa {
	
	private Long pessoaPkId;
	private String pessoaNomeCompleto;
	private String pessoaSexo;
	private String pessoaCpfCnpj;
	private String pessoaEmail;
	private String pessoaTelefone;
	private String pessoaCep;
	private String pessoaEndereco;
	private String pessoaComplemento;
	private String pessoaNumero;
	private int pessoaFkTipoContato;
	private int pessoaFkCidade;
	private int pessoaFkEstado;
	private int pessoaFkUsuario;
	
	public CadastroPessoa(){
		
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

	public String getPessoaCpfCnpj() {
		return pessoaCpfCnpj;
	}

	public void setPessoaCpfCnpj(String pessoaCpfCnpj) {
		this.pessoaCpfCnpj = pessoaCpfCnpj;
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

	public String getPessoaEndereco() {
		return pessoaEndereco;
	}

	public void setPessoaEndereco(String pessoaEndereco) {
		this.pessoaEndereco = pessoaEndereco;
	}

	public String getPessoaComplemento() {
		return pessoaComplemento;
	}

	public void setPessoaComplemento(String pessoaComplemento) {
		this.pessoaComplemento = pessoaComplemento;
	}

	public String getPessoaNumero() {
		return pessoaNumero;
	}

	public void setPessoaNumero(String pessoaNumero) {
		this.pessoaNumero = pessoaNumero;
	}

	public int getPessoaFkTipoContato() {
		return pessoaFkTipoContato;
	}

	public void setPessoaFkTipoContato(int pessoaFkTipoContato) {
		this.pessoaFkTipoContato = pessoaFkTipoContato;
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
