package com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.controller.ConexaoBD;
import com.projeto.model.Favoritos;

public class FavoritosDAO {
	
private List<Favoritos> favoritos = new ArrayList<Favoritos>();
	
	public List<Favoritos> getFavoritos(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT favorito_pk_id, favorito_fk_serv, favorito_fk_usuario FROM sistema.favoritos fav, sistema.servicos serv, sistema.usuario usuario where fav.favorito_fk_serv = serv.serv_pk_id and fav.favorito_fk_usuario = usuario.user_pk_id;";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Favoritos fav = new Favoritos();
	        	fav.setFavoritoPkId(resultSet.getLong("favorito_pk_id"));
	        	fav.setFavorFkServ(resultSet.getInt("favorito_fk_serv"));
	        	fav.setFavoritoFkUsuario(resultSet.getInt("favorito_fk_usuario"));
	        	favoritos.add(fav);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        return favoritos;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}


}
