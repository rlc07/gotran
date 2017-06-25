var vaga_dis = "";
var tel_cel = "";
var tel_fixo = "";


  function editarAnuncioEscolar(idAnuncio,idUsuario){
	  lacation = "main?action=editar_anuncio_escolar&id_anuncio="+idAnuncio+"&id_usuario="+idUsuario;
	
  }

/*Redirecionar botao anunciar ou buscar*/




function salvarTelefone(){
	
	   var tfinput = $("#fone_fixoAnuncio").val();
	   var tcinput = $("#fone_celAnuncio").val();
	   
	   if(tfinput == "" && tcinput == ""){
		   bootbox.alert({ 
			   size: "small",
			   title: "<b>GO</b>TRAN",
			   message: "<h4>Preencha um dos telefones!</h4>", 
			   callback: function(){ /* your callback code */ }
			 })	   
			 
	   } else{
		   
		   var dados = $("#fmModalTelefone").serialize();
			  $.ajax({
				  
				  type: "POST",
				  url: "main?action=minha-conta/",
				  data: dados,
				  success: function (data){
					  bootbox.alert({ 
						  size: "small",
						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
						  		"<b>GO</b>TRAN </div>",
						  message: "<div  class='alert alert-success' align='center'>Salvo com sucesso!</div>", 
						  callback: function(){ 
							    $('#modalTelefone').modal('toggle');
							    $('#veiculo').val("");
							    $('#marca').val("");
							    $('#modelo').val("");
				                $('#img_veiculo').attr('src', 'resources/img/img-icone/sem_foto.jpg');


						  }
						});
				  }
			  
			  });
	   }

	  
}
  
function redirecionarLogin(){
	location="login.jsp"
}

function redirecionarBuscar(){
	location="publico/buscador/buscar_transporte.jsp"
}




function redirecionarMeusVeiculos(){

      location= 'meus_veiculos.jsp'
      
}



function redirecionarMinhaConta(){
location = "main?action=minha-conta/"

}

function voltarMyVeiculo(idUsuario){
	location = "main?action=meus-veiculos&id_usuario="+idUsuario;
}

function voltarMyAnuncio(idUsuario){
	location = "main?action=meus-anuncios&id_usuario="+idUsuario;
}

function cepCorreio(){
	window.open("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaCepEndereco.cfm")
}

