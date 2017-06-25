<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Anunciar - Excursão</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css"/>

<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet" type="text/css"/>

<!-- DATA -->
	<link href="${pageContext.request.contextPath}/resources/data/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>

</head>
<body >

<!-- IMPORTE SIDEBAR E CABECALHO -->


       <div id="hoeapp-wrapper" class="hoe-hide-lpanel" hoe-device-type="desktop" style="margin-top: -50px;">
          <!-- IMPORTE CABECALHO -->
       <jsp:include page="/template/cabecalho_layout.jsp"></jsp:include>
         <!-- IMPORTE SIDEBAR -->
       <div id="hoeapp-container" hoe-color-type="lpanel-bg10" hoe-lpanel-effect="shrink">
       <jsp:include page="/template/sidebar_layout.jsp"></jsp:include>
	         
	         <div id="main-content">
			    <div class="inner-content">
                    <div class="panel theme-panel">
                     <div class="panel panel-danger">
								<div class="panel-heading">
									<b>Excursão</b>
								</div>
                        <div class="panel-body">
                                 <!-- CONTEUDO -->
                        
                             <!-- Inicio Painel -->
                            
								
								<div class="container-fluid">
								<!-- Inicio formulario -->
								<form action="" id="fmCadAnEx" method="post">
								<!-- Inicio linha -->
								<div class="row">
								
									<!-- IMAGEM DO VEICULO -->
								 <div class="col-sm-12 col-md-4" style="margin-top: 10px;">
										<div class="Panel with panel-default class span9 panel">
											<div class="panel-heading">
												<b>Imagem do Veiculo</b>
											</div>
											<div class="panel-body">
											   <div class="text-center">
												   <img src="${pageContext.request.contextPath}/resources/img/img-icone/sem_foto.jpg"
												 style="width: 200px;" class=" img-rounded" id="img_veiculo" name="img_veiculo"/>
                                              	</div>
                                              	    <div class="col-sm-12 col-md-2" style="margin-top: 20px;">
                                          	
                                        <div class="form-group" >
                                        <label>Marca</label>
									    <input type="text" name="marca" id="marca" disabled="disabled">
									    </div>
									    
                                         <div class="form-group" >
                                        <label>Modelo</label>
									    <input type="text" name="modelo" id="modelo" disabled="disabled">
									    </div>
									    </div> 	
									    		
                                              	
										 
										 </div>										
											</div>
										</div>
										<!-- FIM IMG VEICULO -->
								<!-- Inicio Coluna 1 -->
								<div class="col-sm-12 col-md-4" style="margin-top: 30px;">

												<div class="form-group">
													<label>Veiculo*</label> <select class="form-control"
														name="veiculo" id="veiculo">
														<option value="">Selecione um veiculo</option>
														<c:forEach var="veiculo" items="${carregarSelect}">
															<option value="${veiculo.id_veiculo}">${veiculo.modelo}</option>
														</c:forEach>
													</select>
												</div>

												<div class="form-group">
													<label>Titulo*</label> <input type="text"
														class="form-control" placeholder="Ex.:(Gotran excursão)"
														name="titulo" id="titulo">
												</div>
												<!-- Fim coluna 1 -->
								</div>
								
								<div class="col-sm-12 col-md-4" style="margin-top: 30px;">

												<div class="form-group">
													<label>Valor</label> <input type="text"
														class="form-control" placeholder="Ex.:R$100,00" id="valor" name="valor">
												</div>
												<!-- Fim coluna 2 -->
								</div>

								</div>
								<!-- Fim linha -->
								
								<!-- Linha 2 -->
								<div class="row">
								<!-- Coluna chegada -->
								<div class="col-sm-12 col-md-12" style="margin-top: 10px;">
										<div class="panel panel-danger">
											<div class="panel-heading">
												<b>Partida</b>
											</div>
											<div class="panel-body">


														<div class="row" align="center">
															<div class="col-md-2" align="center"
																style="margin-left: 40%;">
																<label>CEP</label> 
																<input type="text" class="form-control" id="cep" name="cep" maxlength="9">
																<a href="#" onclick="cepCorreio();">Não sei meu CEP?!</a>

															</div>
														</div>

										<div class="col-sm-12 col-md-4" >
			
										  <div class="form-group col-md-12">
											  <label>Rua</label>
											  <input class="form-control" type="text" name="rua" id="rua" readonly="readonly">
											  </div>
											  
											 <div class="form-group col-md-12">
											  <label>Bairro</label>
											  <input class="form-control" type="text" name="bairro" id="bairro" readonly="readonly">
											  </div>
									  </div>
                               
										 <!-- Coluna 2 -->
								<div class="col-sm-12 col-md-4" >
						
								
								<div class="form-group">
								<label>Nº</label>
								<input type="text" class="form-control"  name="n" id="n">
								</div>
								
								<div class="form-group">
								<label>Data da Excursão*</label>
					          <div class='input-group date' id='datetimepicker6'>
                <input type='text' class="form-control" name="dt_partida"/>
                <span class="input-group-addon">
                    <span class="fa fa-calendar"></span>
                </span>
            </div>
					
					        	</div>
								
								
								</div>
										<!-- Fim coluna 2 -->
										
							<!-- Coluna 3 -->
								<div class="col-sm-12 col-md-4" >
								
								<div class="form-group">
								<label>Cidade</label>
								<input type="text" class="form-control"	name="cidade" id="cidade" readonly="readonly">
								</div>
								
								<div class="form-group">
								<label>Destino*</label>
								<input type="text" class="form-control" name="destino_excursao" id="destino_excursao">
								</div>
								
								
								</div>
										<!-- Fim coluna 3 -->
								
										 </div>										
											</div>
										</div>
								<!-- Fim coluna partida -->
								<hr>
																<!-- Coluna chegada -->
								<div class="col-sm-12 col-md-12" style="margin-top: 10px;">
										<div class="panel panel-danger">
											<div class="panel-heading">
												<b>Retorno</b>
											</div>
											<div class="panel-body">
											  
			
											<div class="col-sm-12 col-md-4" >
			
										  <div class="form-group col-md-12">
											  <label>Data do Retorno*</label>
											  <div class='input-group date' id='datetimepicker7'>
                <input type='text' class="form-control" name="dt_retorno"/>
                <span class="input-group-addon">
                    <span class="fa fa-calendar"></span>
                </span>
            </div>
											  </div>
										
											  </div>
                               
										 <!-- Coluna 2 -->
								<div class="col-sm-12 col-md-4" >
						
								
								
								</div>
										<!-- Fim coluna 2 -->
										
				
								
										 </div>										
											</div>
										</div>
								<!-- Fim coluna chegada-->
								
								<hr>
								 <div class="col-sm-12 col-md-10" style="">
								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" >Descrição do anúncio</label>
										<textarea name="desc_anuncio" id="desc_anuncio" rows="4" cols="" class="form-control" 
											style=" resize: none;" placeholder="Escreva algo sobre o seu anúncio..." ></textarea>

									</div>
								</div>
								
							</div>
							
								<!-- Fim coluna 2 -->
								</div>
								<!-- Fim linha 3 -->
								<div align="right" style="margin-top: 10px;">
								   <button type="submit" class="btn btn-success">Salvar</button>
									 <button type="reset" class="btn btn-danger">Cancelar</button>
									</div>
								
									
							
								</form>
								</div>
								<!-- Fim formulario -->
								</div>
								
                             <!-- Fim painel -->
         

                                 <!-- FIM - CONTEUDO -->
                         </div>
                    </div>
                </div>  
            </div>
            
                   <jsp:include page="/template/conf_layout.jsp"></jsp:include>
            
        </div>
	 </div>
	         

     
