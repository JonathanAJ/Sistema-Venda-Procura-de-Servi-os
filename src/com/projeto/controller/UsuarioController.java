package com.projeto.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projeto.dao.*;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("criar")){
			String login = request.getParameter("login");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			UsuariosDAO user = new UsuariosDAO();
			String msg = Integer.toString(user.criarUsuario(login, email, senha));
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			out.write(msg);
		}
		
	}
}
