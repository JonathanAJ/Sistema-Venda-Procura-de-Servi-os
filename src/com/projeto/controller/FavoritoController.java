package com.projeto.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.projeto.dao.*;
import com.projeto.model.*;

@WebServlet("/FavoritoController")
public class FavoritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession(true); 
		Usuario user = (Usuario) ss.getAttribute("Usuario");
		
		FavoritosDAO favorito = new FavoritosDAO();
		
		String acao = request.getParameter("acao");
		int favoritoId = Integer.parseInt(request.getParameter("favoritoId"));
		if(acao.equals("favoritar")){
			String msg = Integer.toString(favorito.criarFavorito(favoritoId, user.getUserPkId()));
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			out.write(msg);
		}
	}
}
