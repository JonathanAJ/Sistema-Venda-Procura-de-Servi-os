package com.projeto.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.projeto.dao.*;
import com.projeto.model.*;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if(acao.equals("criar")){

			PrintWriter out = response.getWriter();
			UsuariosDAO userDao = new UsuariosDAO();
			
			String login = request.getParameter("login");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			String msg = "0";
			if(!login.isEmpty() && !email.isEmpty() && !senha.isEmpty()){
				msg = Integer.toString(userDao.criarUsuario(login, email, senha));
			}
			
			out = response.getWriter();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			out.write(msg);
			
		}
		else if(acao.equals("login")){

			PrintWriter out = response.getWriter();
			UsuariosDAO userDao = new UsuariosDAO();
			Usuario user = new Usuario();
			user = null;
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha"); 
			String lembrarLogin = request.getParameter("lembrar");
	        
			if(!login.isEmpty() && !senha.isEmpty()){
				user = userDao.getUsuario(login, senha);
			}
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			if(user != null){
				/*
				 * Iniciar a Sessão
				 */
				HttpSession ss = request.getSession(true);
				ss.setAttribute("Usuario", user);
				/*
				 * Iniciar contador do contexto
				 */
				int num = (int) this.getServletContext().getAttribute("Online");
				num = num + 1;
				this.getServletContext().setAttribute("Online", num);
				/*
				 * Guardar os Cookies 
				 */
				if(lembrarLogin.equals("true")){
					Cookie cookieLogin = new Cookie("Usuario", user.getLogin());
					Cookie cookieSenha = new Cookie("Senha", user.getSenha());
					Cookie cookieLembrar = new Cookie("Lembrar", "true");
					response.addCookie(cookieLogin);
					response.addCookie(cookieSenha);
					response.addCookie(cookieLembrar);
				}else{
					Cookie[] cc = request.getCookies();
					if(cc.length>1){
						Cookie cookieLogin = new Cookie("Usuario", "");
						Cookie cookieSenha = new Cookie("Senha", "");
						Cookie cookieLembrar = new Cookie("Lembrar", "false");
						response.addCookie(cookieLogin);
						response.addCookie(cookieSenha);
						response.addCookie(cookieLembrar);
					}
				}
				out.write("1");
			}
			else{
	    		out.write("0");
			}
			
		}
		else if(acao.equals("logout")){
			
		}
		
	}
}
