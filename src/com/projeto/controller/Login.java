package com.projeto.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.projeto.dao.*;
import com.projeto.model.*;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		Usuario user = new Usuario();
		
		String login_form = request.getParameter("login");
		String senha_form = request.getParameter("senha"); 
        
		try {
			UsuariosDAO dao = new UsuariosDAO(); //cria uma instancia do DAO usuario
			user = dao.getUsuario(login_form, senha_form);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		if(user!=null){
			HttpSession ss = request.getSession(true);
			ss.setAttribute("Usuario", user);
			out.write("1");
		}else{
    		out.write("0");
		}
		
	}

}
