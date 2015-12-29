<%@page import="com.projeto.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="com.projeto.model.*"%>
<div class="row mg-tp-15">
  <div class="col s5 m3">
  <h4 class="indigo-text text-lighten-2 center-align">Categorias</h4>
	<div class="collection uppercase">
	<%
		CategoriasDAO catDao = new CategoriasDAO();
		List<Categoria> categoria = catDao.getCategorias();
		Iterator<Categoria> i = categoria.iterator();
		while(i.hasNext()){
			String cat = i.next().getCategNome();
			String catParam = request.getParameter("categoria");
			if(catParam==null || !catParam.equals(cat)){
	%>
			<a href="?categoria=<%= cat %>" class="collection-item">
				<%= cat %>
				<i class="material-icons tiny right">send</i>
			</a>
	<%
			}
			else{
	%>
			<a href="?categoria=<%= cat %>" class="collection-item active">
				<%= cat %>
				<i class="material-icons tiny right">send</i>
			</a>
	<%
			}
		}
	%>
	</div>
  </div>