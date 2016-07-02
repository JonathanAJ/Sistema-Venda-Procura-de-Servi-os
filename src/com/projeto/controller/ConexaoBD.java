package com.projeto.controller;

import java.sql.*;

public class ConexaoBD {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "85539328";
		String nomeBancoDados = "sistemaServicos";
 
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