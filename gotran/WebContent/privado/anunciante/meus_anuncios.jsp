<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Meus Anúncios</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css"/>

<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
  
<link href="${pageContext.request.contextPath}/resources/css/fileinput.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
  
</head>
<body>

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
                        <div class="panel-body">
                                 <!-- CONTEUDO -->
                        
                            <!-- INICIO PAINEL MINHA CONTA -->
							<div class="Panel with panel-success class">
								<div class="panel-heading">
									<b>Meus Anúncios</b>
								</div>
								<div class="panel-body">

										<!-- PAINEL - FOTO PERFIL -->
										<div class="row" >
                                         <div class="col-md-4" align="center">
								          <label>Selecione o anúncio desejado</label>
								          <select class="form-control" id="selectAnuncio" onchange="alteraDiv();">
								          <option value="">Selecione uma opção</option>
								          <option value="1">Transporte Escolar</option>
								          <option value="2">Frete\Carreto</option>
								          <option value="3">Excursão</option>
								          <option value="4">Aluguel de vans</option>
								          </select>
								         </div>
								        </div>
                                           <hr>
                                        <!-- Inicio tabela transporte escolar -->
										<div id="escolar" style="display:none; margin-top: 50px;">
                                        
                                        <div class="Panel with panel-warning class">
								<div class="panel-heading">
									<b>Transporte Escolar</b>
								</div>
								<div class="panel-body">
                                       
										    <div align="center">
                                        <h3><c:out value="${msgFrete}"></c:out></h3>
                                          <div class="row">
                                          <table class="row-border hover" cellspacing="0" width="100%" id="tbEscolar">

													<thead>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</thead>
													<tbody>
                                                          <c:forEach items="${listarAnEscolar}" var="anEscolar">
                                                          <tr>
																<td style="width: 10%;">
																<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anEscolar.veiculo.img_veiculo}"
																	style="width: 100px;">
																</td>
																
																<td>
																<b style="font-size: 18px;">${anEscolar.nome_empresa}</b>
																<div style="margin-top: 20px;">
																				<form id="editarAnuncio" method="post"
																					action="${pageContext.request.contextPath}/main?action=editar_anuncio_escolar">
																					<input type="hidden" name="id_usuario"
																						value="${sessionScope.usuarioLogado.id_usuario}"/>
																						
															
																				</form>
																				<a href="${pageContext.request.contextPath}/main?action=editar_anuncio_escolar&id_anuncio=${anEscolar.id_anuncio}
																				&id_usuario=${usuarioLogado.id_usuario}"><samp class="fa fa-pencil-square-o ">
													         </samp>editar</a>
													         
													         <a href="#" id="excluir" onClick="deletarAnEscolar(${anEscolar.id_anuncio}); "  style="color: red; margin-left: 10px;"><samp class="fa fa-trash-o ">
													         </samp>excluir</a>
													         
													           <a href="#" id="ver" onClick=" apagarVeiculo(${veiculo.id_veiculo})"  style="color:goldenrod; margin-left: 10px;"><samp class="fa fa-eye ">
													         </samp>vizualizar</a>
													         
													         </div>
																</td>
																
																<td>
																<b>Cadastro em:</b>
																${anEscolar.data_cadastro}
																<div style="margin-top: 15px;">
																<b style="color: red;">Expira em:</b>
																${anEscolar.data_expira}
																</div>
																</td>
																
																<td>
		                                       <label class="on-off">
												<input type="checkbox" disabled="disabled" name="status" <c:if test="${anEscolar.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>																
																<div style="margin-top: 15px;">
																<b style="color: green;"><c:if test="${anEscolar.valor != 0.0}">${anEscolar.valor}</c:if> </b>
																<b style="color: green;"><c:if test="${anEscolar.valor == 0.0}">a combinar</c:if> </b>
																
																</div>
																</td>
															</tr>
                                                         </c:forEach> 
													</tbody>
												</table>
                                            </div>

                                        </div>
									</div>
                                        </div>
                                      </div>

                                        <!-- Fim tabela transporte escolar -->

                                        <!-- Inicio tabela transporte frete -->
                                        <div id="frete" style="display: none;">
                                                     <div class="Panel with panel-success class">
								<div class="panel-heading">
									<b>Transporte Frete</b>
								</div>
								<div class="panel-body">
                                       
										    <div align="center">
                                        <h3><c:out value="${msgFrete}"></c:out></h3>
                                          <div class="row">
                                          <table class="row-border hover" cellspacing="0" width="100%" id="tbFrete">

													<thead>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</thead>
													<tbody>
                                                          <c:forEach items="${listarAnFrete}" var="anFrete">
                                                          <tr>
																<td style="width: 10%;">
																<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anFrete.veiculo.img_veiculo}"
																	style="width: 100px;">
																</td>
																
																<td>
																<b style="font-size: 18px;">${anFrete.nome_empresa}</b>
																
																 <div style="margin-top: 20px;">
						         
                                 
													         <a href="${pageContext.request.contextPath}/main?action=editar_anuncio_frete&id_anuncio=${anFrete.id_anuncio}&id_usuario=${usuarioLogado.id_usuario}"  ><samp class="fa fa-pencil-square-o ">
													         </samp>editar</a>
													         
													         <a href="#" id="excluir" onClick=" deletarAnFrete(${anFrete.id_anuncio})"  style="color: red; margin-left: 10px;"><samp class="fa fa-trash-o ">
													         </samp>excluir</a>
													         
													           <a href="#" id="ver" onClick=" apagarVeiculo(${veiculo.id_veiculo})"  style="color:goldenrod; margin-left: 10px;"><samp class="fa fa-eye ">
													         </samp>vizualizar</a>
													         
													         </div>
																</td>
																
																<td>
																<b>Cadastro em:</b>
																${anFrete.data_cadastro}
																<div style="margin-top: 15px;">
																<b style="color: red;">Expira em:</b>
																${anFrete.data_expira}
																</div>
																</td>
																
																<td>
		                                       <label class="on-off">
												<input type="checkbox" disabled="disabled" name="status" <c:if test="${anFrete.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>																
																<div style="margin-top: 15px;">
																<b style="color: green;"><c:if test="${anFrete.valor == '0.0'}"> a combinar</c:if></b>
																<b style="color: green;"><c:if test="${anFrete.valor != '0.0'}">R$ ${anFrete.valor}</c:if></b>
																
																</div>
																</td>
															
															
																
																
                                                          
                                                          </tr>
                                                         </c:forEach> 
													</tbody>
												</table>
                                            </div>

                                        </div>
									</div>
								</div>
							</div>
							
										<!-- FIM tabela transporte frete -->
										
										
                                        <!-- Inicio tabela transporte excursao -->
                                        <div id="excursao" style="display: none;">
                                                     <div class="Panel with panel-danger class">
								<div class="panel-heading" >
									<b>Excursão</b>
								</div>
								<div class="panel-body">
                                       
										    <div align="center">
                                        <h3><c:out value="${msgExcursao}"></c:out></h3>
                                          <div class="row">
                                          <table class="row-border hover" cellspacing="0" width="100%" id="tbExcursao">

													<thead>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</thead>
													<tbody>
                                                          <c:forEach items="${listarAnExcursao}" var="anExcursao">
                                                          <tr>
																<td style="width: 10%;">
																<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anExcursao.veiculo.img_veiculo}"
																	style="width: 100px;">
																</td>
																
																<td>
																<b style="font-size: 18px;">${anExcursao.nome_empresa}</b>
																
																 <div style="margin-top: 20px;">
						         
                                 
													         <a href="${pageContext.request.contextPath}/main?action=editar_anuncio_excursao&id_anuncio=${anExcursao.id_anuncio}&id_usuario=${usuarioLogado.id_usuario}"  ><samp class="fa fa-pencil-square-o ">
													         </samp>editar</a>
													         
													         <a href="#" id="excluir" onClick=" deletarAnExcursao(${anExcursao.id_anuncio})"  style="color: red; margin-left: 10px;"><samp class="fa fa-trash-o ">
													         </samp>excluir</a>
													         
													           <a href="#" id="ver" onClick=" apagarVeiculo(${veiculo.id_veiculo})"  style="color:goldenrod; margin-left: 10px;"><samp class="fa fa-eye ">
													         </samp>vizualizar</a>
													         
													         </div>
																</td>
																
																<td>
																<b>Cadastro em:</b>
																${anExcursao.data_cadastro}
																<div style="margin-top: 15px;">
																<b style="color: red;">Expira em:</b>
																${anExcursao.data_expira}
																</div>
																</td>
																
																<td>
			                                <label class="on-off">
												<input type="checkbox" disabled="disabled" name="status" <c:if test="${anExcursao.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>																
																<div style="margin-top: 15px;">
																<b style="color: green;"><c:if test="${anExcursao.valor == '0.0'}">a combinar</c:if></b>
																<b style="color: green;"><c:if test="${anExcursao.valor != '0.0'}">${anExcursao.valor}</c:if></b>
																
																</div>
																</td>
                                                          
                                                          </tr>
                                                         </c:forEach> 
													</tbody>
												</table>
                                            </div>

                                        </div>
										
										
									</div>
								</div>
							</div>
							
										<!-- FIM tabela transporte excursao -->
										
										
												
                                        <!-- Inicio tabela transporte aluguel -->
                                        <div id="aluguel"  style="display: none;">
                                                     <div class="Panel with panel-info class">
								<div class="panel-heading">
									<b>Aluguel de vans</b>
								</div>
								
								<div class="panel-body">
                                       <div align="center">
                                        <h3><c:out value="${msgAluguel}"></c:out></h3>
                                        <div class="row">
                                          <table class="row-border hover" cellspacing="0" width="100%" id="tbAluguel">

													<thead>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</thead>
													<tbody>
                                                          <c:forEach items="${listarAnAluguel}" var="anAluguel">
                                                          <tr>
																<td style="width: 10%;">
																<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anAluguel.veiculo.img_veiculo}"
																	style="width: 100px;">
																</td>
																
																<td>
																<b style="font-size: 18px;">${anAluguel.nome_empresa}</b>
																
																 <div style="margin-top: 20px;">
						         
                                 
													         <a href="${pageContext.request.contextPath}/main?action=editar_anuncio_aluguel&id_anuncio=${anAluguel.id_anuncio}&id_usuario=${usuarioLogado.id_usuario}"  ><samp class="fa fa-pencil-square-o ">
													         </samp>editar</a>
													         
													         <a href="#" id="excluir" onClick=" deletarAnAluguel(${anAluguel.id_anuncio})"  style="color: red; margin-left: 10px;"><samp class="fa fa-trash-o ">
													         </samp>excluir</a>
													         
													           <a href="#" id="ver" onClick=" apagarVeiculo(${veiculo.id_veiculo})"  style="color:goldenrod; margin-left: 10px;"><samp class="fa fa-eye ">
													         </samp>vizualizar</a>
													         
													         </div>
																</td>
																
																<td>
																<b>Cadastro em:</b>
																${anAluguel.data_cadastro}
																<div style="margin-top: 15px;">
																<b style="color: red;">Expira em:</b>
																${anAluguel.data_expira}
																</div>
																</td>
																
																<td>
                                               <label class="on-off">
												<input type="checkbox" disabled="disabled" name="status" <c:if test="${anAluguel.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>																
																<div style="margin-top: 15px;">
																<b style="color: green;"><c:if test="${anAluguel.valor == '0.0'}">a combinar</c:if></b>
																<b style="color: green;"><c:if test="${anAluguel.valor != '0.0'}">${anAluguel.valor}</c:if></b>
																
																</div>
																</td>
                                                          
                                                          </tr>
                                                         </c:forEach> 
													</tbody>
												</table>
												</div>
                                             </div>
									  </div>
								</div>
							</div>
							
										<!-- FIM tabela transporte excursao -->

									</div>
								</div>
							</div>
							<!-- FIM PAINEL MINHA CONTA -->
         
         

                                 <!-- FIM - CONTEUDO -->
                         </div>
                    </div>
                </div>  
            </div>
            
                   <jsp:include page="/template/conf_layout.jsp"></jsp:include>
            
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

