<%		
	if(session.getAttribute("Usuario")==null){
		response.sendRedirect("index.jsp");
	}else{
%>
<%@ include file="header.jsp"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/Sistema-Venda-Procura-de-Servicos/">
					Sistema de Venda e Procura de Serviços
				</a>
				<ul class="nav navbar-nav">	
			        <li><a href="#">Sobre</a></li>
			    </ul>
			</div>
			<ul class="nav navbar-nav navbar-right">
	          		<% Usuario usuario = (Usuario) session.getAttribute("Usuario"); %>
	          		<li><p class="navbar-text">Olá, <%= usuario.getLogin() %></p></li>
	          		<li><a href="/Sistema-Venda-Procura-de-Servicos/Logout">Sair</a></li>
		    </ul>
		</div>
	</nav>
</div>
<%@ include file="search.jsp"%>
<%@ include file="footer.jsp"%>
	<%
		}
	%>