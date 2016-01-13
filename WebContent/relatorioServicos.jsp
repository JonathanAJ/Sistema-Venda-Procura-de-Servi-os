<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>

<div class="col s12">
	<div class="row">
		<div class="col s12 m6">
		
		<h2 align="center">Relatório de Serviços Cadastrados</h2>
	
	<table border="1">
	<th>Nome do Serviço:</th>
	<th>Descrição:</th>
	<th>Valor (R$):</th>
	
	
<%
	Usuario userServ = (Usuario) session.getAttribute("Usuario");

	ServicosDAO servicoDAO = new ServicosDAO();
	List<Servicos> servicos = servicoDAO.listaServicosUsuario(userServ.getUserPkId());
	if (servicos.size() > 0) {
        for (Servicos s : servicos) {
%>
    <tr>
    	<td><%=s.getServNome()%></td>
    	<td><%=s.getServDescricao()%></td>
    	<td><%=s.getServValor()%></td>
    </tr>
		
<%
		}
	}
%>	
	</table>
	
	<input type="button" name="imprimir" value="Imprimir" onclick="window.print();">
	
	<a href="principal.jsp">Voltar</a>
	</div>
	</div>
</div>