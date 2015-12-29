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
        	var senha = $('#senha').val();
        	var login = $('#login').val();
        	$.ajax({
    		  method: "POST",
    		  url: "Login",
    		  data: {login: login, senha: senha},
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
    });
});