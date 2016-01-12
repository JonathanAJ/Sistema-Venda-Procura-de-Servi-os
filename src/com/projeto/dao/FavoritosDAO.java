package com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.controller.ConexaoBD;
import com.projeto.model.*;

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
	
	public boolean getFavoritos(long idServico, int idUsuario){
		try {
			
	    	Connection connection = new ConexaoBD().getConexao();
	        Statement statement = connection.createStatement();
	        String sql = "SELECT favorito_pk_id FROM sistema.favoritos WHERE" +
	        			 " favorito_fk_serv='"+idServico+"' AND"+
	        			 " favorito_fk_usuario='"+idUsuario+"'";
	        
	        ResultSet resultSet = statement.executeQuery(sql);
	        resultSet.next();
	        /*
	         * Se não houver linhas retorne true
	         */
	        if (resultSet.getRow()==0) {
		        resultSet.close();
		        statement.close();
		        connection.close();
		        return true;
	        }else{
		        resultSet.close();
		        statement.close();
		        connection.close();
		        return false;
	        }
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return false;
	    }
	}

	public int criarFavorito(int idServico, int idUsuario){
			try{
	        	Connection connection = new ConexaoBD().getConexao();
	        	PreparedStatement ps = null;	
				/*
				 * Insere Favorito 
				 */
	        	String sql = "INSERT INTO sistema.favoritos (favorito_fk_serv, favorito_fk_usuario)"+
						 	 " VALUES (?,?)";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, idServico);
				ps.setInt(2, idUsuario);
				ps.executeUpdate();
				ps.close();
				connection.close();
	            return 1;
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}
		}


}
