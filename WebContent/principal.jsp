<%@ page import="com.projeto.controller.*" %>
<%@ page import="com.projeto.model.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%
		if(request.getSession(false)==null){
			response.sendRedirect("index.jsp");
		}
	%>
	<%=request.getSession(false) %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Venda de Serviços</title>
	<link rel="stylesheet" href="bootstrap-3.3.6/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container">
		<div class="row">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/Sistema-Venda-Procura-de-Servicos/">
						Sistema de Venda e Procura de Serviços
					</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
            		<%Usuario usuario = (Usuario) session.getAttribute("Usuario"); %>
            		<p class="navbar-text">Olá, <%= usuario.getLogin() %></p>
            		<li><a href="/Sistema-Venda-Procura-de-Servicos/Logout">Sair</a></li>
			    </ul>
			</div>
		</nav>
		</div>
	</div>
	<script src="bootstrap-3.3.6/js/bootstrap.min.js"></script>
</body>
</html>