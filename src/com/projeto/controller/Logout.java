package com.projeto.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession(false);
		
		if(ss!=null){
			ss.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

}
