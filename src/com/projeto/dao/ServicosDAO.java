package com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.controller.ConexaoBD;
import com.projeto.model.Servicos;

public class ServicosDAO {
	
private List<Servicos> servicos = new ArrayList<Servicos>();
	
	public List<Servicos> getServicos(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT servico.*, (select categ_nome from sistema.categoria cat where servico.serv_fk_categ1=cat.categ_pk_id) as cate, (select categ_nome from sistema.categoria cat where servico.serv_fk_categ2=cat.categ_pk_id) as cate FROM sistema.servicos servico, sistema.usuario usuario where servico.serv_fk_usuario = usuario.user_pk_id";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Servicos serv = new Servicos();
	        	serv.setServPkId(resultSet.getLong("serv_pk_id"));
	        	serv.setServNome(resultSet.getString("serv_nome"));
	        	serv.setServDescricao(resultSet.getString("serv_descricao"));
	        	serv.setServValor(resultSet.getString("serv_valor"));
	        	serv.setServImagem(resultSet.getString("serv_imagem"));
	        	serv.setServFkCateg1(resultSet.getInt("serv_fk_categ1"));
	        	serv.setServFkCateg2(resultSet.getInt("serv_fk_categ2"));
	        	serv.setServFkUsuario(resultSet.getInt("serv_fk_usuario"));
	        	
	        	servicos.add(serv);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        return servicos;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}

}
