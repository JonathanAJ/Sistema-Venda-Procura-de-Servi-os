package com.projeto.controller.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projeto.dao.ServicosDAO;

@WebFilter("/servico.jsp")
public class FiltroService implements Filter {

	ServicosDAO servicoDAO = new ServicosDAO();
	
	public void doFilter(ServletRequest request,
							ServletResponse response,
								FilterChain chain)
										throws IOException, ServletException {
		
		HttpServletRequest requestServ = (HttpServletRequest) request;
		HttpServletResponse responseServ = (HttpServletResponse) response;
		
		int idServico;
		
		try {	
			idServico = Integer.parseInt(requestServ.getParameter("id"));	
			
			if(servicoDAO.getServicos(idServico) != null){
	            chain.doFilter(request, response);
				
			}else{
	            responseServ.sendRedirect("index.jsp");
				
			}
			
		}
		catch(NumberFormatException e){
			responseServ.sendRedirect("index.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void destroy() {
	}

}
