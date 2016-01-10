<%@page import="com.projeto.dao.*" %>
<%@page import="com.projeto.model.*" %>
<%@page import="java.util.*"%>
<%
	/*
	 * Retornando os dados do usu�rio que est� logado
	 */
	PessoasDAO pessoaDao = new PessoasDAO();
	Usuario userConta = (Usuario) session.getAttribute("Usuario");
	Pessoa pessoa = pessoaDao.getPessoa(userConta.getUserPkId());
%>
<div class="row">
    <form class="col s12">
      <div class="row">
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="pessoaNome" type="text" class="validate" value="<%=pessoa.getPessoaNomeCompleto()%>">
          <label for="pessoaNome">Nome Completo:</label>
        </div>
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="pessoaEmail" type="email" class="validate" value="<%=pessoa.getPessoaEmail()%>">
          <label for="pessoaEmail">E-mail:</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">contact_phone</i>
          <input id="pessoaTelefone" type="text" class="validate" value="<%=pessoa.getPessoaTelefone()%>">
          <label for="pessoaTelefone">Telefone:</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="pessoaSexo">
		      <%
		      	String sexo = pessoa.getPessoaSexo();
		      %>
		      <option value="" disabled <%=(sexo.equals(""))?"selected":""%>> Selecione
		      </option>
		      <option value="Masculino" <%=(sexo.equals("Masculino"))?"selected":""%>> Masculino
		      </option>
		      <option value="Feminino" <%=(sexo.equals("Feminino"))?"selected":""%>> Feminino
		      </option>
		    </select>
		    <label>Sexo</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="pessoaTipo">
		      <%
		      	Short pessoaT = pessoa.getPessoaTipo();
		      %>
		      <option value="0" disabled <%=(pessoaT==0)?"selected":""%>> Selecione
		      </option>
		      <option value="1" <%=(pessoaT==1)?"selected":""%>> F�sica
		      </option>
		      <option value="2" <%=(pessoaT==2)?"selected":""%>> Jur�dica
		      </option>
		    </select>
		    <label>Tipo de Pessoa</label>
        </div>
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">assignment</i>
          <input id="pessoaDoc" type="text" class="validate" value="<%=pessoa.getPessoaDoc()%>">
          <label for="pessoaDoc">CPF/CNPJ:</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">room</i>
          <input id="pessoaCep" type="text" class="validate" value="<%=pessoa.getPessoaCep()%>">
          <label for="pessoaCep">CEP:</label>
        </div>
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">turned_in_not</i>
          <input id="pessoaBairro" type="text" class="validate" value="<%=pessoa.getPessoaBairro()%>">
          <label for="pessoaBairro">Bairro:</label>
        </div>        
		<%
			/*
			 * Retornando os Estados e Cidades
			 */
		%>
        <div class="input-field col s12 m3">
		    <select id="pessoaEstado">
		    	<option value="0">Selecione</option>
		      <%
				EstadosDAO estadoDao = new EstadosDAO();
				List<Estado> estado = estadoDao.getEstados();
				Iterator<Estado> iEstado = estado.iterator();
				while(iEstado.hasNext()){
				  Estado estadoIterator = (Estado) iEstado.next();
				  long estPkId = estadoIterator.getEstadoPkId();
				  String estSigla = estadoIterator.getEstadoSigla();
				  String estNome = estadoIterator.getEstadoNome();
				  String selectedE = (estPkId==pessoa.getPessoaFkEstado())?" selected":"";
		      %>
			      <option value="<%=estPkId%>"<%=selectedE%>>(<%=estSigla%>) <%=estNome%></option>
		      <%
				}
		      %>
		    </select>
		    <label>Estado</label>
		</div>
        <div class="input-field col s12 m3">
		    <select id="pessoaCidade">
		    	<option value="0">Selecione</option>
		      <%
				CidadesDAO cidadeDao = new CidadesDAO();
				List<Cidade> cidade = cidadeDao.getCidades();
				Iterator<Cidade> iCidade = cidade.iterator();
				while(iCidade.hasNext()){
				  Cidade cidadeIterator = (Cidade) iCidade.next();
				  long cidPkId = cidadeIterator.getCidPkId();
				  String cidNome = cidadeIterator.getCidNome();
				  String selectedC = (cidPkId==pessoa.getPessoaFkCidade())?" selected":"";
		      %>
			      <option value="<%= cidPkId %>"<%=selectedC%>><%= cidNome %></option>
		      <%
				}
		      %>
		    </select>
		    <label>Cidade</label>
		</div>
      </div>
    </form>
	<div class="row">
		<div class="col s12">
			<a id="cadastrarPessoa" class="btn waves-effect waves-light blue align-right">
				Salvar altera��es
				<i class="material-icons right">send</i>
			</a>
		</div>
	</div>
  </div>