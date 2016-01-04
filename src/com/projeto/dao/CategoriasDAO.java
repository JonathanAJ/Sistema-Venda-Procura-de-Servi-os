package com.projeto.dao;

import java.sql.*;
import java.util.*;
import com.projeto.controller.ConexaoBD;
import com.projeto.model.Categoria;

public class CategoriasDAO {
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	public List<Categoria> getCategorias(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT categ_nome FROM sistema.categoria;";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Categoria categ = new Categoria();
	        	categ.setCategNome(resultSet.getString("categ_nome"));
	        	categorias.add(categ);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        return categorias;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}
}