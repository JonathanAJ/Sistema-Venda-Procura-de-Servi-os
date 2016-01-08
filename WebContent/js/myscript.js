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
        	
        	if($login.val()==""){
        		$login.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else if($senha.val()==""){
        		$senha.addClass("invalid");
				bt.removeClass("disabled");
				
        	}else{
	        	$.ajax({
	    		  method: "POST",
	    		  url: "Login",
	    		  data: {login: $login.val(), senha: $senha.val()},
	    		  beforeSend: function() {
	    			  
	    		  }
	    		}).done(function( msg ) {
	    			console.log(msg);
	    			if(msg=="1"){
	    				window.location.href = "principal.jsp";
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
        	var $pessoaTipo = $('#pessoaTipo');
        	var $pessoaDoc = $('#pessoaDoc');
        	var $pessoaCep = $('#pessoaCep');
        	var $pessoaBairro = $('#pessoaBairro');
        	var $pessoaEstado = $('#pessoaEstado option:selected');
        	var $pessoaCidade = $('#pessoaCidade option:selected');
        	$pessoaCidade.val();
        	$pessoaEstado.val();
        	console.log($pessoaCidade.val());
        	console.log($pessoaEstado.val());
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
});