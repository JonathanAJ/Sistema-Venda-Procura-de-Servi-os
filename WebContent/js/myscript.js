$(document).ready(function(){
	// Preparando modal
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
    
    //Login
    $("#fazerLogin").click(function(){
    	var bt = $("#fazerLogin");
    	if(!bt.hasClass('disabled')){
        	bt.addClass("disabled");
        	$.ajax({
    		  method: "POST",
    		  url: "Login",
    		  data: {login: "JonathanA", senha: "12345" },
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