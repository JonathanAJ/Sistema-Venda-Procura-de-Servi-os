<%@page import="com.projeto.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="com.projeto.model.*"%>
<div class="row">
  <div class="col s5 m3">
	<div class="collection uppercase">
	<%
		CategoriasDAO catDao = new CategoriasDAO();
		List<Categoria> categoria = catDao.getCategorias();
		Iterator<Categoria> i = categoria.iterator();
		while(i.hasNext()){
	%>
			<a href="#!" class="collection-item indigo-text">
				<%= i.next().getCategNome()%>
			</a>
	<%
		}
	%>
	</div>
  </div>