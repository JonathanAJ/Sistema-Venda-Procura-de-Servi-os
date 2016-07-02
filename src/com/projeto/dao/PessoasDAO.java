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

public class PessoasDAO {
	
private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public List<Pessoa> getPessoa(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT pessoa_pk_id, pessoa_nome_completo, pessoa_sexo, pessoa_doc, pessoa_email, pessoa_telefone, pessoa_cep, pessoa_fk_cidade, pessoa_fk_estado, pessoa_fk_usuario, pessoa_bairro, pessoa_tipo FROM sistema.pessoa person, sistema.cidade cid, sistema.estado est, sistema.usuario usuario where person.pessoa_fk_cidade = cid.cid_pk_id and person.pessoa_fk_estado = est.estado_pk_id and person.pessoa_fk_usuario = usuario.user_pk_id";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Pessoa pessoa = new Pessoa();
	        	pessoa.setPessoaPkId(resultSet.getLong("pessoa_pk_id"));
	        	pessoa.setPessoaNomeCompleto(resultSet.getString("pessoa_nome_completo"));
	        	pessoa.setPessoaSexo(resultSet.getString("pessoa_sexo"));
	        	pessoa.setPessoaDoc(resultSet.getString("pessoa_doc"));
	        	pessoa.setPessoaEmail(resultSet.getString("pessoa_email"));
	        	pessoa.setPessoaTelefone(resultSet.getString("pessoa_telefone"));
	        	pessoa.setPessoaCep(resultSet.getString("pessoa_cep"));
	        	pessoa.setPessoaBairro(resultSet.getString("pessoa_bairro"));
	        	pessoa.setPessoaFkCidade(resultSet.getInt("pessoa_fk_cidade"));
	        	pessoa.setPessoaFkEstado(resultSet.getInt("pessoa_fk_estado"));
	        	pessoa.setPessoaFkUsuario(resultSet.getInt("pessoa_fk_usuario"));
	        	pessoa.setPessoaTipo(resultSet.getShort("pessoa_tipo"));
	        	
	        	pessoas.add(pessoa);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        return pessoas;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}

	public Pessoa getPessoa(int fk_usuario){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT pessoa_pk_id, pessoa_nome_completo, pessoa_sexo,"+
	        			 " pessoa_doc, pessoa_email, pessoa_telefone, pessoa_cep,"+
	        			 " pessoa_fk_cidade, pessoa_fk_estado, pessoa_fk_usuario,"+
	        			 " pessoa_bairro, pessoa_tipo"+
	        			 " FROM sistema.pessoa WHERE pessoa_fk_usuario='"+fk_usuario+"'";
	        
	        ResultSet resultSet = statement.executeQuery(sql);
        	
	        Pessoa pessoa = new Pessoa();
        	
	        while (resultSet.next()) {
	        	pessoa.setPessoaPkId(resultSet.getLong("pessoa_pk_id"));
	        	pessoa.setPessoaNomeCompleto(resultSet.getString("pessoa_nome_completo"));
	        	pessoa.setPessoaSexo(resultSet.getString("pessoa_sexo"));
	        	pessoa.setPessoaDoc(resultSet.getString("pessoa_doc"));
	        	pessoa.setPessoaEmail(resultSet.getString("pessoa_email"));
	        	pessoa.setPessoaTelefone(resultSet.getString("pessoa_telefone"));
	        	pessoa.setPessoaCep(resultSet.getString("pessoa_cep"));
	        	pessoa.setPessoaBairro(resultSet.getString("pessoa_bairro"));
	        	pessoa.setPessoaFkCidade(resultSet.getInt("pessoa_fk_cidade"));
	        	pessoa.setPessoaFkEstado(resultSet.getInt("pessoa_fk_estado"));
	        	pessoa.setPessoaFkUsuario(resultSet.getInt("pessoa_fk_usuario"));
	        	pessoa.setPessoaTipo(resultSet.getShort("pessoa_tipo"));
	        	
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	        
	        return pessoa;
	        		
	    } catch (SQLException ex) {
	        System.out.println("Erro no SQL: "+ex);
	        return null;
	    }
	}
	
	public int atualizarPessoa(Pessoa pessoa){
		try{
        	Connection connection = new ConexaoBD().getConexao();
        	PreparedStatement ps = null;
			/*
			 * Atualiza Pessoa 
			 */
        	String sql = "UPDATE sistema.pessoa SET"+
					 " pessoa_nome_completo = ?,"+
					 " pessoa_sexo = ?,"+
					 " pessoa_doc = ?,"+
					 " pessoa_email = ?,"+
					 " pessoa_telefone = ?,"+
					 " pessoa_cep = ?,"+
					 " pessoa_bairro = ?,"+
					 " pessoa_tipo = ?"+
					 " WHERE pessoa_fk_usuario = ?";
        	
			ps = connection.prepareStatement(sql);
			ps.setString(1, pessoa.getPessoaNomeCompleto());
			ps.setString(2, pessoa.getPessoaSexo());
			ps.setString(3, pessoa.getPessoaDoc());
			ps.setString(4, pessoa.getPessoaEmail());
			ps.setString(5, pessoa.getPessoaTelefone());
			ps.setString(6, pessoa.getPessoaCep());
			ps.setString(7, pessoa.getPessoaBairro());
			ps.setInt(8, pessoa.getPessoaTipo());
			ps.setInt(9, pessoa.getPessoaFkUsuario());
			
			ps.executeUpdate();
			
			String sql2 = "UPDATE sistema.pessoa SET"+
					 " pessoa_fk_cidade = ?" +
					 " WHERE pessoa_fk_usuario = ?";
			
			if(pessoa.getPessoaFkCidade()!=0){
				ps = connection.prepareStatement(sql2);
				ps.setInt(1, pessoa.getPessoaFkCidade());
				ps.setInt(2, pessoa.getPessoaFkUsuario());
				
				ps.executeUpdate();
			}
			String sql3 = "UPDATE sistema.pessoa SET"+
					 " pessoa_fk_estado = ?"+
					 " WHERE pessoa_fk_usuario = ?";
			
			if(pessoa.getPessoaFkEstado()!=0){
				ps = connection.prepareStatement(sql3);
				ps.setInt(1, pessoa.getPessoaFkEstado());
				ps.setInt(2, pessoa.getPessoaFkUsuario());
				
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
