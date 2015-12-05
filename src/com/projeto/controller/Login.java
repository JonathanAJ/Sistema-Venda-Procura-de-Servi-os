package com.projeto.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.projeto.model.*;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		if(usuario.getLogin().equals("JonathanA") && usuario.getSenha().equals("12345")){
			HttpSession ss = request.getSession(true);
			ss.setAttribute("Usuario", usuario);
			response.sendRedirect("principal.jsp");
		}else{
			response.sendRedirect("index.jsp");
		}
		
	}

}
