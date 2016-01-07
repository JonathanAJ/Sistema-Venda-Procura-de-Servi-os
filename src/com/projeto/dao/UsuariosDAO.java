package com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projeto.controller.*;
import com.projeto.model.*;

public class UsuariosDAO {
	
	public Usuario validarLogin(String login, String senha){
		Connection connection = new ConexaoBD().getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = connection.prepareStatement("select user_pk_id, user_nome, user_status, user_data_desativacao from sistema.usuario "
            		+ "where user_status = true and user_nome = ? and user_senha = ?");
            ps.setString(1, login);
            ps.setString(2, senha);
 
            rs = ps.executeQuery();
 
            if ( rs.next() ){
                Usuario user = new Usuario();
                user.setUserPkId(rs.getInt("user_pk_id"));
                user.setLogin(login);
                user.setSenha(senha);
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
}
