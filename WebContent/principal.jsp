<%		
	if(session.getAttribute("Usuario")==null){
		response.sendRedirect("index.jsp");
	}else{
%>
<%@ include file="header.jsp"%>
<div class="row">
    <div class="col s12">
		<ul class="tabs mg-bt-20">
			<li class="tab col s3"><a class="blue-grey-text blue-grey lighten-5 active" href="#test1">Novo Serviço</a></li>
			<li class="tab col s3"><a class="blue-grey-text blue-grey lighten-5" href="#test2">Meus Serviços</a></li>
			<li class="tab col s3"><a class="blue-grey-text blue-grey lighten-5" href="#test3">Minha Conta</a></li>
			<li class="tab col s3"><a class="blue-grey-text blue-grey lighten-5" href="#test4">Favoritos</a></li>
            <div class="indicator blue-grey lighten-1" style="z-index:1"></div>
		</ul>
    </div>
    <div id="test1" class="col s12">
		<%@ include file="include-tabs/criaServico.jsp" %>
    </div>
    <div id="test2" class="col s12">
		<h4 class="indigo-text text-lighten-2 center-align">Aba 2</h4>
	</div>
    <div id="test3" class="col s12">
		<%@ include file="include-tabs/conta.jsp" %>
    </div>
    <div id="test4" class="col s12">
		<h4 class="indigo-text text-lighten-2 center-align">Aba 4</h4>
	</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
	<%
		}
	%>