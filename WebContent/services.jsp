<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>

<div class="col s7 m9">
	<div class="row">
<%
	String paramCat = request.getParameter("categoria");
	ServicosDAO servicosDAO = new ServicosDAO();

	List<Servicos> servicos = servicosDAO.getServicos();
	Iterator<Servicos> iServico = servicos.iterator();
	while(iServico.hasNext()){
		Servicos servicoIterator = (Servicos) iServico.next();
%>
		<div class="col s12 m6">
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
</div> <!-- fim linha layout -->