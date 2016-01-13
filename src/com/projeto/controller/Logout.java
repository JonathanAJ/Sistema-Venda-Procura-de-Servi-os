package com.projeto.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.projeto.model.Online;

import javax.servlet.annotation.WebServlet;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession(false);
		
		if(ss!=null){
			ss.invalidate();
			
			int num = (int) this.getServletContext().getAttribute("Online");
			num = num - 1;
			this.getServletContext().setAttribute("Online", num);
			
			response.sendRedirect("index.jsp");
		}
	}

}
