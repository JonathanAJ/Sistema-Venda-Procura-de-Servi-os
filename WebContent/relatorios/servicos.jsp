<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<title>Venda de Serviços</title>
	<!--Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="../materialize/css/materialize.min.css"  media="screen,projection"/>
	<link type="text/css" rel="stylesheet" href="../css/index.css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
	<div class="row container">
		<h3 align="center">Relatório de Serviços</h3>
		<div class="row">
			<a class="waves-effect waves-light btn right" href="#" onclick="window.print();" target="blank">
				<i class="material-icons left">print</i>Imprimir
			</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Nome do Serviço:</th>
					<th>Descrição:</th>
					<th>Valor (R$):</th>
				</tr>
			</thead>
			<tbody>
			<%
			Usuario userMeuServ = (Usuario) session.getAttribute("Usuario");

			ServicosDAO servicosDAO = new ServicosDAO();
			List<Servicos> servico = servicosDAO.listaServicosUsuario(userMeuServ.getUserPkId());
			Iterator<Servicos> iServico = servico.iterator();
			
			while(iServico.hasNext()){
				Servicos servicoIterator = (Servicos) iServico.next();
			%>
			    <tr>
			    	<td><%=servicoIterator.getServNome()%></td>
			    	<td><%=servicoIterator.getServDescricao()%></td>
			    	<td><%=servicoIterator.getServValor()%></td>
			    </tr>
					
			<%
				}
			%>
			</tbody>
		</table>
	</div>
	
	<script src="../js/jquery-2.1.4.min.js"></script>
	<script src="../materialize/js/materialize.min.js"></script>
	<script src="../js/myscript.js"></script>
</body>
</html>