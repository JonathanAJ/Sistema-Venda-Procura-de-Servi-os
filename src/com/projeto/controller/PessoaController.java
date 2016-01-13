package com.projeto.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.projeto.dao.*;
import com.projeto.model.*;

@WebServlet("/PessoaController")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Pessoa pessoa = new Pessoa();
		
		HttpSession ss = request.getSession(true);
		Usuario user = (Usuario) ss.getAttribute("Usuario");

		pessoa.setPessoaFkUsuario(user.getUserPkId());
		pessoa.setPessoaNomeCompleto(request.getParameter("pessoaNome"));
		pessoa.setPessoaEmail(request.getParameter("pessoaEmail"));
		pessoa.setPessoaCep(request.getParameter("pessoaCep"));
		pessoa.setPessoaDoc(request.getParameter("pessoaDoc"));
		pessoa.setPessoaBairro(request.getParameter("pessoaBairro"));
		pessoa.setPessoaFkCidade(Integer.parseInt(request.getParameter("pessoaCidade")));
		pessoa.setPessoaFkEstado(Integer.parseInt(request.getParameter("pessoaEstado")));
		pessoa.setPessoaTipo(Short.parseShort(request.getParameter("pessoaTipo")));
		pessoa.setPessoaTelefone(request.getParameter("pessoaTelefone"));
		pessoa.setPessoaSexo(request.getParameter("pessoaSexo"));
		
		if(request.getParameter("acao").equals("atualizar")){
			PessoasDAO dao = new PessoasDAO();
			String msg = Integer.toString(dao.atualizarPessoa(pessoa));
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			out.write(msg);
		}
	}
}
