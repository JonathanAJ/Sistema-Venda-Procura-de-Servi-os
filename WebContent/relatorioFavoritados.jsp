<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>

<div class="col s12">
	<div class="row">
		<div class="col s12 m6">
		
		<h2 align="center">Relatório de Serviços Favoritados</h2>
	
	<table border="1">
	<th>Nome do Serviço:</th>
	<th>Descrição:</th>
	<th>Valor (R$):</th>
	
	
<%
	Usuario userFavServ = (Usuario) session.getAttribute("Usuario");

	FavoritosDAO favoritosDAO = new FavoritosDAO();
	List<Favoritos> favorito = favoritosDAO.getFavoritos(userFavServ.getUserPkId());
	Iterator<Favoritos> iFavorito = favorito.iterator();
	
	ServicosDAO servicoDAO = new ServicosDAO();
	while(iFavorito.hasNext()){
		Favoritos favoritoIterator = (Favoritos) iFavorito.next();
		int idServ = favoritoIterator.getFavoritoFkServ();
		Servicos servicoIterator = servicoDAO.getServicos(idServ);
%>
    <tr>
    	<td><%=servicoIterator.getServNome()%></td>
    	<td><%=servicoIterator.getServDescricao()%></td>
    	<td><%=servicoIterator.getServValor()%></td>
    </tr>
		
<%
	}
%>	
	</table>
	
	<input type="button" name="imprimir" value="Imprimir" onclick="window.print();">
	
	<a href="principal.jsp">Voltar</a>
	</div>
	</div>
</div>