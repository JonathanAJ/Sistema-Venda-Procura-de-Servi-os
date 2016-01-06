package com.projeto.controller;

import java.sql.*;

public class ConexaoBD {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
<<<<<<< HEAD
		String senha = "";
		String nomeBancoDados = "sistemaVendas";
=======
		String senha = "P@ssw0rdBD";
		String nomeBancoDados = "sistemaServicos";
>>>>>>> 83ec811887eac98e6223ef7290ac8eed9542b560
 
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