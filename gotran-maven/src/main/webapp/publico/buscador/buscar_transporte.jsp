<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Transporte</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>




<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/resources/mapa-busca/css/estiloMapa.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background-color: #C7C7C7;" >
    
    <jsp:include page="/template/cabecalho_buscador.jsp"></jsp:include>
    
     <!-- Container -->
     <div class="container conteudoEscolar" style=" margin-top: 20px; background-color:  #ffffff;" >
     <div >
       <!-- row1 -->
       <div class="row" align="center">
       
       <!-- Col1 -->
        <div class="col-md-4"></div>
       <!-- Fim Col1 -->
       
       <!-- Col2-->
       <div class="col-md-4" style="margin-top: 90px;">
            
            <div class="form-group">
            <input type="text" class="form-control" placeholder="Informe se CEP" id="cep" name="cep">
            
            <div>
            </div>
            </div>
       
       </div>
       <!-- Fim Col2 -->
       
       </div>
       <!-- fim row1 -->
       
       <!-- Row2 -->
       <div class="row">
       <div class="col-md-4"></div>
       
       <div class="col-md-4">
          <div class="form-group">
                <input type="text" id="txtEndereco" name="txtEndereco" class="form-control" readonly="readonly"/>
            
            <div align="center" style="margin-top: 10px;">
					<button type="button" id="btnEndereco" class="btn btn-danger">Obter minha localização</button>
			</div>
            
            </div>       
            </div>
       
       </div>
       <!-- Fim Row2 -->
       
       <!-- Row3 -->
         <div class="row">
       <div class="col-md-1"></div>
       
       <div class="col-md-4 col-sm-10">
          
          <div id="mapa" class="col-sm-8"></div>       
           </div>
           
              <div class="col-md-8">
              </div>
       
       </div>
       <!-- Fim Row3 -->
    
     
     </div>
     
     <hr>
      <div id="divTransporte">
      
      <div align="center"><h2>Selecione o transporte desejado:</h2></div>
      
      <div class="row">
      <div class="col-sm-12 col-md-12">
      
      <div class="col-md-3">
      
      <form id="BsAnuncioEscolar" method="post"
				action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-escolar">
				<input type="hidden" name="lat_usuario" id="lat_usuario"/>
				<input type="hidden" name="lon_usuario" id="lon_usuario" />
				<input type="hidden" name="cidade_escolar" id="cidade_escolar">
		</form>
	<a href="#" onClick="document.getElementById('BsAnuncioEscolar').submit();"><button class="button button1">Transporte Escolar</button></a>
      </div>
      
       <div class="col-md-3">
     <form id="BsAnuncioFrete" method="post"
										action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-frete">
										<input type="hidden" name="cidade_frete" id="cidade_frete"/>
										<input type="hidden" name="lat_usuario" id="lat_usuario_frete"/>
				                        <input type="hidden" name="lon_usuario" id="lon_usuario_frete" />
									</form>
										
                                 <a href="#" onClick="document.getElementById('BsAnuncioFrete').submit();"><button class="button">Frete e Carreto</button></a>
      </div>
      
       <div class="col-md-3">
     <form id="BsAnuncioExcursao" method="post"
										action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-excursao">
										<input type="hidden" name="cidade_excursao" id="cidade_excursao"/>
										<input type="hidden" name="lat_usuario" id="lat_usuario_excursao"/>
				                      <input type="hidden" name="lon_usuario" id="lon_usuario_excursao" />                  
									</form>
									
                                <a href="#" onClick="document.getElementById('BsAnuncioExcursao').submit();"><button class="button button3">Excursão</button></a>       
      </div>
      
      
         <div class="col-md-3">
      <form id="BsAnuncioAluguel" method="post"
										action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-aluguel">
										<input type="hidden" name="cidade_aluguel" id="cidade_aluguel"/>
										<input type="hidden" name="lat_usuario" id="lat_usuario_aluguel"/>
				                        <input type="hidden" name="lon_usuario" id="lon_usuario_aluguel" />
									</form>
									
									
                                 <a href="#" onClick="document.getElementById('BsAnuncioAluguel').submit();"><button class="button button2">Aluguel de Vans</button></a>
      </div>
      </div>
      </div>
      
      </div>
     </div>
     <!-- Fim container -->
    
    
    <jsp:include page="/template/rodape_buscador.jsp"></jsp:include>
    
    
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDanv8HnOiFtaLoQ7tNzc5v82Kuxm2SEoU&amp;libraries=places"></script>
      <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mapa-busca/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mapa-busca/js/mapa.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mapa-busca/js/jquery-ui.custom.min.js"></script>

<script type="text/javascript" >

        $(document).ready(function() {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                
                
          
            }
            
            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                     

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                var cidUf = dados.localidade+"-"+dados.uf;
                                var cidUf2 = dados.localidade+" - "+dados.uf;
                                
                                var end = dados.bairro +", "+cidUf2+", Brasil"
                                $("#rua").val(dados.logradouro);
                                $("#txtEndereco").val(end);
                                
                                $("#cidade_frete").val(cidUf);
                                $("#cidade_aluguel").val(cidUf);
                                $("#cidade_excursao").val(cidUf);
                                $("#cidade_escolar").val(cidUf);
                                
                                
                                

                      
                               
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                bootbox.alert({ 
                       			   size: "small",
                       			   title: "<b>GO</b>TRAN",
                       			   message: "<h4>CEP não encontrado.</h4>", 
                       			   callback: function(){ /* your callback code */ }
                       			 })                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        bootbox.alert({ 
               			   size: "small",
               			   title: "<b>GO</b>TRAN",
               			   message: "<h4>Formato de CEP inválido!</h4>", 
               			   callback: function(){ /* your callback code */ }
               			 })	                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });

    </script>
</body>
</html>