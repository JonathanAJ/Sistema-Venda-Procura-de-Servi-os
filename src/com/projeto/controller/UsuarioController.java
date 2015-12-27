package com.projeto.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projeto.model.Usuario;

public class UsuarioController {


	public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemaVendas", "postgres", "P@ssw0rdBD");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return connection;
    }
	
	public Usuario getUsuario(String login, String senha ){
        Connection c = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = c.prepareStatement("select user_nome, user_senha from vendas.usuario where user_nome = ? and user_senha = ?");
            ps.setString(1, login);
            ps.setString(2, senha);
 
            rs = ps.executeQuery();
 
            if ( rs.next() ){
                Usuario user = new Usuario();
                user.setLogin(login);
                user.setSenha(senha);
 
                return user;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if (rs != null ) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (ps != null ) {
                try { ps.close(); } catch (SQLException e) { ; }
                ps = null;
            }
            if (c != null ) {
                try { c.close(); } catch (SQLException e) { ; }
                c = null;
            }
        }
        return null;
    }
}
