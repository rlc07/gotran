
 /*Filtro de busca aluguel*/

 function filtrarEscolar(){

	  var dados = $("#fmFiltroEscolar").serialize();
	  $.ajax({
		  
		  type: "GET",
		  url: "buscar?action=buscar-anuncio-escolar",
		  data: dados,
		  success: function (data){

		  }
	  
	  });

	  return false;
 }
 /*Filtro de busca aluguel*/

 function filtrarAluguel(){

	  var dados = $("#fmFiltroAluguel").serialize();
	  $.ajax({
		  
		  type: "GET",
		  url: "buscar?action=buscar-anuncio-aluguel",
		  data: dados,
		  success: function (data){

		  }
	  
	  });

	  return false;
 }
 
 function filtrarFrete(){

	  var dados = $("#fmFiltroFrete").serialize();
	  $.ajax({
		  
		  type: "GET",
		  url: "buscar?action=buscar-anuncio-frete",
		  data: dados,
		  success: function (data){

		  }
	  
	  });

	  return false;
}
 
 function filtrarExcursao(){

	  var dados = $("#fmFiltroExcursao").serialize();
	  $.ajax({
		  
		  type: "GET",
		  url: "buscar?action=buscar-anuncio-excursao",
		  data: dados,
		  success: function (data){

		  }
	  
	  });

	  return false;
}

/*Redirecionar loja apk*/

function Chat(){	

	bootbox.confirm({
		size: "small",
	    message: "Para usar o chat é necessario baixar nosso aplicativo <span class='fa fa-android'></span>",

	    buttons: {
	        confirm: {
	            label: 'Ir para loja',
	            className: 'btn-success'
	            
		            
	        },
	        cancel: {
	            label: 'Voltar',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {

	    	if(result == true){

	    		location = "https://play.google.com/store?hl=pt_BR";
	    	}
	    }
	});


	}



function fazerLogin(){
	window.open("login.jsp")
}
	
/*Recuperar senha*/

$(document).ready(function(){
	
	$("#fmModalRecuperaSenha").validate({
		
		rules:{
			email_recuperar:{
				
				required: true,
				email:true,
			    remote: './publico/buscador/verifica_email_recupera_senha.jsp'				
			}
		},
		
		messages: {
                 
			email_recuperar:{				
				required: "O campo deve ser preenchido",
				email:"Informe um email valido",
			    remote: 'Email nao cadastrado no sistema'				
			}
		},
		submitHandler: function( form ){
			var dados = $("#fmModalRecuperaSenha").serialize();
		      $("#carrega_email").html('<div align="center"><img src="resources/img/img-icone/carregando.gif" style="width: 90px;" /></div>');

			$.ajax({
				type: "POST",
				url: "buscar?action=recuperar-senha",
				data: dados,
				success: function( data )
				{
					 bootbox.alert({ 
						  size: "small",
						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
						  		"<b>GO</b>TRAN </div>",
						  message: "<div  class='alert alert-success' align='center'>Confira seu email</div>", 
						  callback: function(){ /* your callback code */ 
							  
							 

								 document.getElementById("fmModalRecuperaSenha").reset();
								 var url = "login.jsp";    
						    	   $(location).attr('href',url);

						  }
						});
				}
			});

			return false;
		}
		
	});
	
});

function enviarrecuperacao(){
	
	var nsenha = $("#nsenha").val();
	var codigo = $("#codigo").val();
	var email = $("#email").val();
	
	if(nsenha == "" || nsenha == null && codigo == "" || codigo == null && email == "" || email == null){
		alert("preencha")
	}else{
		
		if(nsenha.length < 4 || nsenha.length > 10){
			alert("senha tem q ser maior q 4")
		}else{
			alert("rec")
		}
	}

}
/*Recuperar senha*/

$(document).ready(function(){
	
	$("#fmRecuperarSenha").validate({
		
		rules:{
			nsenha:{
				required: true,
				rangelength: [4,10]
			},
		
			codigo:{
				required: true
			},
			email:{
				required: true,
				email: true
			}
		},
		
		messages: {
                 
			nsenha:{				
				required: "O campo deve ser preenchido",
  		    	rangelength: "A senha deve conter entre 4 a 10 caracteres."

			},
			email:{				
				required: "O campo deve ser preenchido",
				email: "Informe um email valido"
			},
			codigo:{				
				required: "O campo deve ser preenchido"				
			}
		},
		submitHandler: function( form ){

				
			var url="";
 	
 		 url = "buscar?action=nova-senha";
	 	   $(location).attr('href',url);
 	  


		}
		
	});
	
});








