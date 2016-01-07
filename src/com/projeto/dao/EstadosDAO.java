package com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.controller.ConexaoBD;
import com.projeto.model.Estado;

public class EstadosDAO {
	
private List<Estado> estados = new ArrayList<Estado>();
	
	public List<Estado> getEstados(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT estado_pk_id, estado_nome, estado_sigla FROM sistema.estado;";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Estado estado = new Estado();
	        	estado.setEstadoPkId(resultSet.getLong("estado_pk_id"));
	        	estado.setEstadoNome(resultSet.getString("estado_nome"));
	        	estado.setEstadoSigla(resultSet.getString("estado_sigla"));
	        	estados.add(estado);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        return estados;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}

}
