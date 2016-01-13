package com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projeto.controller.*;
import com.projeto.model.*;

public class UsuariosDAO {
    
	public Usuario getUsuario(String login, String senha){
        try{
        	Connection connection = new ConexaoBD().getConexao();
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            ps = connection.prepareStatement("SELECT user_pk_id, user_nome, user_status, user_data_desativacao FROM sistema.usuario "
            		+ "WHERE user_status = true AND user_nome = ? AND user_senha = ?");
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if(rs.next()){
                Usuario user = new Usuario();
                user.setUserPkId(rs.getInt("user_pk_id"));
                user.setLogin(login);
                user.setSenha(senha);
                user.setUserStatus(rs.getBoolean("user_status"));
                user.setDataDesativacao(rs.getDate("user_data_desativacao"));
                if(user.getDataDesativacao()==null){
                    return user;
                }
            }
            rs.close();
            ps.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
	
	public Usuario getUsuario(String login){
        try{
        	Connection connection = new ConexaoBD().getConexao();
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            ps = connection.prepareStatement("SELECT user_pk_id, user_nome, user_status, user_data_desativacao FROM sistema.usuario "
            		+ "WHERE user_status = true AND user_nome = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            if(rs.next()){
                Usuario user = new Usuario();
                user.setUserPkId(rs.getInt("user_pk_id"));
                user.setLogin(login);
                user.setUserStatus(rs.getBoolean("user_status"));
                user.setDataDesativacao(rs.getDate("user_data_desativacao"));
                if(user.getDataDesativacao()==null){
                    return user;
                }
            }
            rs.close();
            ps.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

	public Usuario getUsuario(int id){
        try{
        	Connection connection = new ConexaoBD().getConexao();
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            ps = connection.prepareStatement("SELECT * FROM sistema.usuario "
            		+ "WHERE user_status = true AND user_pk_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                Usuario user = new Usuario();
                user.setUserPkId(rs.getInt("user_pk_id"));
                user.setLogin(rs.getString("user_nome"));
                user.setUserStatus(rs.getBoolean("user_status"));
                user.setDataDesativacao(rs.getDate("user_data_desativacao"));
                if(user.getDataDesativacao()==null){
                    return user;
                }
            }
            rs.close();
            ps.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
	public int criarUsuario(String login, String email, String senha){
		/*
		 * Confere se o usuário já existe
		 */
			if(this.getUsuario(login)==null){
				try{

		        	Connection connection = new ConexaoBD().getConexao();
		        	PreparedStatement ps = null;
		        	
					/*
					 * Insere Usuário 
					 */
		        	String sql = "INSERT INTO sistema.usuario (user_nome, user_senha, user_status)"+
							 	 " VALUES (?,?,?)";
					ps = connection.prepareStatement(sql);
					ps.setString(1, login);
					ps.setString(2, senha);
					ps.setBoolean(3, true);
					ps.executeUpdate();
					ps.close();
					/*
					 * Insere Pessoa apartir do usuário criado
					 */
					Usuario user = new Usuario();
					user = this.getUsuario(login, senha);
					int user_pk_id = user.getUserPkId();
					sql = "INSERT INTO sistema.pessoa (pessoa_fk_usuario, pessoa_email,"+
					" pessoa_sexo, pessoa_nome_completo, pessoa_doc, pessoa_telefone, pessoa_cep, pessoa_bairro, pessoa_tipo)"+
					" VALUES (?,?,'','','','','','',0)";
		            ps = connection.prepareStatement(sql);
		            ps.setInt(1, user_pk_id);
		            ps.setString(2, email);
					ps.executeUpdate();
		            ps.close();
		            connection.close();
		            return 1;
				}catch(SQLException e){
					e.printStackTrace();
					return 0;
				}
		}else{
			return 0;
		}
	}
	
}