<!-- INICIO MODAL - CADASTRAR TELEFONE -->
             <div class="modal fade" id="modalTelefone" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Cadastrar Telefone</h4>
        </div>
        <div class="modal-body">

            <!-- INICIO DO FORMULARIO - CADASTRAR TELEFONE -->
            
            <form action="" method="post" id="fmModalTelefone">
                   <input type="hidden" name="id_usuario" value="${usuarioLogado.id_usuario}">
                   
                          <div align="center">
				         <h4>Para continuar é necessario possuir um telefone para contato!</h4>
							</div>
							<hr>
						<div class="row">
						<div class="col-md-2">
						</div>
							<div class="col-sm-6 col-md-8" align="center">
							
								<div class="form-group">
									<label>Telefone celular <samp class="fa fa-mobile"></samp></label>
									 <input type="text" class="form-control" name="fone_celAnuncio" id="fone_celAnuncio" >
								</div>
								
								<div class="form-group">
									<label>Telefone fixo <samp class="fa fa-phone"></samp></label> 
									<input type="text" class="form-control" name="fone_fixoAnuncio" id="fone_fixoAnuncio">
								</div>
								
								
							</div>
						</div>
		<div class="modal-footer">
          <button type="button" onclick="salvarTelefone();" class="btn btn-success" id="salvarTel" name="salvarTel" >Salvar</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        </div>
					</form>
            
            <!-- FIM DO FORMULARIO - CADASTRAR TELEFONE-->
            

        </div>
   
      </div>
    </div>
  </div>
 <!-- FIM MODAL - CADASTRAR TELEFONE -->




<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js" charset="UTF-8"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<!-- DATA -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment-with-locales.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
      <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>

<script type="text/javascript">
$(function () {
    $('#datetimepicker6').datetimepicker({
    	 format: 'DD/MM/YYYY HH:mm',
    	    locale: 'PT-BR'
        });
    $('#datetimepicker7').datetimepicker({
        useCurrent: false, //Important! See issue #1075
        format: 'DD/MM/YYYY HH:mm',
	    locale: 'PT-BR'
    
    });
    $("#datetimepicker6").on("dp.change", function (e) {
        $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker7").on("dp.change", function (e) {
        $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
    });
});
</script>

<script type="text/javascript">
jQuery("#fone_celAnuncio")
.mask("(99) 9999-9999?9")
.focusout(function (event) {  
    var target, phone, element;  
    target = (event.currentTarget) ? event.currentTarget : event.srcElement;  
    phone = target.value.replace(/\D/g, '');
    element = $(target);  
    element.unmask();  
    if(phone.length > 10) {  
        element.mask("(99) 99999-999?9");  
    } else {  
        element.mask("(99) 9999-9999?9");  
    }  
});

jQuery("#fone_fixoAnuncio")
.mask("(99) 9999-9999")
.focusout(function (event) {  
    var target, phone, element;  
    target = (event.currentTarget) ? event.currentTarget : event.srcElement;  
    phone = target.value.replace(/\D/g, '');
    element = $(target);  
    element.unmask();  
    if(phone.length > 10) {  
        element.mask("(99) 9999-9999");  
    } else {  
        element.mask("(99) 9999-9999");  
    }  
});

</script>
<script>
    
    </script>

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
                                var cidUf = dados.localidade + "-" + dados.uf;
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(cidUf);
                              

                                
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                bootbox.alert({ 
                      			   size: "small",
                      			   title: "<b>GO</b>TRAN",
                      			   message: "<h4>CEP não encontrado.</h4>", 
                      			   callback: function(){ /* your callback code */ }
                      			 })	                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        bootbox.alert({ 
              			   size: "small",
              			   title: "<b>GO</b>TRAN",
              			   message: "<h4>Formato de CEP inválido.!</h4>", 
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