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
								<input id="login" type="text" class="validate" name="login">
								<label for="login">Login</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12 blue-text">
								<i class="material-icons prefix">vpn_key</i>
								<input id="senha" type="password" class="validate" name="senha">
								<label for="senha">Senha</label>
							</div>
						</div>
					</form>
				</div>
				<div class="divider"></div>
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
					<form class="col s10 offset-s1" method="POST" action="UsuarioController">
						<div class="row">
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">account_circle</i>
								<input id="cadastroLogin" type="text" class="validate" name="login">
								<label for="cadastroLogin">Login</label>
							</div>
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">email</i>
								<input id="email" type="email" class="validate" name="email">
								<label for="email">E-mail</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">vpn_key</i>
								<input id="cadastroSenha" type="password" class="validate" name="senha">
								<label for="cadastroSenha">Senha</label>
							</div>
							<div class="input-field col s6 blue-text">
								<i class="material-icons prefix">replay</i>
								<input id="confirmaSenha" type="password" class="validate" name="confirmaSenha">
								<label for="confirmaSenha">Confirmar Senha</label>
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
	</div> <!-- Fim container --> 
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="materialize/js/materialize.min.js"></script>
	<script src="js/myscript.js"></script>
</body>
</html>