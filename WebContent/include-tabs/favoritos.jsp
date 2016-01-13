<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>

<div class="col s12">
	<div class="row">
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
		<div class="col s12 m4">
			<div class="card hoverable">
				<div class="card-image">
					<img class="responsive-img" src="http://dpcpa.com/wp-content/uploads/2015/01/thumbnail-default.jpg">
					<span class="card-title"><%=servicoIterator.getServNome()%></span>
				</div>
				<div class="card-content">
					<div class="chip uppercase mg-bt-5">
						Aluguel
					</div>
					<div class="chip uppercase mg-bt-5">
						Turismo
					</div>
					<p><%=servicoIterator.getServDescricao()%></p>
				</div>
				<div class="card-action">
					<a href="servico.jsp?id=<%=servicoIterator.getServPkId()%>">
						<i class="material-icons left">contact_phone</i>
						Contato
					</a>
					<span class="preco right blue-text">R$ <%=servicoIterator.getServValor()%></span>
				</div>
			</div>
		</div>
<%
	}
%>
	</div>
</div>