<script type="text/javascript">



(function($) {

	  RemoveTableRow = function(handler) {
	    var tr = $(handler).closest('tr');

	    tr.fadeOut(400, function(){ 
	      tr.remove(); 
	    }); 

	    return false;
	  };
	})(jQuery);
</script>
	
<script type="text/javascript">
$(document).ready(function(){
	 $('#tbEscolar').DataTable({
	    	"language": {
         "lengthMenu": " _MENU_ Anúncio por pagina",
         "zeroRecords": "Ops. Você não possui nenhum anúncio ",
         "info": "Mostrando página _PAGE_ de _PAGES_",
         "infoEmpty": "Nenhum registro disponível",
         "infoFiltered": "(filtered from _MAX_ total records)",
         "sSearch":       	"Pesquisar",
         "oPaginate": {
     		"sFirst":    	"Primeiro",
     		"sPrevious": 	"Anterior",
     		"sNext":     	"Próximo"
     	}
                 },

	 
		    });
	    
	} );

$(document).ready(function(){
	 $('#tbFrete').DataTable({
	    	"language": {
        "lengthMenu": " _MENU_ Anúncio por pagina",
        "zeroRecords": "Ops. Você não possui nenhum anúncio ",
        "info": "Mostrando página _PAGE_ de _PAGES_",
        "infoEmpty": "Nenhum registro disponível",
        "infoFiltered": "(filtered from _MAX_ total records)",
        "sSearch":       	"Pesquisar",
        "oPaginate": {
    		"sFirst":    	"Primeiro",
    		"sPrevious": 	"Anterior",
    		"sNext":     	"Próximo"
    	}
                }

		    });
	    
	} );

