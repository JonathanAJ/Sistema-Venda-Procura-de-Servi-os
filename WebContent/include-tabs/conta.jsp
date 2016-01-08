<div class="row">
    <form class="col s122">
      <div class="row">
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="pessoaNome" type="text" class="validate">
          <label for="pessoaNome">Nome Completo:</label>
        </div>
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="pessoaEmail" type="email" class="validate">
          <label for="pessoaEmail">E-mail:</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">contact_phone</i>
          <input id="pessoaTelefone" type="text" class="validate">
          <label for="pessoaTelefone">Telefone:</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="pessoaSexo">
		      <option value="" disabled selected>Selecione</option>
		      <option value="Masculino">Masculino</option>
		      <option value="Feminino">Feminino</option>
		    </select>
		    <label>Sexo</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="pessoaTipo">
		      <option value="0" disabled selected>Selecione</option>
		      <option value="1">Física</option>
		      <option value="2">Jurídica</option>
		    </select>
		    <label>Tipo de Pessoa</label>
        </div>
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">assignment</i>
          <input id="pessoaDoc" type="text" class="validate">
          <label for="pessoaDoc">CPF/CNPJ:</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">room</i>
          <input id="pessoaCep" type="text" class="validate">
          <label for="pessoaCep">CEP:</label>
        </div>
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">turned_in_not</i>
          <input id="pessoaBairro" type="text" class="validate">
          <label for="pessoaBairro">Bairro:</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="pessoaEstado">
		      <option value="0" disabled selected>Selecione</option>
		      <option value="1">Ceará</option>
		      <option value="2">São Paulo</option>
		    </select>
		    <label>Estado</label>
		</div>
        <div class="input-field col s12 m3">
		    <select id="pessoaCidade" disabled>
		      <option value="0" disabled selected>Selecione</option>
		      <option value="1">Fortaleza</option>
		      <option value="2">Caucaia</option>
		    </select>
		    <label>Cidade</label>
		</div>
      </div>
    </form>
	<div class="row">
		<div class="col s12">
			<a id="cadastrarPessoa" class="btn waves-effect waves-light blue align-right">
				Salvar alterações
				<i class="material-icons right">send</i>
			</a>
		</div>
	</div>
  </div>