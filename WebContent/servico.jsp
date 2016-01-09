<%@ include file="header.jsp"%>

<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>
<%
	int idServico = Integer.parseInt(request.getParameter("id"));
	
	ServicosDAO servicoDAO = new ServicosDAO();
	Servicos servico = new Servicos();
	servico = servicoDAO.getServicos(idServico);
	
	UsuariosDAO usuarioDAO = new UsuariosDAO();
	Usuario userServico = usuarioDAO.getUsuario(servico.getServFkUsuario());
	
	PessoasDAO pessoaDAO = new PessoasDAO();
	Pessoa pessoaServico = pessoaDAO.getPessoa(servico.getServFkUsuario());
%>
<div class="row">
    <div class="col s12 mg-tp-15 mg-bt-15">
    	<h4 class="blue-grey-text text-lighten-1"><%=servico.getServNome()%></h4>
    </div>
    <div class="col s6">
    	<img class="responsive-img" src="http://dpcpa.com/wp-content/uploads/2015/01/thumbnail-default.jpg"/>
   		<div class="col s6">
    		<blockquote>
		    	<h5 class="blue-grey-text text-lighten-1">
		    		<i class="small material-icons">perm_identity</i> <%=userServico.getLogin()%>
		    	</h5>
		    </blockquote>
   		</div>
   		<div class="col s6">
    		<blockquote>
		    	<h6 class="blue-grey-text text-lighten-1">
		    		<i class="small material-icons ">contact_phone</i> <%=pessoaServico.getPessoaTelefone()%>
		    	</h6>	
		    </blockquote>
   		</div>
    </div>
    <div class="col s6">
    	<div class="row">
			<div class="chip uppercase">
				Aluguel
			</div>
			<div class="chip uppercase">
				Aluguel
			</div>
    		<div class="col s12">
		    	<h3 class="blue-text">
		    		<i class="material-icons">label_outline</i> R$ <%=servico.getServValor()%>
		    	</h3>
    		</div>
    		<div class="col s8">
	    		<blockquote>
			    	<h6 class="blue-grey-text text-lighten-1">
			    		<i class="small material-icons ">assignment</i> DESCRIÇÃO:
			    	</h6>
			    	<p>
			    		<%=servico.getServDescricao()%>
			    	</p>
			    </blockquote>
    		</div>
    	</div>
    </div>
</div>
<%@ include file="footer.jsp"%>