package com.projeto.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "P@ssw0rdBD";
		String nomeBancoDados = "sistemaVendas";
 
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
					 usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}