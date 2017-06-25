<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Anuncio- Frete\Carreto</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css"/>

<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet" type="text/css"/>

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
                    	<div class="panel panel-success">
								<div class="panel-heading">
									<b>Frete\Carreto</b>
								</div>
                        <div class="panel-body">
                                 <!-- CONTEUDO -->
                        
                        <!-- INICIO PAINEL -->
						
								<div class="row">
								<!-- Inicio foto veiculo -->
								<div class="col-sm-12 col-md-4" style="margin-top: 30px;">
									<div class="Panel with panel-default class span9 panel">
											<div class="panel-heading">
												<b>Imagem do Veiculo</b>
											</div>
											<div class="panel-body">
											   <div class="text-center">
												   <img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anFrete.veiculo.img_veiculo}"
												 style="width: 200px;" class=" img-rounded" id="img_veiculo"/>
                                              	</div>
                                              	
                                              <div class="col-sm-12 col-md-2" style="margin-top: 20px;">
                                          	
                                        <div class="form-group" >
                                        <label>Marca</label>
									    <input type="text" name="marca" id="marca" disabled="disabled" value="${anFrete.veiculo.marca}">
									    </div>
									    
                                         <div class="form-group" >
                                        <label>Modelo</label>
									    <input type="text" name="modelo" id="modelo" disabled="disabled" value="${anFrete.veiculo.modelo}">
									    </div>
									    </div> 	
									    												
											</div>
										</div>
								</div>
								<!-- Fim foto veiculo -->
								
								<!-- INICIO FORMULARIO -->
								<form action="" method="POST" id="fmAtAnFr">
								
								<!-- INICIO LINHA 1 -->
								
								<div class="col-sm-12 col-md-4" style="margin-top: 30px;">
								 
								 <div class="form-group">
								 <label>Veiculo</label>
								 <select class="form-control" name="veiculo">
								   <c:forEach var="veiculo" items="${listSelect}">
                                 <option value="${veiculo.id_veiculo}"
										<c:if test="${veiculo.modelo == anFrete.veiculo.modelo }">
											<c:out value="selected=selected"/></c:if>>
												${veiculo.modelo}</option>
								 </c:forEach>
								 </select>
								 </div>
								 
								 <div class="form-group">
								 <label>Titulo</label>
								 <input type="text" class="form-control" value="${anFrete.nome_empresa}"
								 name="titulo_frete" id="titulo">
								 </div>
								 
								  <div class="form-group">
								 <label>Carga suportada</label>
								 <div class="radio" >
										<label><input type="radio" name="tipo" value="kilo" onclick="alterna(this.value);"
										<c:if test="${(anFrete.tipo_carga == 'kilo')}">checked="checked"</c:if>>Kilo</label>
										<label><input type="radio" name="tipo" value="tonelada" onclick="alterna(this.value);"
										<c:if test="${(anFrete.tipo_carga == 'tonelada')}">checked="checked"</c:if>>Tonelada</label>
									</div>
                       
											<div id="tipo1" style="display: none;" class="col-md-4">
												<input type="text" name="carga" id="carga" class="form-control" 
												value="${kilo}"/>
											</div>

											<div id="tipo2" style="display: none;" class="col-md-4">
												<input type="text" name="cargat" id="cargat" class="form-control"
												value="${tonelada}" />
											</div>
											</div>
										</div>
								
								<!-- Inicio segunda coluna -->
								<div class="col-sm-12 col-md-4" style="margin-top: 30px;">
								
								  <div class="form-group">
															<label>Desativado\Ativado</label></br>
												<label class="on-off">
												<input type="checkbox" name="status" <c:if test="${anFrete.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>
														</div>
								 
								<div class="form-group col-md-10">
								 <label>Valor</label>
								 <input type="text" class="form-control" value="${anFrete.valor}" name="valor" id="valor">
								 </div>

											<div class="form-group">
												<label>Viagens p/ outro estado</label>
												<div class="radio" >
													<label><input type="radio" name="disp_vg_frete" value="Sim"
													<c:if test="${(anFrete.disp_viagem == false)}">checked="checked"</c:if> >Sim</label>
													
													<label><input type="radio" name="disp_vg_frete" value="Nao"
													<c:if test="${(anFrete.disp_viagem == true)}">checked="checked"</c:if> >N�o</label>
													
												</div>
											</div>

										</div>
								<!-- Fim segunda coluna -->
									
								
												<div class="col-sm-12 col-md-12" style="margin-top: 10px;">
										<div class="panel panel-success">
											<div class="panel-heading">
												<b>Endere�o</b>
											</div>
								<div class="panel-body">
								
								<div class="row" >
								<div class="col-md-12 col-sm-12">
								
								  <div class="col-sm-12 col-md-4">
                                  
							        </div>
								    <div class="col-sm-12 col-md-8">
                                         <div class="form-group col-md-6" align="center" >
										 <label>CEP*</label>
										 <input type="text" class="form-control" maxlength="8" id="cep" name="cep">
										 <a href="#" onclick="cepCorreio();">N�o sei meu CEP?!</a>
										
										 </div>
										 
							        </div>
							        
							       </div>
                                 </div>
                                 
                                     <div class="row">
							     <div >
                                <div class="col-sm-12 col-md-12">
                                
                                <div class="col-sm-12 col-md-4 form-group">
                                <label>Rua</label>
                                <input type="text" readonly="readonly" class="form-control" id="rua" name="rua"
                                value="${anFrete.rua}">
                                </div>
                                
                                 <div class="col-sm-12 col-md-2 form-group">
                                <label>N�</label>
                                <input type="text" class="form-control" id="n" name="n"
                                value="${anFrete.numero}">
                                </div>
                                
                                
                                <div class="col-sm-12 col-md-4 form-group">
                                <label>Bairro</label>
                                <input type="text" readonly="readonly" class="form-control" id="bairro" name="bairro"
                                value="${anFrete.bairro}">
                                </div>
                                
                                <div class="col-sm-12 col-md-2 form-group">
                                <label>Cidade</label>
                                <input type="text" readonly="readonly" class="form-control" id="cidade" name="cidade"
                                value="${anFrete.cidade}">
                                </div>
                                
                                </div>
                                </div>
                               
                               </div>
						 
							
						        </div>										
							</div>
						</div>
								
									<div class="col-sm-12 col-md-10" >
										<label class="control-label" >Descri��o do an�ncio</label>
										<textarea name="desc_anuncio" rows="4" cols="" class="form-control"
											style=" resize: none;" >
											${anFrete.desc_anuncio}
											</textarea>
											
											<input type="hidden" value="${anFrete.id_anuncio}" name="id_anuncio">
											
											<hr>
											 <div class="row" align="right">
                                     <button type="button" onclick="voltarMyAnuncio(${usuarioLogado.id_usuario});"  class="btn btn-danger">Voltar</button>
                                     <button type="submit" class="btn btn-success">Salvar</button>
									</div>
                                     </div>
                                     
                                     
                            </form>
								<!-- FIM FORMULARIO -->
							</div>
							
															<!-- FIM LINHA 1 -->
							
							<!-- FIM PAINEL -->
         </div>
         

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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>

      