function apagarVeiculo(idVeiculo, idUsuario){	

	bootbox.confirm({
		size: "small",
	    message: "Deseja excluir esse veiculo? <span class='fa fa-trash'></span>",

	    buttons: {
	        confirm: {
	            label: 'Sim',
	            className: 'btn-success'
	            
		            
	        },
	        cancel: {
	            label: 'Cancelar',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {

	    	if(result == true){
	    		$.ajax({
	    			type: "POST",
	    			url: "main?action=remover-veiculo&id_veiculo="+idVeiculo,
	    			success: function(  )
	    			{
	    				location="main?action=meus-veiculos&id_usuario="+idUsuario;
	    	    		 

	    			}
	    		});
	    	}
	    }
	});


	
	
}




function deletarAnFrete(idAnuncio){	

	bootbox.confirm({
		size: "small",
	    message: "Deseja excluir esse anuncio? <span class='fa fa-trash'></span>",

	    buttons: {
	        confirm: {
	            label: 'Sim',
	            className: 'btn-success'
	            
		            
	        },
	        cancel: {
	            label: 'Cancelar',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {

	    	if(result == true){
	    		$.ajax({
	    			type: "POST",
	    			url: "main?action=remover-anuncio-frete&id_anuncio="+idAnuncio,
	    			success: function(  )
	    			{
	    				window.location.reload();
	    				$("#selectAnuncio").val("");


	    			}
	    		});
	    	}
	    }
	});


	}

function deletarAnExcursao(idAnuncio){	
	bootbox.confirm({
		size: "small",
	    message: "Deseja excluir esse anuncio? <span class='fa fa-trash'></span>",

	    buttons: {
	        confirm: {
	            label: 'Sim',
	            className: 'btn-success'
	            
		            
	        },
	        cancel: {
	            label: 'Cancelar',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {

	    	if(result == true){
	    		$.ajax({
	    			type: "POST",
	    			url: "main?action=remover-anuncio-excursao&id_anuncio="+idAnuncio,
	    			success: function(  )
	    			{
	    				window.location.reload();
	    				$("#selectAnuncio").val("");

	    	    		 

	    			}
	    		});
	    	}
	    }
	});


	}
function deletarAnEscolar(idAnuncio){	
	bootbox.confirm({
		size: "small",
	    message: "Deseja excluir esse anuncio? <span class='fa fa-trash'></span>",

	    buttons: {
	        confirm: {
	            label: 'Sim',
	            className: 'btn-success'
	            
		            
	        },
	        cancel: {
	            label: 'Cancelar',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {

	    	if(result == true){
	    		$.ajax({
	    			type: "POST",
	    			url: "main?action=remover-anuncio-escolar&id_anuncio="+idAnuncio,
	    			success: function(  )
	    			{
	    				window.location.reload();
	    				$("#selectAnuncio").val("");
	    	    		 

	    			}
	    		});
	    	}
	    }
	});

	
	}
function deletarAnAluguel(idAnuncio){	
	
	bootbox.confirm({
		size: "small",
	    message: "Deseja excluir esse anuncio? <span class='fa fa-trash'></span>",

	    buttons: {
	        confirm: {
	            label: 'Sim',
	            className: 'btn-success'
	            
		            
	        },
	        cancel: {
	            label: 'Cancelar',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {

	    	if(result == true){
	    		$.ajax({
	    			type: "POST",
	    			url: "main?action=remover-anuncio-aluguel&id_anuncio="+idAnuncio,
	    			success: function(  )
	    			{
	    				window.location.reload();
	    				$("#selectAnuncio").val("");

	    	    		 

	    			}
	    		});
	    	}
	    }
	});

	}





/*Alterar foto do perfil*/
$("form#foto").submit(function(event){
	 
	  event.preventDefault();
	   var formData = new FormData($(this)[0]);
	 
	  $.ajax({
    url: 'uploadImagem',
	    type: 'POST',
	    data: formData,
	    async: false,
	    cache: false,
	    contentType: false,
	    processData: false,
	    success: function (returndata) {
        location.reload();
	    }
	  });
	 
	  return false;
	});



/*Validar campos do cadastro de usuario*/
$(document).ready( function(){ 
	  
	  $("#fmCadUsu").validate({ 
		  
		  rules:{
			  nome_cadastro:{
				  required: true,
				  minlength: 3
			  },
			  
			  snome_cadastro:{
				  required: true,
			  },
			  
			  
			  email_cadastro:{
				  required: true,
				  email: true,
				  remote: './publico/buscador/verifica_email_cadastro.jsp'
				  },
			  
			  senha_cadastro:{
				  required: true,
				  rangelength: [4,10]
			  },
			  
			  senha2_cadastro:{
				  required: true,
				  equalTo: "#senha2_cadastro_id"
				  
			  }
			  
		  },
		  
		  messages: {
			  
			  nome_cadastro:{
				  required: "Campo obrigatorio!",
				  minlength: "O nome deve conter no minimo 3 caracteres"
			  },
			  
			  snome_cadastro:{
				  required: "Campo obrigatorio!",
			  },
			  
			  
			  email_cadastro:{
				  required: "Campo obrigatorio!",
				  email: "Informe um email valido." +
				  		" Ex. (gotran@email.com)",
				  remote: "Ja existe uma conta vinculada a este email."
			  },
			  
			  senha_cadastro:{
				  required: "Campo obrigatorio!",
				  rangelength: "A senha deve conter entre 4 a 10 caracteres"
			  },
			  
			  senha2_cadastro:{
				  required: "Campo obrigatorio!",
				  equalTo: "Informe a mesma senha digitada anteriormente."
				  
			  }
			  
		  },
		  errorElement: "em",
			errorPlacement: function ( error, element ) {
				// Add the `help-block` class to the error element
				error.addClass( "help-block" );

				// Add `has-feedback` class to the parent div.form-group
				// in order to add icons to inputs
				element.parents( ".col-sm-12" ).addClass( "has-feedback" );

				if ( element.prop( "type" ) === "checkbox" ) {
					error.insertAfter( element.parent( "label" ) );
				} else {
					error.insertAfter( element );
				}

				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !element.next( "span" )[ 0 ] ) {
				}
			},
			success: function ( label, element ) {
				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !$( element ).next( "span" )[ 0 ] ) {
				}
			},
			highlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-12" ).addClass( "has-error" ).removeClass( "has-success" );
			},
			unhighlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-12" ).addClass( "has-success" ).removeClass( "has-error" );
			},
			submitHandler: function( form ){
				var dados = $("#fmCadUsu").serialize();

				$.ajax({
					type: "POST",
					url: "buscar?action=cadastrar-usuario",
					data: dados,
					success: function( data )
					{
						 bootbox.alert({ 
							  size: "small",
							  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
							  		"<b>GO</b>TRAN </div>",
							  message: "<div  class='alert alert-success' align='center'>Cadastrado com sucesso!</div>", 
							  callback: function(){ /* your callback code */ 
								  
									 document.getElementById("fmCadUsu").reset();

							  }
							});
					}
				});

				return false;
			}
		  
	  });
	  
});

/*VALIDAR INPUT SOMENTE COM LETRAS*/
jQuery('#nome_cadastro').keyup(function () { 
    this.value = this.value.replace(/[^a-zA-Z]/g,'');
});
jQuery('#nome_atualizacao').keyup(function () { 
    this.value = this.value.replace(/[^a-zA-Z]/g,'');
});

jQuery('#snome_atualizacao').keyup(function () { 
    this.value = this.value.replace(/[^a-zA-Z]/g,'');
});

jQuery('#titulo').keyup(function () { 
    this.value = this.value.replace(/[^a-z A-Z]/g,'');
});

jQuery('#vaga_escolar').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#n').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#cargat').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#carga').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#vaga_escolar').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#ano_veiculo').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#qtd_assento').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

jQuery('#cep').keyup(function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

/*Formatar input moeda*/
$(document).ready(function(){
    $("#valor").maskMoney({showSymbol:true, symbol:"R$", decimal:".", thousands:"."});
});



/*Validar e redirecionar - LOGIN*/
$('document').ready(function()
		  { 
		       /* validation */
		    $("#formLogin").validate({
		        rules:
		     {
		     senha_login: {
		    	 required: true,
		    	 rangelength: [4,10]
		     
		     },
		     email_login: {
		              required: true,
		              email: true
		              },
		      },
		         messages:{
		              senha_login:{
		                        required: "Campo obrigatorio!",
		           		    	 rangelength: "A senha deve conter entre 4 a 10 caracteres."

		                       },
		              email_login: {
		            	  required: "Campo obrigatorio!",
				    	 email: "Email invalido"
		         },
		         },
		      submitHandler: submitForm 
		         });  
		   

		      /* login submit */
		      function submitForm()
		      {  
			      $("#carrega").html('<div align="center"><img src="resources/img/img-icone/carregando.gif" style="width: 90px;" /></div>');

		     var data = $("#formLogin").serialize();
		     var email = $("#email_login").val();

		     $.ajax({
		      
		     type : 'POST',
		     url  : 'login',
		     data : data,
		     beforeSend: function()
		     { 
		      $("#erro-login").fadeOut();
		      $("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
		  	document.getElementById('carrega').style.display = "block";

		     },
		     
		     success :  function(response)
		        {   
		    	 
		       if(response=="true"){
		    	   var url = "main?action=minha-conta/";    
		    	   $(location).attr('href',url);
		    	   
		    		$.ajax({
		    			type: "POST",
		    			url: "main?action=verificar-anuncio&email="+email,
		    			success: function(  )
		    			{
		    			
		    			}
		    		});
		    	   
		    	   
		    	   console.log(email);
		  
		        
		       }
		       else{
		        $("#erro-login").fadeIn(1000, function(){      
		      $("#erro-login").html('<div class="alert alert-danger"><b style="color:red;">email ou senha invalido</b> &nbsp; '+response+' </div>');
		             $("#btn-login").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
				      $("#carrega").html('<div></div>');
		           });
		       }
		       }
		     });
		      return false;
		    }
		      /* login submit */
		  });

/*INICIO SCRIPT ATUALIZACAO USUARIO/*/

$(document).ready(function(){
	  
	  $("#fmAtuUsu").validate({
		  
		  rules:{
			  nome_atualizacao:{
				  required: true,
				  rangelength: [3,15]
			  },
			  snome_atualizacao:{
	        	  required: true,
				  rangelength: [3,30]

	          }
			  
		  },
		  messages:{
			  nome_atualizacao:{
				  required: "Campo obrigatorio",
			      rangelength: "O nome deve ter entre 3 á 15 caracteres!"

			  },
			  snome_atualizacao:{
	        	  required:"Campo obrigatorio",
			      rangelength: "O nome deve ter entre 3 á 30 caracteres!"

	          }
			  
		  },
		  submitHandler: function(form){
			  
			  var dados = $("#fmAtuUsu").serialize();
			  $.ajax({
				  
				  type: "POST",
				  url: "main?action=minha-conta/",
				  data: dados,
				  success: function (data){
					  bootbox.alert({ 
						  size: "small",
						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
						  		"<b>GO</b>TRAN </div>",
						  message: "<div  class='alert alert-success' align='center'>Atualizado com sucesso!</div>", 
						  callback: function(){ /* your callback code */ 
							  
								location.reload();

						  }
						});
				  }
			  
			  });

			  return false;
		  }
		  
		  
	  });
	  
});


/*VALIDAR ALTERAÇÂO DE SENHA */

   $(document).ready(function(){
	   
	   $("#fmModalSenha").validate({
		   
		   rules:{
			   
			   nova_senha_modal:{
				   required:true,
				   rangelength: [4,10]
			   },
	   
	          atual_senha_modal:{
	        	  required: true,
				   rangelength: [4,10]

	          },
	          
	          atual_senha_modal2:{
	        	  required: true,
				  equalTo: "#sw_modal"

	          }
		   },
	   
	   messages:{
		   nova_senha_modal:{
			   required:"Campo obrigatorio!",
			   rangelength: "A senha deve conter entre 4 a 10 caracteres"

		   },
   
          atual_senha_modal:{
        	  required:"Campo obrigatorio!",
			   rangelength: "A senha deve conter entre 4 a 10 caracteres"
          },
          
          atual_senha_modal2:{
        	  required:"Campo obrigatorio!",
			  equalTo: "Senha diferente da atual"
				

          }
	   },
	   
	   submitHandler: function(form){
			  
			  var dados = $("#fmModalSenha").serialize();
			  $.ajax({
				  
				  type: "POST",
				  url: "main?action=minha-conta/",
				  data: dados,
				  success: function (data){
					  bootbox.alert({ 
						  size: "small",
						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
						  		"<b>GO</b>TRAN </div>",
						  message: "<div  class='Panel with panel-danger class' align='center'><span class='fa fa-thumbs-down '></span> Senha atual invalida!</div>", 
						  callback: function(){ /* your callback code */ 
							  

						  }
						});
				  },
			  error: function(data) {
				  bootbox.alert({ 
					  size: "small",
					  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
					  		"<b>GO</b>TRAN </div>",
					  message: "<div  class='Panel with panel-danger class' align='center'><span class='fa fa-thumbs-up '></span> Senha alterada com sucesso!</div>", 
					  callback: function(){ /* your callback code */ 
						  
						  location="login.jsp"
					  }
					});					
			  }
			  
			  });

			  return false;
		  }
		   
	   });
	   
	   
   });
	   
   /* INICIO VALIDAÇÃO MODAL NOVO VEICULO*/

   $(document).ready(function(){
  	 
  	 $("form#fmAddVeiculo").validate({
  		 
  		 rules:{
  			 
  			 marca_veiculo:{
  				 required: true
  			 },
  			 modelo_veiculo:{
  				 required:true
  			 },
  			 qtd_assento:{
  				 required:true
  			 },
  			 combustivel_veiculo:{
  				 required: true
  			 },
  			 desc_veiculo:{
  				 required:true
  			 },
  			 tipo_veiculo:{
  				 required: true
  			 },
  			 ano_veiculo:{
  				 required: true,
  				 rangelength: [4,4]
  			 }/**/
  		 },
  		 
  		 messages: {
  			 
  			 marca_veiculo:{
  				 required: "Campo obrigatorio!"
  			 },
  			 modelo_veiculo:{
  				 required: "Campo obrigatorio!"
  			 },
  			 qtd_assento:{
  				 required: "Campo obrigatorio!"
  			 },
  			 combustivel_veiculo:{
  				 required: "Campo obrigatorio!"
  			 },
  			 desc_veiculo:{
  				 required: "Campo obrigatorio!"
  			 },
  			 tipo_veiculo:{
  				 required: "Campo obrigatorio!"
  			 },
  			 ano_veiculo:{
  				 required: "Campo obrigatorio!",
  				 rangelength: "Ex.: (Ano: 1990)"
  			 }
  		 
  		 },
 
  		 submitHandler: function () {
			
		$("form#fmAddVeiculo").submit(function(event){
  				 
  				 event.preventDefault();
  				 
  				  var formData = new FormData($(this)[0]);
  				 
  				  $.ajax({
  				    url: 'main?action=cadastrar-veiculo',
  				    type: 'POST',
  				    data: formData ,
  				    async: false,
  				    cache: false,
  				    contentType: false,
  				    processData: false,
  				    success: function (returndata) {
  				    	
  					  bootbox.alert({ 
  						  size: "small",
  						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
  						  		"<b>GO</b>TRAN </div>",
  						  message: "<div  class='alert alert-success' align='center'>Persistido com sucesso!</div>", 
  						  callback: function(){ /* your callback code */ 
  							  var idUsuario = $("#id_usuario").val();
  							location="main?action=meus-veiculos&id_usuario="+idUsuario;
  						  }
  						});	

  				    }
  				  });
  				 
  				  return false;
  				 
  			 })

 
  		 }
			 
  	
  		 
  		
  	 });
  	 
   });
   
  
   
   function salvarVeiculo(){
	   
		 $("form#fmAddVeiculo").submit();


				 
			  event.preventDefault();
			  var data = new FormData(this); 

			  $.ajax({
		      url: 'main?action=cadastrarVeiculo2',
			    type: 'POST',
			    data: data,
			    async: false,
			    cache: false,
			    contentType: false,
			    processData: false,
			    success: function (returndata) {
			  	  bootbox.alert({ 
					  size: "small",
					  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
					  		"<b>GO</b>TRAN </div>",
					  message: "<div  class='alert alert-success' align='center'>Persistido com sucesso!</div>", 
					  callback: function(){ /* your callback code */ 
						  
			                window.location.reload();

					  }
					});				    
			  	  }
			  });
			 
			  return false;
   }
   
 
   
   /*ATUALIZACAO ANUNCIO ESCOLAR*/
   $(document).ready(function(){
	   
	   $("#fmAtAnEs").validate({
		   
		   rules:{
			   
			   veiculo:{
				   required: true,
			   },
			   titulo:{
				   required: true,
				   rangelength: [5,60]
			   },
			   turno_escolar:{
				   required:true
			   },
			   vaga_escolar:{
				   required: true
				   },
			   instituicao1:{
				   required: true
			   },
			   cidade1:{
				   required: true
			   },
			   descricao_escolar:{
				   required: true,
				   rangelength: [4,200]
			   }
		   },
		   
		   messages: {
			   veiculo:{
				   required: "O campo deve ser preenchido!"
			   },
			   titulo:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres."

			   },
			   turno_escolar:{
				   required: "O campo deve ser preenchido!"
			   },
			   vaga_escolar:{
				   required: "O campo deve ser preenchido!"
			   },
			   instituicao1:{
				   required: "O campo deve ser preenchido!"
			   },
			   cidade1:{
				   required: "O campo deve ser preenchido!"
			   },
			   descricao_escolar:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "A descrição deve conter entre 4 a 200 caracteres."

			   }
		   },
		   errorElement: "em",
 			errorPlacement: function ( error, element ) {
 				// Add the `help-block` class to the error element
 				error.addClass( "help-block" );

 				// Add `has-feedback` class to the parent div.form-group
 				// in order to add icons to inputs
 				element.parents( ".col-sm-10" ).addClass( "has-feedback" );

 				if ( element.prop( "type" ) === "checkbox" ) {
 					error.insertAfter( element.parent( "label" ) );
 				} else {
 					error.insertAfter( element );
 				}

 				
 			},
 		
 			highlight: function ( element, errorClass, validClass ) {
 				$( element ).parents( ".col-sm-10" ).addClass( "has-error" ).removeClass( "has-success" );
 				$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
 			},
 			unhighlight: function ( element, errorClass, validClass ) {
 				$( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-error" );
 				$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
 			},
 			
 			submitHandler: function( form ){
				var dados = $("#fmAtAnEs").serialize();
				var url1;
				var lat1 = $("#lat1").val();
				var lat2 = $("#lat2").val();
				var lat3 = $("#lat3").val();
				var lat4 = $("#lat4").val();
				var lat5 = $("#lat5").val();
				var lat6 = $("#lat6").val();
				
				var vg_disp = $("#vaga_escolar").val();
                var vg_disp_veiculo = $("#qtd_assento_at").val();

				console.log(vg_disp)
				console.log(vg_disp_veiculo)

                if(lat1 != "" || lat2 != "" || lat3 != "" || lat4 != "" || lat5 != "" || lat6 != ""){
                	
                	if(vg_disp > vg_disp_veiculo){
                    	alert("Quantidade de assentos não pode ser maior que "+vg_disp_veiculo)

                	}else{
                    	url1 = "main?action=cadastrarEscolar";
                    	$.ajax({
        					type: "POST",
        					url: url1,
        					data: dados,
        					success: function( data )
        					{
        						bootbox.alert({ 
        							  size: "small",
        							  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
        							  		"<b>GO</b>TRAN </div>",
        							  message: "<div  class='alert alert-success' align='center'>Atualizado com sucesso!</div>", 
        							  callback: function(){ /* your callback code */ 
        								  
        	        						location.reload();

        							  }
        							});
        					}
        				});
                	}
                	
                }else{
                	bootbox.alert({ 
						  size: "small",
						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
						  		"<b>GO</b>TRAN </div>",
						  message: "<div  class='alert alert-danger' align='center'>Selecione 1 bairro no mapa!</div>", 
						  callback: function(){ /* your callback code */ }
						});
                	}
				
				

			

				return false;
 			}
		   
	   });
   });
   
   /*CADASTRO ANUNCIO ESCOLAR*/
   $(document).ready(function(){
	   
	   $("#fmCadAnEs").validate({
		   
		   rules:{
			   
			   veiculo:{
				   required: true,
			   },
			   titulo:{
				   required: true,
				   rangelength: [5,60]
			   },
			   turno_escolar:{
				   required:true
			   },
			   vaga_escolar:{
				   required: true
				   },
			   instituicao1:{
				   required: true
			   },
			   cidade1:{
				   required: true
			   },
			   desc_anuncio:{
				   required: true,
				   rangelength: [4,200]
			   }
		   },
		   
		   messages: {
			   veiculo:{
				   required: "O campo deve ser preenchido!"
			   },
			   titulo:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres."

			   },
			   turno_escolar:{
				   required: "O campo deve ser preenchido!"
			   },
			   vaga_escolar:{
				   required: "O campo deve ser preenchido!"
			   },
			   instituicao1:{
				   required: "O campo deve ser preenchido!"
			   },
			   cidade1:{
				   required: "O campo deve ser preenchido!"
			   },
			   desc_anuncio:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O campo deve conter entre 4 a 200 caracteres."

			   }
		   },
		   errorElement: "em",
 			errorPlacement: function ( error, element ) {
 				// Add the `help-block` class to the error element
 				error.addClass( "help-block" );

 				// Add `has-feedback` class to the parent div.form-group
 				// in order to add icons to inputs
 				element.parents( ".col-sm-10" ).addClass( "has-feedback" );

 				if ( element.prop( "type" ) === "checkbox" ) {
 					error.insertAfter( element.parent( "label" ) );
 				} else {
 					error.insertAfter( element );
 				}

 				
 			},
 		
 			highlight: function ( element, errorClass, validClass ) {
 				$( element ).parents( ".col-sm-10" ).addClass( "has-error" ).removeClass( "has-success" );
 				$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
 			},
 			unhighlight: function ( element, errorClass, validClass ) {
 				$( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-error" );
 				$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
 			},
 			
 			submitHandler: function( form ){
				var dados = $("#fmCadAnEs").serialize();
				var lat1 = $("#lat1").val();
				var lat2 = $("#lat2").val();
				var lat3 = $("#lat3").val();
				var lat4 = $("#lat4").val();
				var lat5 = $("#lat5").val();
				var lat6 = $("#lat6").val();
				
				var vg_disp = $("#vaga_escolar").val();
               
				if(tel_fixo == "" || tel_fixo == null && tel_cel == "" || tel_cel == null ){
					$(function(){
					    $('#modalTelefone').modal('show');
					});
				}else{
					if(lat1 != "" || lat2 != "" || lat3 != "" || lat4 != "" || lat5 != "" || lat6 != ""){
	                	
	                	if(vg_disp > vaga_dis){
	                		bootbox.alert({ 
	  						  size: "small",
	  						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
	  						  		"<b>GO</b>TRAN </div>",
	  						  message: "<div  class='alert alert-danger' align='center'>Quantidade de assento nao pode ser maior que "+vaga_dis+"</div>", 
	  						  callback: function(){ /* your callback code */ }
	  						});
	                  	

	                	}else{
	            			$.ajax({
	    						type: "POST",
	    						url: "main?action=cadastrarEscolar",
	    						data: dados,
	    						success: function( data )
	    						{
	    							bootbox.alert({ 
	    								  size: "small",
	    								  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
	    								  		"<b>GO</b>TRAN </div>",
	    								  message: "<div  class='alert alert-success' align='center'>Cadastrado com sucesso!</div>", 
	    								  callback: function(){ 
	    									  
	    			    						$('#fmCadAnEs').each (function(){
	    			    							  this.reset();
	    			    							});
	    			    						
	    			    						    
	    			    			                document.getElementById('modelo').value = "";
	    			    			                document.getElementById('marca').value = "";
	    			    			                $('#img_veiculo').attr('src', 'resources/img/img-icone/sem_foto.jpg');
	    			    			                
	    			    			                var idUsuario = $("#id_usuario").val();
	    			      							location="main?action=anuncio-escolar/&id_usuario="+idUsuario;


	    								  }
	    								});
	    						}
	    					});

	                	}
	                	
	                }else{
	                    	bootbox.alert({ 
	    						  size: "small",
	    						  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
	    						  		"<b>GO</b>TRAN </div>",
	    						  message: "<div  class='alert alert-danger' align='center'>Selecione pelo menos um bairro no mapa!</div>", 
	    						  callback: function(){ /* your callback code */ }
	    						});
	                    	
	                }
					
					

		
					
				}

				
                

				return false;
 			}
		   
	   });
   });
   
   
  
/*Mudar radio*/
   function alterna(tipo) {

   	if (tipo == 'kilo') {
   	document.getElementById("tipo1").style.display = "block";
   	document.getElementById("tipo2").style.display = "none";
   	} else {
   	document.getElementById("tipo1").style.display = "none";
   	document.getElementById("tipo2").style.display = "block";
   	}

   }

/*Validar cadastro frete*/
   
   $(document).ready(function(){
	   
	   $("#fmCadAnFr").validate({
		  
		   rules:{
			   veiculo:{
				   required: true
			   },
			   titulo_frete:{
				   required:true,
				   rangelength: [4,60]

			   },
			   tipo:{
				   required:true
			   },
			   disp_vg_frete:{
				   required:true
			   },
			   desc_anuncio:{
				   required: true,
				   rangelength: [4,200]
			   },
			   oculto:{
				   required:true
			   },
			   carga:{
				   required:true
			   },
			   cargat:{
				   required:true
			   },
			   cidade:{
				   required:true
			   },
			   cep:{
				   required:true
			   },
			   bairro:{
				   required:true
			   },
			   rua:{
				   required:true
			   }
		   },
		   
		   messages:{
			   veiculo:{
				   required: "O campo deve ser preenchido!"
			   },
			   titulo_frete:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 4 á 60 caracteres."

			   },
			   tipo:{
				   required: "*"
			   },
			   disp_vg_frete:{
				   required: "*"
			   },
			   desc_anuncio:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O campo deve conter entre 4 a 200 caracteres."

			   },
			   oculto:{
				   required: "*"
			   },
			   carga:{
				   required: "*"
			   },
			   cargat:{
				   required: "*"
			   },
			   cep:{
				   required:"O campo deve ser preenchido!"
			   },
			   cidade:{
				   required:"*"
			   },
			   bairro:{
				   required:"*"
			   },
			   rua:{
				   required:"*"
			   }
		   },
		   submitHandler: function( form ){
				var dados = $("#fmCadAnFr").serialize();
				if(tel_fixo == "" || tel_fixo == null && tel_cel == "" || tel_cel == null ){
					$(function(){
					    $('#modalTelefone').modal('show');
					});
				}else{
					$.ajax({
						type: "POST",
						url: "main?action=cadastrarAnFrete",
						data: dados,
						success: function( data )
						{
							bootbox.alert({ 
								  size: "small",
								  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
								  		"<b>GO</b>TRAN </div>",
								  message: "<div  class='alert alert-success' align='center'>Cadastrado com sucesso!</div>", 
								  callback: function(){ 
									  
			    						$('#fmCadAnFr').each (function(){
			    							  this.reset();
			    							});
			    						
			    						   
			    			                document.getElementById('modelo').value = "";
			    			                document.getElementById('marca').value = "";
			    			                $('#img_veiculo').attr('src', 'resources/img/img-icone/sem_foto.jpg');


								  }
								});
						}
					});
				}
	

				return false;
			}
		   
	   });
   });
   
/*Validar atualizacao frete*/
   
   $(document).ready(function(){
	   
	   $("#fmAtAnFr").validate({
		  
		   rules:{
			   veiculo:{
				   required: true
			   },
			   titulo_frete:{
				   required:true,
				   rangelength: [5,60]

			   },
			   tipo:{
				   required:true
			   },
			   disp_vg_frete:{
				   required:true
			   },
			   desc_veiculo:{
				   required: true,
				   rangelength: [4,200]
			   },
			   oculto:{
				   required:true
			   },
			   carga:{
				   required:true
			   },
			   cargat:{
				   required:true
			   },
			   cidade:{
				   required:true
			   }
		   },
		   
		   messages:{
			   veiculo:{
				   required: "O campo deve ser preenchido!"
			   },
			   titulo_frete:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres."

			   },
			   tipo:{
				   required: "*"
			   },
			   disp_vg_frete:{
				   required: "*"
			   },
			   desc_veiculo:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "A descrição deve conter entre 4 a 200 caracteres."

			   },
			   oculto:{
				   required: "*"
			   },
			   carga:{
				   required: "*"
			   },
			   cargat:{
				   required: "*"
			   },
			   cidade:{
				   required:"O campo deve ser preenchido!"
			   }
		   },
		   submitHandler: function( form ){
				var dados = $("#fmAtAnFr").serialize();

				$.ajax({
					type: "POST",
					url: "main?action=cadastrarAnFrete",
					data: dados,
					success: function( data ){
    						bootbox.alert({ 
    							  size: "small",
    							  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
    							  		"<b>GO</b>TRAN </div>",
    							  message: "<div  class='alert alert-success' align='center'>Atualizado com sucesso!</div>", 
    							  callback: function(){ 
    								  
    		    						location.reload();

    							  }
    							});

    					}
					
				});

				return false;
			}
		   
	   });
   });
   
   
   
  /*Validar cadastro de excursao*/
   
   $(document).ready(function(){
	   
	   $("#fmCadAnEx").validate({
		   
		   rules:{
			   veiculo:{
				   required:true
			   },
			   titulo:{
				   required:true,
				   rangelength: [5,60]

			   },
			   rua:{
				   required:true
			   },
			   destino_excursao:{
				   required:true
			   },
			   bairro_excursao:{
				   required:true
			   },
			   dt_partida:{
				   required:true
			   },
			   cep:{
				   required:true
			   },
			   cidade:{
				   required:true
			   },
			   rua:{
				   required:true
			   },
			   bairro:{
				   required:true
			   },			
			
			   dt_retorno:{
				   required:true
			   },
			
			   desc_anuncio:{
				   required:true,
				   rangelength: [4,200]

			   }
			   
		   },
		   
		   messages:{
			   veiculo:{
				   required: "O campo deve ser preenchido!"
			   },
			   titulo:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres."
			   },
			   rua:{
				   required: "*"
			   },
			   destino_excursao:{
				   required: "O campo deve ser preenchido!"
			   },
			   bairro_excursao:{
				   required: "*"
			   },
			   dt_partida:{
				   required: "O campo deve ser preenchido!"
			   },
			   cidade:{
				   required: "*"
			   },
			   bairro:{
				   required: "*"
			   },
			   cep:{
				   required: "O campo deve ser preenchido!"
			   },
			
			   dt_retorno:{
				   required: "O campo deve ser preenchido!"
			   },
			
			   desc_anuncio:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O campo deve conter entre 4 a 200 caracteres."

			   }
		   },
		   submitHandler: function( form ){
				var dados = $("#fmCadAnEx").serialize();
				
				if(tel_fixo == "" || tel_fixo == null && tel_cel == "" || tel_cel == null){
					$(function(){
					    $('#modalTelefone').modal('show');
					});
				}else{
					$.ajax({
						type: "POST",
						url: "main?action=cadastrarAnExcursao",
						data: dados,
						success: function( data )
						{

							bootbox.alert({ 
								  size: "small",
								  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
								  		"<b>GO</b>TRAN </div>",
								  message: "<div  class='alert alert-success' align='center'>Cadastrado com sucesso!</div>", 
								  callback: function(){ 
									  
			    						$('#fmCadAnEx').each (function(){
			    							  this.reset();
			    							});
			    						
			    						   
			    			                $('#img_veiculo').attr('src', 'resources/img/img-icone/sem_foto.jpg');


								  }
								});
							
						}
					});
				}

			

				return false;
			}
	   });
   });
   
 /*Validar atualização de excursao*/
   
   $(document).ready(function(){
	   
	   $("#fmAtAnEx").validate({
		   
		   rules:{
			   veiculo:{
				   required:true
			   },
			   titulo:{
				   required:true,
				   rangelength: [5,60]

			   },
			   rua:{
				   required:true
			   },
			   destino_excursao:{
				   required:true
			   },
			   bairro_excursao:{
				   required:true
			   },
			   dt_retorno:{
				   required:true
			   },
			   dt_partida:{
				   required:true
			   },
			  
			   desc_anuncio:{
				   required:true,
				   rangelength: [4,200]

			   }
			   
		   },
		   
		   messages:{
			   veiculo:{
				   required: "O campo deve ser preenchido!"
			   },
			   titulo:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres."
			   },
			   rua:{
				   required: "*"
			   },
			   destino_excursao:{
				   required: "O campo deve ser preenchido!"
			   },
			   dt_retorno:{
				   required: "O campo deve ser preenchido!"
			   },
			   dt_partida:{
				   required: "O campo deve ser preenchido!"
			   },
			   bairro_excursao:{
				   required: "*"
			   },
			  
			   desc_anuncio:{
				   required: "O campo deve ser preenchido!",
				   rangelength: "A descrição deve conter entre 4 a 200 caracteres."

			   }
		   },
		   submitHandler: function( form ){
				var dados = $("#fmAtAnEx").serialize();

				$.ajax({
					type: "POST",
					url: "main?action=cadastrarAnExcursao",
					data: dados,
					success: function( data )
					{

						bootbox.alert({ 
							  size: "small",
							  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
							  		"<b>GO</b>TRAN </div>",
							  message: "<div  class='alert alert-success' align='center'>Atualizado com sucesso!</div>", 
							  callback: function(){ 
								  
		    						location.reload();

							  }
							});

						
					}
				});

				return false;
			}
	   });
   });
   /*Validar cadastro aluguel de van*/
   
   $(document).ready(function(){
	   
	   $("#fmCadAnAl").validate({
		   
		   rules:{
			   veiculo:{
				   required:true
			   },
			   titulo:{
				 required:true,
				 rangelength: [5, 60]
			   },
			   cep:{
				   required:true
			   },
			   desc_anuncio:{
				   required:true,
				   rangelength: [4,200]				   
			   },
			   rua:{
				   required: true
			   },
			   cidade:{
				   required: true
			   },
			   bairro:{
				   required: true
			   },
		   },
		   messages:{
			   veiculo:{
				   required:"O campo deve ser preenchido!"
			   },
			   titulo:{
				   required:"O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres."

			   },
			   cep:{
				   required:"O campo deve ser preenchido!"
			   },
			   
			   desc_anuncio:{
				   required:"O campo deve ser preenchido!",
				   rangelength: "O campo deve conter entre 4 a 200 caracteres."

			   },
			   rua:{
				   required:"*"
			   },
			   cidade:{
				   required:"*"
			   },
			   bairro:{
				   required:"*"
			   },
		   },
		   submitHandler: function( form ){
				var dados = $("#fmCadAnAl").serialize();
				var urlCadastro;
				
				if(tel_fixo == "" || tel_fixo == null && tel_cel == "" || tel_cel == null){
					$(function(){
					    $('#modalTelefone').modal('show');
					});
				}else{
					urlCadastro = "main?action=cadastrarAnAluguel";
					
					$.ajax({
						type: "POST",
						url: urlCadastro,
						data: dados,
						success: function( data )
						{

							bootbox.alert({ 
								  size: "small",
								  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
								  		"<b>GO</b>TRAN </div>",
								  message: "<div  class='alert alert-success' align='center'>Cadastrado com sucesso!</div>", 
								  callback: function(){ 
									  
			    						$('#fmCadAnAl').each (function(){
			    							  this.reset();
			    							});
			    						
		    			                $('#img_veiculo').attr('src', 'resources/img/img-icone/sem_foto.jpg');

								  }
								});
							
						}
					});

				}

		

				return false;
			}
	   });
   });
   
 /*Validar atualização  de van*/
   
   $(document).ready(function(){
	   
	   $("#fmAtAnAl").validate({
		   
		   rules:{
			   veiculo:{
				   required:true
			   },
			   titulo:{
				 required:true,
				 rangelength: [5,60]
			   },
			   cidade:{
				   required:true
			   },
			   rua:{
				   required:true
			   },
			   bairro:{
				   required:true
			   },
			   desc_anuncio:{
				   required:true,
				   rangelength: [4,200]
			   }
		   },
		   messages:{
			   veiculo:{
				   required:"Selecione um veículo"
			   },
			   titulo:{
				   required:"O campo deve ser preenchido!",
				   rangelength: "O titulo deve conter entre 5 a 60 caracteres!"
			   },
			   cidade:{
				   required:"*"
			   },
			   rua:{
				   required:"*"
			   },
			   bairro:{
				   required:"*"
			   },
			   desc_anuncio:{
				   required:"Campo obrigatorio!",
					rangelength: "O campo deve conter entre 4 a 200 caracteres!"
			   },
			   cep:{
				   required: "Informe seu cep"
			   }
		   },
		   submitHandler: function( form ){
				var dados = $("#fmAtAnAl").serialize();

				$.ajax({
					type: "POST",
					url: "main?action=cadastrarAn",
					data: dados,
					success: function( data )
					{
						bootbox.alert({ 
							  size: "small",
							  title: "<div align='center'><img src='resources/img/img-icone/logo.png' style='width: 30px;'/> " +
							  		"<b>GO</b>TRAN </div>",
							  message: "<div  class='alert alert-success' align='center'>Atualizado com sucesso!</div>", 
							  callback: function(){ 
								  
									 $('#fmCadAnAl').each (function(){
										  this.reset();
										});
							  }
							});

					}
				});

				return false;
			}
	   });
   });
   
 /*VALIDAR DATA EXCURSAO*/  
   var datainicial = document.getElementById('dt_partida');
   var datafinal = document.getElementById('dt_retorno');

   function formatar(mascara, documento) {
       var i = documento.value.length;
       var saida = mascara.substring(0, 1);
       var texto = mascara.substring(i);
       if (texto.substring(0, 1) != saida) {
           documento.value += texto.substring(0, 1);
       }
       verificar();
   }

   function gerarData(str) {
       var partes = str.split("/");
       return new Date(partes[2], partes[1] - 1, partes[0]);
   }

   function verificar() {
       var inicio = datainicial.value;
       var fim = datafinal.value;
       if (inicio.length != 10 || fim.length != 10) return;

       if (gerarData(fim) < gerarData(inicio)) alert("A de retorno não pode ser menor que a data de partida!");
   }
   

   /*Mudar valores conforme select*/
   $(document).ready(function(){
       $("select[name='veiculo']").change(function(){
               $("input[name='modelo']").val('Carregando...');
               $("input[name='marca']").val('Carregando...');
              var id= $("select[name='veiculo']").val();
           	$.ajax({
           		type: 'GET',
           		dataType: 'json',
           		url: '/gotran-maven/jsonVeiculo.jsp',
           		async: false,
           		success: function(response)
           		{
           			if(response.length > 0){
           				for(var i = 0; i < response.length; i++)
           				{
           					if(response[i].id_veiculo == id){
                                   $("input[name='modelo']").val(response[i].modelo);
                                   $("input[name='marca']").val(response[i].marca);
                                   $("input[name='img_veiculo']").val(response[i].img_veiculo)
                                   document.getElementById('img_veiculo').src = "http://localhost:8080/gotran-maven/img_gotran/img_veiculo/"+response[i].img_veiculo;
                                  vaga_dis = response[i].qtd_assento;
                                  tel_cel = response[i].usuario.telefone_cel;
                                  tel_fixo = response[i].usuario.telefone_fixo;
                                   

           						}
           				}
           			}
           			
           		},
           		error: function (xhr,ajaxOptions,thrownError){
           			alert(xhr.statusText);
           			alert(xhr.responseText);
           			alert(xhr.status);
           			alert(thrownError);
           		}
           		});
       });
});




	  
   /*Login com o google*/
   function loginGoogle(response) {
   	    // Conseguindo as informações do seu usuário:
   	    var perfil = response.getBasicProfile();

   	    // Conseguindo o ID do Usuário
   	    var userID = perfil.getId();

   	    // Conseguindo o Nome do Usuário
   	    var userName = perfil.getName();

   	    // Conseguindo o E-mail do Usuário
   	    var userEmail = perfil.getEmail();

   	    // Conseguindo a URL da Foto do Perfil
   	    var userPicture = perfil.getImageUrl();

   	    $("#user_email").val(userEmail);
   	    $("#user_name").val(userName);
   	    $("#user_photo").val(userPicture);
   	    $("#user_id").val(userID);


       	var dados = $("#loginGoogle").serialize();

   	    $.ajax({
   	    	
   	    	type: "POST",
   	    	url: "login",
   	    	data: dados,
   	    	success: function(response){
   	    		
   	    	   if(response=="true"){
		    	   var url = "main?action=minha-conta/";    
		    	   $(location).attr('href',url); 
		        
		       }
		       else{
		        $("#erro-login").fadeIn(1000, function(){      
		      $("#erro-login").html('<div class="alert alert-danger">Ja existe uma conta com esse email&nbsp; '+response+' !</div>');
		             $("#btn-login").html('<span class="glyphicon glyphicon-log-in"></span> &nbsp; Sign In');
				      $("#carrega").html('<div></div>');
		           });
		       }
   	    	}
   	    	
   	    });
   	};

  
