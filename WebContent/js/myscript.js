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
	    				Materialize.toast('Login ou senha incorreto tente novamente!', 4000)
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
	    		  data: {login: $cadastroLogin.val(),
	    			  	 senha: $cadastroSenha.val(),
	    			  	 email: $cadastroEmail.val()},
	    		  beforeSend: function() {
	    			  
	    		  }
	    		}).done(function( msg ) {
	    			console.log(msg);
	    			if(msg=="1"){
	    				Materialize.toast('Usuário '+$cadastroLogin.val()+' foi cadastrado com sucesso!', 4000)
	    			}else{
	    				bt.removeClass("disabled");
	    				$cadastroLogin.addClass("invalid");
	    			}
	        	});
        	}
    	}
    });
});