<script type="text/javascript" >

$(document).ready(function() {

    function limpa_formul�rio_cep() {
        // Limpa valores do formul�rio de cep.
        $("#rua").val("");
        $("#bairro").val("");
        $("#cidade").val("");
        
        
  
    }
    
    //Quando o campo cep perde o foco.
    $("#cep").blur(function() {

        //Nova vari�vel "cep" somente com d�gitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Express�o regular para validar o CEP.
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
                        //CEP pesquisado n�o foi encontrado.
                        limpa_formul�rio_cep();
                        bootbox.alert({ 
               			   size: "small",
               			   title: "<b>GO</b>TRAN",
               			   message: "<h4>CEP n�o encontrado.</h4>", 
               			   callback: function(){ /* your callback code */ }
               			 })                            }
                });
            } //end if.
            else {
                //cep � inv�lido.
                limpa_formul�rio_cep();
                bootbox.alert({ 
       			   size: "small",
       			   title: "<b>GO</b>TRAN",
       			   message: "<h4>Formato de CEP inv�lido!</h4>", 
       			   callback: function(){ /* your callback code */ }
       			 })	                    }
        } //end if.
        else {
            //cep sem valor, limpa formul�rio.
            limpa_formul�rio_cep();
        }
    });
});

    </script>


</body>
</html>