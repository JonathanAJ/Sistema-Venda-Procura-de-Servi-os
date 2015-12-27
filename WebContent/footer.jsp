		<!-- Modal Structure Login-->
		<div id="loginModal" class="modal">
			<div class="modal-content">
				<h3 class="center-align">Login</h3>
				<div class="row">
					<div class="divider"></div>
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
	</div> <!-- Fim container --> 
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="materialize/js/materialize.min.js"></script>
	<script src="js/myscript.js"></script>
</body>
</html>