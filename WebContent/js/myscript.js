$(document).ready(function(){
	// Inicializando Modal Materialize
    $('.modal-trigger').leanModal();
    // Inicializando Select Materialize
    $('select').material_select();
    
    //Fazendo login
    $("#fazerLogin").click(function(){
    	var bt = $("#fazerLogin");

    	if(!bt.hasClass('disabled')){
        	bt.addClass("disabled");
        	var $senha = $('#senha');
        	var $login = $('#login');
        	var $favoritoId = $favoritoId = $("#pegarFavorito").attr("data-id-servico");
        	var $lembrarLogin = $('#lembrarLogin').is(':checked');
        	console.log($lembrarLogin);
        	
        	if($login.val()==""){
        		$login.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($senha.val()==""){
        		$senha.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else{
	        	$.ajax({
	    		  method: "POST",
	    		  url: "UsuarioController",
	    		  data: {acao: "login",
	    			  	 login: $login.val(),
	    			  	 senha: $senha.val(),
	    			  	 lembrar: $lembrarLogin},
	    		  beforeSend: function() {
	    			  
	    		  }
	    		}).done(function( msg ) {
	    			console.log(msg);
	    			if(msg=="1"){
	    				if($favoritoId!=undefined){
		    				window.location.href = "servico.jsp?id="+$favoritoId;
	    				}else{
		    				window.location.href = "principal.jsp";
	    				}
	    			}else{
	    				bt.removeClass("disabled");
	    				Materialize.toast('Login ou senha incorreto tente novamente!', 4000);
	    			}
	        	});
        	}
    	}
    });
    
    //Cadastrar Usuário
    $("#cadastrarUsuario").click(function(){
    	var bt = $("#cadastrarUsuario");
    	if(!bt.hasClass('disabled')){
        	bt.addClass("disabled");
        	var $cadastroLogin = $('#cadastroLogin');
        	var $cadastroEmail = $('#cadastroEmail');
        	var $cadastroSenha = $('#cadastroSenha');
        	var $confirmaSenha = $('#confirmaSenha');
        	
        	if($cadastroLogin.val()==""){
        		$cadastroLogin.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($cadastroEmail.val()==""){
        		$cadastroEmail.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($cadastroSenha.val()==""){
				$cadastroSenha.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($cadastroSenha.val()!=$confirmaSenha.val()){
				$confirmaSenha.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else{
	        	$.ajax({
	    		  method: "POST",
	    		  url: "UsuarioController",
	    		  data: {acao: "criar",
	    			  	 login: $cadastroLogin.val(),
	    			  	 senha: $cadastroSenha.val(),
	    			  	 email: $cadastroEmail.val()},
	    		  beforeSend: function() {
	    			  
	    		  }
	    		}).done(function( msg ) {
	    			if(msg=="1"){
	    				Materialize.toast('Usuário '+$cadastroLogin.val()+' foi cadastrado com sucesso!', 4000);
	    				$('#cadastrarModal').closeModal();
	    				$("#formCadastroUsuario")[0].reset();
	    			}else{
	    				$cadastroLogin.addClass("invalid");
	    			}
    				bt.removeClass("disabled");
	        	});
        	}
    	}
    });
    
    //Cadastrar Pessoa
    $("#cadastrarPessoa").click(function(){
    	var bt = $("#cadastrarPessoa");
    	if(!bt.hasClass('disabled')){
        	bt.addClass("disabled");
        	var $pessoaNome = $('#pessoaNome');
        	var $pessoaEmail = $('#pessoaEmail');
        	var $pessoaTelefone = $('#pessoaTelefone');
        	var $pessoaSexo = $('#pessoaSexo');
        	var $pessoaTipo = $('#pessoaTipo option:selected');
        	var $pessoaDoc = $('#pessoaDoc');
        	var $pessoaCep = $('#pessoaCep');
        	var $pessoaBairro = $('#pessoaBairro');
        	var $pessoaEstado = $('#pessoaEstado option:selected');
        	var $pessoaCidade = $('#pessoaCidade option:selected');
        	$pessoaCidade.val();
        	$pessoaEstado.val();
        	console.log($pessoaCidade.val());
        	console.log($pessoaEstado.val());
        	console.log($pessoaTipo.val());
        	console.log($pessoaSexo.val());
        	
        	$.ajax({
    		  method: "POST",
    		  url: "PessoaController",
    		  data: {acao: "atualizar",
    			  	pessoaNome: $pessoaNome.val(),
    			  	pessoaEmail: $pessoaEmail.val(),
    			  	pessoaTelefone: $pessoaTelefone.val(),
    			  	pessoaSexo: $pessoaSexo.val(),
    			  	pessoaTipo: $pessoaTipo.val(),
    			  	pessoaDoc: $pessoaDoc.val(),
    			  	pessoaCep: $pessoaCep.val(),
    			  	pessoaBairro: $pessoaBairro.val(),
    			  	pessoaEstado: $pessoaEstado.val(),
    			  	pessoaCidade: $pessoaCidade.val()},
    		  beforeSend: function() {
    			  
    		  }
    		}).done(function( msg ) {
    			if(msg=="1"){
    				Materialize.toast('Alterações concluídas com êxito!', 4000);
    			}else{
    				Materialize.toast('Houve algo errado com a execução!', 4000);
    			}
				bt.removeClass("disabled");
        	});
    	}
    });
    
  //Cadastrar Serviço
    $("#cadastrarServico").click(function(){
    	var bt = $("#cadastrarServico");
    	if(!bt.hasClass('disabled')){
        	bt.addClass("disabled");
        	var $servicoNome = $('#servicoNome');
        	var $servicoDescricao = $('#servicoDescricao');
        	var $servicoValor = $('#servicoValor');
        	var $servicoCateg1 = $('#servicoCateg1 option:selected');
        	var $servicoCateg2 = $('#servicoCateg2 option:selected');
        	var $servicoImg = $('#servicoImg');
        	
        	if($servicoNome.val()=="" || $servicoNome.val().length<10){
        		$servicoNome.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($servicoCateg1.val()=="0"){
				bt.removeClass("disabled");
				
        	}else if($servicoValor.val()==""){
        		$servicoValor.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($servicoDescricao.val().length<25){
        		$servicoDescricao.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else{
	        	$.ajax({
	    		  method: "POST",
	    		  url: "ServicoController",
	    		  data: {acao: "criar",
	    			  	 servNome: $servicoNome.val(),
	    			  	 servDescricao: $servicoDescricao.val(),
	    			  	 servValor: $servicoValor.val(),
	    			  	 servCateg1: $servicoCateg1.val(),
	    			  	 servCateg2: $servicoCateg2.val(),
	    			  	 servImagem: $servicoImg.val()},
	    		  beforeSend: function() {
	    			  
	    		  }
	    		}).done(function( msg ) {
	    			if(msg=="1"){
	    				Materialize.toast('Serviço '+$servicoNome.val()+' foi cadastrado com sucesso!', 4000);
	    				$('ul.tabs').tabs('select_tab', 'test2');
	    				$("#formCriaServico")[0].reset();
	    			}else{
	    				Materialize.toast('Houve algo errado com a execução!', 4000);
	    			}
					bt.removeClass("disabled");
	        	});
        	}
    	}
    });
    
  //Cadastrar Favorito
    $("#cadastrarFavorito").click(function(){
    	var bt = $("#cadastrarFavorito");
    	if(!bt.hasClass('disabled')){
        	bt.addClass("disabled");
        	var $favoritoId = bt.attr("data-id-servico");
        	$.ajax({
    		  method: "POST",
    		  url: "FavoritoController",
    		  data: {acao: "favoritar",
    			  	 favoritoId: $favoritoId},
    		  beforeSend: function() {
    			  
    		  }
    		}).done(function( msg ) {
    			if(msg=="1"){
    				Materialize.toast('Esse serviço foi adicionado aos seus favoritos', 4000);
    				bt.attr("data-tooltip", "Você já favoritou esse serviço!");
    			}else{
    				Materialize.toast('Houve algo errado com a execução!', 4000);
    			}
        	});
    	}
    });
});