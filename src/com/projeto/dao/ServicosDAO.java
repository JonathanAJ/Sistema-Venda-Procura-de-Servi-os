package com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public List<Servicos> listaServicosUsuario(int idUsuario){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	    	
	        String sql = "SELECT * FROM sistema.servicos WHERE serv_fk_usuario = ?";
	        
	    	PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, idUsuario);
	    	
	        ResultSet resultSet = ps.executeQuery();
	        
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
	        ps.close();
	        connection.close();
	        return servicos;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}
	
	public Servicos getServicos(int id){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	    	
	        String sql = "SELECT * FROM sistema.servicos WHERE serv_pk_id = ?";
	        
	    	PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	    	
	        ResultSet resultSet = ps.executeQuery();
	        
        	Servicos serv = new Servicos();
        	if(resultSet.next()){
	        	serv.setServPkId(resultSet.getLong("serv_pk_id"));
	        	serv.setServNome(resultSet.getString("serv_nome"));
	        	serv.setServDescricao(resultSet.getString("serv_descricao"));
	        	serv.setServValor(resultSet.getString("serv_valor"));
	        	serv.setServImagem(resultSet.getString("serv_imagem"));
	        	serv.setServFkCateg1(resultSet.getInt("serv_fk_categ1"));
	        	serv.setServFkCateg2(resultSet.getInt("serv_fk_categ2"));
	        	serv.setServFkUsuario(resultSet.getInt("serv_fk_usuario"));	
        	}
        	else {
        		serv = null;
        	}
	        resultSet.close();
	        ps.close();
	        connection.close();
	        return serv;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}
	
	public int atualizarServico(Servicos servico){
		try{
        	Connection connection = new ConexaoBD().getConexao();
        	PreparedStatement ps = null;
			/*
			 * Atualiza servico 
			 */
        	String sql = "UPDATE sistema.servicos SET" +
					 " serv_nome = ?," +
					 " serv_descricao = ?," +
					 " serv_valor = ?," +
					 " serv_fk_categ1 = ?," +
					 " serv_fk_categ2 = ?" +
					 " WHERE serv_fk_usuario = ?";
        	
			ps = connection.prepareStatement(sql);
			ps.setString(1, servico.getServNome());
			ps.setString(2, servico.getServDescricao());
			ps.setString(3, servico.getServValor());
			ps.setInt(4, servico.getServFkCateg1());
			ps.setInt(5, servico.getServFkCateg2());
			ps.setInt(6, servico.getServFkUsuario());
			
			ps.executeUpdate();
			
			String sql2 = "UPDATE sistema.servicos SET " +
					 "serv_fk_categ1 = ? " +
					 "WHERE serv_fk_usuario = ?";
			
			if(servico.getServFkCateg1() != 0){
				ps = connection.prepareStatement(sql2);
				ps.setInt(1, servico.getServFkCateg1());
				ps.setInt(2, servico.getServFkUsuario());
				
				ps.executeUpdate();
			}
			
			String sql3 = "UPDATE sistema.servicos SET" +
					 "serv_fk_categ2 = ? " +
					 "WHERE serv_fk_usuario = ?";
			
			if(servico.getServFkCateg2() != 0) {
				ps = connection.prepareStatement(sql3);
				ps.setInt(1, servico.getServFkCateg2());
				ps.setInt(2, servico.getServFkUsuario());
				
				ps.executeUpdate();
			}
			ps.close();
            return 1;
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public int criarServico(Servicos servico){
			try{
	        	Connection connection = new ConexaoBD().getConexao();
	        	PreparedStatement ps = null;	
				/*
				 * Insere Usuário 
				 */
	        	String sql = "INSERT INTO sistema.servicos (serv_nome, serv_descricao, serv_valor,"+
	        				 " serv_fk_usuario, serv_imagem)"+
						 	 " VALUES (?,?,?,?,?)";
				ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, servico.getServNome());
				ps.setString(2, servico.getServDescricao());
				ps.setString(3, servico.getServValor());
				ps.setInt(4, servico.getServFkUsuario());
				ps.setString(5, servico.getServImagem());
				ps.executeUpdate();
				
				ResultSet rs = ps.getGeneratedKeys();
				int ultimoID = 0;
				if (rs.next()) {
				    ultimoID = rs.getInt(1);
				}
				
				String sql2 = "UPDATE sistema.servicos SET " +
						 "serv_fk_categ1 = ? " +
						 "WHERE serv_pk_id = ? ";
				
				if(servico.getServFkCateg1()!=0){
					ps = connection.prepareStatement(sql2);
					ps.setInt(1, servico.getServFkCateg1());
					ps.setInt(2, ultimoID);
					ps.executeUpdate();
				}
				
				String sql3 = "UPDATE sistema.servicos SET " +
						 "serv_fk_categ2 = ? " +
						 "WHERE serv_pk_id = ? ";
				
				if(servico.getServFkCateg2()!=0){
					ps = connection.prepareStatement(sql3);
					ps.setInt(1, servico.getServFkCateg2());
					ps.setInt(2, ultimoID);
					ps.executeUpdate();
				}
				ps.close();
				connection.close();
				
	            return 1;
			}catch(SQLException e){
				e.printStackTrace();
				return 0;
			}
		}
		
	}


