<div class="row">
    <form id="formCriaServico" class="col s12">
      <div class="row">
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">loyalty</i>
          <input id="servicoNome" type="text" maxlength="80">
          <label for="servicoNome" data-error="Mínimo 10 dígitos">Nome do Serviço:</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="servicoCateg1">
		      <option value="0" disabled selected>Selecione *</option>
		      <option value="1">Estética</option>
		      <option value="2">Esportes</option>
		    </select>
		    <label data-error="Obrigatório">Categoria 1</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="servicoCateg2">
		      <option value="0" disabled selected>Selecione</option>
		      <option value="3">Educação</option>
		      <option value="4">Eventos</option>
		    </select>
		    <label>Categoria 2</label>
        </div>
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">contact_phone</i>
          <input id="servicoValor" type="text"  >
          <label for="servicoValor" data-error="Valor inválido">Valor:</label>
        </div>
	    <div class="file-field input-field col s12 m6">
	      <div class="btn">
	        <span>Imagem</span>
	        <input type="file">
	      </div>
	      <div class="file-path-wrapper">
	        <input id="servicoImg" class="file-path validate" type="text">
	      </div>
	    </div>
        <div class="input-field col s12">
          <i class="material-icons prefix">assignment</i>
          <textarea id="servicoDescricao" class="materialize-textarea" maxlength="100" length="100"></textarea>
          <label for="servicoDescricao" data-error="Mínimo 25 dígitos">Descrição do Serviço:</label>
        </div>
      </div>
    </form>
	<div class="row">
		<div class="col s12">
			<a id="cadastrarServico" class="btn waves-effect waves-light blue align-right">
				Criar novo Serviço
				<i class="material-icons right">send</i>
			</a>
		</div>
	</div>
  </div>