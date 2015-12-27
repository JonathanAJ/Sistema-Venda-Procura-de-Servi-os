<%		
	if(session.getAttribute("Usuario")==null){
		response.sendRedirect("index.jsp");
	}else{
%>
<%@ include file="header.jsp"%>
<div class="row">
  <div class="col s5 m3">
	<div class="collection uppercase">
		<a href="#!" class="collection-item indigo-text">Novo Serviço</a>
		<a href="#!" class="collection-item indigo-text"> - </a>
		<a href="#!" class="collection-item indigo-text"> - </a>
		<a href="#!" class="collection-item indigo-text"> - </a>
	</div>
  </div>
<%@ include file="services.jsp"%>
<%@ include file="footer.jsp"%>
	<%
		}
	%>