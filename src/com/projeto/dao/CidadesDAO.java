package com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.controller.ConexaoBD;
import com.projeto.model.Cidade;

public class CidadesDAO {
	
private List<Cidade> cidades = new ArrayList<Cidade>();
	
	public List<Cidade> getCidades(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT cid_pk_id, cid_nome, cid_fk_estado FROM sistema.cidade cid, sistema.estado est where cid.cid_pk_id = est.estado_pk_id;";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Cidade cidade = new Cidade();
	        	cidade.setCidPkId(resultSet.getLong("cid_pk_id"));
	        	cidade.setCidNome(resultSet.getString("cid_nome"));
	        	cidade.setCidFkEstado(resultSet.getInt("cid_fk_estado"));
	        	cidades.add(cidade);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        return cidades;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}

}