$(document).ready(function(){
	 $('#tbExcursao').DataTable({
	    	"language": {
       "lengthMenu": " _MENU_ Anúncio por pagina",
       "zeroRecords": "Ops. Você não possui nenhum anúncio ",
       "info": "Mostrando página _PAGE_ de _PAGES_",
       "infoEmpty": "Nenhum registro disponível",
       "infoFiltered": "(filtered from _MAX_ total records)",
       "sSearch":       	"Pesquisar",
       "oPaginate": {
   		"sFirst":    	"Primeiro",
   		"sPrevious": 	"Anterior",
   		"sNext":     	"Próximo"
   	}
               }

		    });
	    
	} );

$(document).ready(function(){
	 $('#tbAluguel').DataTable({
	    	"language": {
      "lengthMenu": " _MENU_ registros por pagina",
      "zeroRecords": "Ops. Você não possui nenhum anúncio ",
      "info": "Mostrando página _PAGE_ de _PAGES_",
      "infoEmpty": "Nenhum registro disponível",
      "infoFiltered": "(filtered from _MAX_ total records)",
      "sSearch":       	"Pesquisar",
      "oPaginate": {
  		"sFirst":    	"Primeiro",
  		"sPrevious": 	"Anterior",
  		"sNext":     	"Próximo"
  	}
              }

		    });
	    
	} );

</script>
<script type="text/javascript">
alteraDiv = function (){

	if($('#selectAnuncio').val() == ""){
    	$("#escolar").hide();
        $("#frete").hide();
        $("#aluguel").hide();
        $("#excursao").hide();
    }
    
    if($('#selectAnuncio').val() == 1){
        $("#escolar").show();
        $("#frete").hide();
        $("#aluguel").hide();
        $("#excursao").hide();
        
        
    }
    
    if($('#selectAnuncio').val() == 2){
    	$("#escolar").hide();
        $("#frete").show();
        $("#aluguel").hide();
        $("#excursao").hide();
    }

    if($('#selectAnuncio').val() == 3){
    	$("#escolar").hide();
        $("#frete").hide();
        $("#aluguel").hide();
        $("#excursao").show();
    }

    if($('#selectAnuncio').val() == 4){
    	$("#escolar").hide();
        $("#frete").hide();
        $("#aluguel").show();
        $("#excursao").hide();
    }
    
}
</script>



</body>
</html>