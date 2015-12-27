package com.projeto.controller;

import com.projeto.model.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListarCategoriaServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	Connection connection = new ConexaoBD().getConexao();
        	System.out.println("Conexão aberta!");
            Statement statement = connection.createStatement();
            String sql = "SELECT categ_nome FROM categoria;";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Categoria> categorias = new ArrayList<Categoria>();
            while (resultSet.next()) {
            	Categoria categ = new Categoria();
            	categ.setCategNome(resultSet.getString("categ_nome"));
            	System.out.println("Teste: " + categ);
            	categorias.add(categ);
            }
            request.setAttribute("categoriasLista", categorias);
            resultSet.close();
            statement.close();
            connection.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarCategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}