package com.projeto.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.projeto.dao.*;

@WebServlet("/ServicoController")
public class ServicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		String acao = request.getParameter("acao");
		
		if(acao.equals("criar")){
			String servicoNome = request.getParameter("servicoNome");
			String servicoDescricao = request.getParameter("servicoDescricao");
			String servicoValor = request.getParameter("servicoValor");
			int servicoCateg1 = Integer.parseInt(request.getParameter("servicoCateg1"));
			int servicoCateg2 = Integer.parseInt(request.getParameter("servicoCateg2"));
			
			ServicosDAO dao = new ServicosDAO();
			String msg = Integer.toString(dao.criarServico(servicoNome, servicoDescricao, servicoValor, servicoCateg1, servicoCateg2));
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			out.write(msg);
		}else{
			System.out.println("Deuu errooo");
		}
	}
}
