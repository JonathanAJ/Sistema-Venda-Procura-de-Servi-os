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
	
	public int atualizarServico(Servicos servico){
		try{
        	Connection connection = new ConexaoBD().getConexao();
        	PreparedStatement ps = null;
			/*
			 * Atualiza servico 
			 */
			ps = connection.prepareStatement("UPDATE sistema.servicos SET"+
											 " serv_nome='"+servico.getServNome()+"',"+
											 " serv_descricao='"+servico.getServDescricao()+"',"+
											 " serv_valor='"+servico.getServValor()+"',"+
											 " serv_fk_categ1='"+servico.getServFkCateg1()+"',"+
											 " serv_fk_categ2='"+servico.getServFkCateg2()+"'"+
											 " WHERE serv_fk_usuario='"+servico.getServFkUsuario()+"'");
			ps.executeUpdate();
			ps.close();
            return 1;
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public int criarServico(String servicoNome, String servicoDescricao, String servicoValor, int servicoCateg1, int servicoCateg2){
		
			try{

		        	Connection connection = new ConexaoBD().getConexao();
		        	PreparedStatement ps = null;
		        	
					/*
					 * Insere Usuário 
					 */
					ps = connection.prepareStatement("INSERT INTO sistema.servicos (serv_nome, serv_descricao, serv_valor, serv_fk_categ1, serv_fk_categ2)"+
													 " VALUES (?,?,?,?,?)");
					ps.setString(1, servicoNome);
					ps.setString(2, servicoDescricao);
					ps.setString(3, servicoValor);
					ps.setInt(4, servicoCateg1);
					ps.setInt(5, servicoCateg2);
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


