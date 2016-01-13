package com.projeto.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.projeto.dao.*;
import com.projeto.model.*;

@WebServlet("/ServicoController")
public class ServicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		Servicos servico = new Servicos();
		HttpSession ss = request.getSession(true);
		Usuario user = (Usuario) ss.getAttribute("Usuario");
		
		servico.setServFkUsuario(user.getUserPkId());
		servico.setServNome(request.getParameter("servNome"));
		servico.setServDescricao(request.getParameter("servDescricao"));
		servico.setServFkCateg1(Integer.parseInt(request.getParameter("servCateg1")));
		servico.setServFkCateg2(Integer.parseInt(request.getParameter("servCateg2")));
		servico.setServValor(request.getParameter("servValor"));
		servico.setServImagem(request.getParameter("servImagem"));
		
		String acao = request.getParameter("acao");
		if(acao.equals("criar")){
			ServicosDAO dao = new ServicosDAO();
			String msg = Integer.toString(dao.criarServico(servico));
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			out.write(msg);
		}else{
			System.out.println("Deuu errooo");
		}
	}
}
