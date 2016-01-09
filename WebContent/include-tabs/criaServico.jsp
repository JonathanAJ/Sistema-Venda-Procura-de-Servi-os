<div class="row">
    <form class="col s122">
      <div class="row">
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="servicoNome" type="text">
          <label for="servicoNome">Nome do Serviço:</label>
        </div>
        <div class="input-field col s12 m6">
          <i class="material-icons prefix">account_circle</i>
          <textarea id="servicoDescricao"></textarea>
          <label for="servicoDescricao">Descrição do Serviço:</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12 m3">
          <i class="material-icons prefix">contact_phone</i>
          <input id="servicoValor" type="text"  >
          <label for="servicoValor">Valor:</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="servicoCateg1">
		      <option value="" disabled selected>Selecione</option>
		      <option value="1">Estética</option>
		      <option value="2">Esportes</option>
		    </select>
		    <label>Categoria 1</label>
        </div>
        <div class="input-field col s12 m3">
		    <select id="servicoCateg2">
		      <option value="" disabled selected>Selecione</option>
		      <option value="3">Educação</option>
		      <option value="4">Eventos</option>
		    </select>
		    <label>Categoria 2</label>
        </div>
      </div>
    </form>
	<div class="row">
		<div class="col s12">
			<a id="cadastrarServico" class="btn waves-effect waves-light blue align-right">
				Salvar alterações
				<i class="material-icons right">send</i>
			</a>
		</div>
	</div>
  </div>