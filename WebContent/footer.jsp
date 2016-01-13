<%@ page import="com.projeto.model.*" %>
<%
	Cookie[] cc = request.getCookies();
	String login = "";
	String senha = "";
	String lembrar = "false";
	
	if(cc.length>1){
		login  = cc[1].getValue();
		senha  = cc[2].getValue();
		lembrar  = cc[3].getValue();
	}
%>
		<!-- Modal Estrutura Login-->
		<div id="loginModal" class="modal">
			<div class="modal-content">
  				<h4 class="indigo-text text-lighten-2 center-align">Login</h4>
				<div class="row">
					<div class="divider mg-bt-20"></div>
					<form class="col s10 offset-s1" method="POST" action="Login">
						<div class="row">
							<div class="input-field col s12 blue-text">
								<i class="material-icons prefix">account_circle</i>
								<input id="login" type="text"
									   class="validate" name="login"
									   value="<%=login%>">
								<label for="login" data-error="Login inválido!">Login</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12 blue-text">
								<i class="material-icons prefix">vpn_key</i>
								<input id="senha" type="password"
									   class="validate" name="senha"
									   value="<%=senha%>">
								<label for="senha" data-error="Senha inválida!">Senha</label>
							</div>
							<div class="input-field col s12 blue-text">
						      <input id="lembrarLogin" type="checkbox" <%=(lembrar.equals("false"))?"":"checked" %>/>
						      <label for="lembrarLogin">Lembrar-me depois</label>
							</div>
						</div>
					</form>
				</div>
				<div class="row center-align">
		            <p>
		                <a href="#" class="btn waves-effect waves-light red modal-close mg-tp-15">Cancelar<i class="material-icons right">not_interested</i></a>
		                <a id="fazerLogin" href="#" class="btn waves-effect waves-light blue mg-tp-15">Entrar<i class="material-icons right">send</i></a>
		            </p>
				</div>
			</div>
		</div>
		
		<!-- Modal Estrutura Cadastrar-->
		<div id="cadastrarModal" class="modal">
			<div class="modal-content">
  				<h4 class="indigo-text text-lighten-2 center-align">Cadastre-se</h4>
				<div class="row">
					<div class="divider mg-bt-20"></div>
					<form id="formCadastroUsuario" class="col s10 offset-s1" method="POST" action="UsuarioController">
						<div class="row">
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">account_circle</i>
								<input id="cadastroLogin" type="text" class="validate" name="cadLogin" required>
								<label for="cadastroLogin" data-error="Usuário inválido, tente outro">Login</label>
							</div>
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">email</i>
								<input id="cadastroEmail" type="email" class="validate" name="cadEmail" required>
								<label for="cadastroEmail" data-error="E-mail inválido!">E-mail</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">vpn_key</i>
								<input id="cadastroSenha" type="password" class="validate" name="cadSenha" required>
								<label for="cadastroSenha" data-error="Senha inválida!">Senha</label>
							</div>
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">replay</i>
								<input id="confirmaSenha" type="password" class="validate" name="confirmaCadSenha"  required>
								<label for="confirmaSenha" data-error="Senhas não conferem">Confirmar Senha</label>
							</div>
						</div>
					</form>
				</div>
				<div class="divider"></div>
				<div class="row center-align">
		            <p>
		                <a href="#" class="btn waves-effect waves-light red modal-close mg-tp-15">Cancelar<i class="material-icons right">not_interested</i></a>
		                <a id="cadastrarUsuario" href="#" class="btn waves-effect waves-light blue mg-tp-15">Cadastrar<i class="material-icons right">send</i></a>
		            </p>
				</div>
			</div>
		</div>
		<%
			int num = (int) this.getServletContext().getAttribute("Online");
		%>
		<!-- Modal Estrutura Sobre-->
		<div id="loginSobre" class="modal">
			<div class="modal-content">
  				<h4 class="indigo-text text-lighten-2 center-align">Sobre</h4>
				<div class="row">
					<div class="divider mg-bt-20"></div>
					<div class="valign-wrapper">
						<p class="valign just pd-lf-20 pd-rg-20">	O Sistema <strong>ServLiber</strong> é um sistema de vendas e busca de serviços.
							Idealizado para a disciplina de <strong>Programação Web I</strong> ministrada pelo professor
							Leonardo Moreira. O Sistema está sendo construído utilizando a poderosa linguagem
							Java voltada para web. Utilizamos diversas tecnologias para compor o sistema, que atualmente
							encontra-se com <strong><%=num %></strong> sessões de usuários no contexto da aplicação.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div> <!-- Fim container --> 
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="materialize/js/materialize.min.js"></script>
	<script src="js/myscript.js"></script>
</body>
</html>