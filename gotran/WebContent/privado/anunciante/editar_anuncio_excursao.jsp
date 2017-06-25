<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Anúncio - Excursão</title>

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
								<form action="" id="fmAtAnEx" method="post">
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
												   <img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anExcursao.veiculo.img_veiculo}"
												 style="width: 200px;" class=" img-rounded" id="img_veiculo" name="img_veiculo"/>
                                              	</div>
                                              	    <div class="col-sm-12 col-md-2" style="margin-top: 20px;">
                                          	
                                        <div class="form-group" >
                                        <label>Marca</label>
									    <input type="text" name="marca" id="marca" disabled="disabled" value="${anExcursao.veiculo.marca}">
									    </div>
									    
                                         <div class="form-group" >
                                        <label>Modelo</label>
									    <input type="text" name="modelo" id="modelo" disabled="disabled" value="${anExcursao.veiculo.modelo}">
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
														name="veiculo">
														<c:forEach var="veiculo" items="${listarVeiculo}">
															<option value="${veiculo.id_veiculo}" <c:out value="selected=selected"/>>${veiculo.modelo}</option>
														</c:forEach>
													</select>
												</div>

												<div class="form-group">
													<label>Titulo*</label> <input type="text"
														class="form-control" value="${anExcursao.nome_empresa}"
														name="titulo" id="titulo">
												</div>
												<!-- Fim coluna 1 -->
								</div>
								
								<div class="col-sm-12 col-md-4" style="margin-top: 30px;">

												<div class="form-group">
													<label>Valor</label> <input type="text"
														class="form-control" value="${anExcursao.valor}" id="valor">
												</div>
												
												 <div class="form-group">
															<label>Desativado\Ativado</label></br>
												<label class="on-off">
												<input type="checkbox" name="status" <c:if test="${anExcursao.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>
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
																<div>
																</div>
															</div>
														</div>

										<div class="col-sm-12 col-md-4" >
			
										  <div class="form-group col-md-12">
											  <label>Rua*</label>
											  <input class="form-control" type="text" value="${anExcursao.rua}"
											  name="rua" id="rua" readonly="readonly">
											  </div>
											  
											 <div class="form-group col-md-12">
											  <label>Bairro*</label>
											  <input class="form-control" type="text" value="${anExcursao.bairro}"
											  name="bairro" id="bairro" readonly="readonly">
											  </div>
									  </div>
                               
										 <!-- Coluna 2 -->
								<div class="col-sm-12 col-md-4" >
						
								
								<div class="form-group">
								<label>Nº</label>
								<input type="text" class="form-control"  name="n" id="n" value="${anExcursao.numero}">
								</div>
								
								<div class="form-group">
								<label>Data da Excursão*</label>
					          <div class='input-group date' id='datetimepicker9'>
                <input type='text' class="form-control" name="dt_partida" id="dt_partida" value="${anExcursao.data_excursao}"/>
                
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
								<label>Cidade*</label>
								<input type="text" class="form-control" value="${anExcursao.cidade}"
								name="cidade" id="cidade" readonly="readonly">
								</div>
								
								<div class="form-group">
								<label>Destino*</label>
								<input type="text" class="form-control" value="${anExcursao.destino}" name="destino_excursao" id="destino_excursao">
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
											  <div class='input-group date' id='datetimepicker8'>
                <input type='text' class="form-control" id="dt_retorno" name="dt_retorno" value="${anExcursao.data_retorno}" />
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
										<textarea name="desc_anuncio" rows="4" cols="" class="form-control" 
											style=" resize: none;" >
											${anExcursao.desc_anuncio}
											</textarea>

									</div>
								</div>
								
							</div>
							<input type="hidden" value="${anExcursao.id_anuncio}" name="id_anuncio">
								<!-- Fim coluna 2 -->
								</div>
								<!-- Fim linha 3 -->
								<div align="right" style="margin-top: 10px;">
									<button type="button" onclick="voltarMyAnuncio(${usuarioLogado.id_usuario})" class="btn btn-danger">Voltar</button>
								   <button type="submit" id="alterar" name="alterar" class="btn btn-success">Salvar</button>
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
	         

     






<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fileinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment-with-locales.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript">

 var dt = $("#pegar_dtpt").val();

 console.log(dt)
var dateNow = new Date();
$(function () {
    $('#datetimepicker9').datetimepicker({
    	 format: 'DD/MM/YYYY HH:mm',
    	    locale: 'PT-BR',
        });
    $('#datetimepicker8').datetimepicker({
        useCurrent: false, //Important! See issue #1075
        format: 'DD/MM/YYYY HH:mm',
	    locale: 'PT-BR',
	    
    
    });
    $("#datetimepicker9").on("dp.change", function (e) {
        $('#datetimepicker8').data("DateTimePicker").minDate(e.date);
        $("#dt_retorno").val("");
        
    });
    $("#datetimepicker8").on("dp.change", function (e) {
        $('#datetimepicker9').data("DateTimePicker").maxDate(e.date);
    });
});

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