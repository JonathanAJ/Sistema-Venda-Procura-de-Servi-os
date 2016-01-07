package com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projeto.controller.ConexaoBD;
import com.projeto.model.Pessoa;

public class PessoasDAO {
	
private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public List<Pessoa> getPessoa(){
		try {
	    	Connection connection = new ConexaoBD().getConexao();
	    	System.out.println("Conexao aberta!");
	        Statement statement = connection.createStatement();
	        String sql = "SELECT pessoa_pk_id, pessoa_nome_completo, pessoa_sexo, pessoa_cpf, pessoa_email, pessoa_telefone, pessoa_cep, pessoa_fk_cidade, pessoa_fk_estado, pessoa_fk_usuario, pessoa_bairro, pessoa_cnpj, pessoa_tipo FROM sistema.pessoa person, sistema.cidade cid, sistema.estado est, sistema.usuario usuario where person.pessoa_fk_cidade = cid.cid_pk_id and person.pessoa_fk_estado = est.estado_pk_id and person.pessoa_fk_usuario = usuario.user_pk_id";
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	        	Pessoa pessoa = new Pessoa();
	        	pessoa.setPessoaPkId(resultSet.getLong("pessoa_pk_id"));
	        	pessoa.setPessoaNomeCompleto(resultSet.getString("pessoa_nome_completo"));
	        	pessoa.setPessoaSexo(resultSet.getString("pessoa_sexo"));
	        	pessoa.setPessoaCpf(resultSet.getString("pessoa_cpf"));
	        	pessoa.setPessoaCnpj(resultSet.getString("pessoa_cnpj"));
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
}
