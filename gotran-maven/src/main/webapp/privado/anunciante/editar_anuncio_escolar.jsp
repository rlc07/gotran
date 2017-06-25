<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Editar Anúncio - Transporte Escolar</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css"/>

<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet" type="text/css"/>

<script src="http://code.jquery.com/jquery-latest.js"></script>

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
                        <div class="panel-body">
                                 <!-- CONTEUDO -->
                        
                                <!-- INICIO PAINEL AZUL -->

							<div class="Panel with panel-warning class">
								<div class="panel-heading">
									<b>Transporte Escolar</b>
								</div>
								<div class="panel-body">
							<!-- INICIO DA LINHA -->
								<div class="row">
								
								<!-- IMAGEM DO VEICULO -->
								     <div class="col-sm-12 col-md-4">
										<div class="Panel with panel-default class span9 panel">
											<div class="panel-heading">
												<b>Imagem do Veículo</b>
											</div>
											<div class="panel-body">
											   <div class="text-center">
												   <img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anEscolar.veiculo.img_veiculo }"
												 style="width: 200px;" class=" img-rounded" id="img_veiculo" name="img_veiculo"/>
                                              	</div>
                                           
                                        <div class="col-sm-12 col-md-2" style="margin-top: 20px;">
                                          	
                                        <div class="form-group" >
                                        <label>Marca</label>
									    <input type="text" name="marca" id="marca" disabled="disabled" value="${anEscolar.veiculo.marca}">
									    </div>
									    
                                         <div class="form-group" >
                                        <label>Modelo</label>
									    <input type="text" name="modelo" id="modelo" disabled="disabled" value="${anEscolar.veiculo.modelo}">
									    </div>
									    </div> 	
									    		<input type="hidden" value="${anEscolar.veiculo.qtd_assento}" id="qtd_assento_at" name="qtd_assento_at">							
											</div>
										</div>
									 </div>
										<!-- FIM IMG VEICULO -->
										
										<!-- INICIO FORMULARIO -->
											
										<form  method="POST" id="fmAtAnEs">
										
										       												
													<div class="col-sm-12 col-md-4">
														<div class="form-group ">
															<label class="control-label">Veículo*</label> <select
																class="form-control " id="veiculo" name="veiculo">
																<c:forEach var="vec" items="${carregarSelect}">
																	<option value="${vec.id_veiculo}"
																		<c:if test="${vec.modelo == anEscolar.veiculo.modelo }">
														<c:out value="selected=selected"/></c:if>>
																		${vec.modelo}</option>
																</c:forEach>
															</select>
														</div>

														<div class="form-group">
															<label>Titulo*</label> <input type="text"
																value="${anEscolar.nome_empresa}" class="form-control"
																name="titulo" id="titulo">
														</div>


														<div class="form-group">
															<label>Valor</label> <input type="text"
																value="${anEscolar.valor}" class="form-control"
																data-symbol="R$" name="valor" id="valor">
														</div>

													</div>

													<!-- Segunda coluna -->

													<div class="col-sm-12 col-md-4">

                                                    

														<div class="form-group ">
															<label class="control-label">Turno*</label> <select
																class="form-control " name="turno_escolar"
																id="turno_escolar">
																<option value="manha"
																	<c:if test="${anEscolar.turno == 'manha'}"><c:out value="selected=selected"/></c:if>>Manhã</option>
																<option value="tarde"
																	<c:if test="${anEscolar.turno == 'tarde'}"><c:out value="selected=selected"/></c:if>>Tarde</option>
																<option value="noite"
																	<c:if test="${anEscolar.turno == 'noite'}"><c:out value="selected=selected"/></c:if>>Noite</option>
																<option value="integral"
																	<c:if test="${anEscolar.turno == 'integral'}"><c:out value="selected=selected"/></c:if>>Integral</option>

															</select>
														</div>

														<div class="form-group">
															<label>Vagas disponivel*</label> <input type="text"
																value="${anEscolar.vaga_disp}" class="form-control"
																name="vaga_escolar" id="vaga_escolar">
														</div>
														
														    <div class="form-group">
															<label>Desativado\Ativado</label></br>
												<label class="on-off">
												<input type="checkbox" name="status" <c:if test="${anEscolar.status == true}">checked="checked"</c:if> /> 
												<span><a></a></span>
												</label>
														</div>
														



													</div>

													<!-- INICIO SEGUNDA LINHA - INSTITUICAO -->
													<div class="row">
														<div class="col-sm-12 col-md-12">

															<div class="Panel with panel-warning class">
																<div class="panel-heading">
																	<b>Instituição</b>
																</div>
																<div class="panel-body">

																	<div class="col-sm-12 col-md-6">

																		<div class="form-group col-md-8">
																			<label>Instituição 1*</label> <input type="text"
																				class="form-control" value="${anEscolarInt1}"
																				name="instituicao1" id="instituicao1">
																		</div>

																		<div class="form-group col-md-8">
																			<label>Instituição 2</label> <input type="text"
																				class="form-control" value="${anEscolarInt2}"
																				name="instituicao2" id="instituicao2">
																		</div>

																		<div class="form-group col-md-8">
																			<label>Instituição 3</label> <input type="text"
																				class="form-control" value="${anEscolarInt3}"
																				name="instituicao3" id="instituicao3">
																		</div>
																	</div>

																	<!-- INICIO COLUNA CIDADE -->
																	<div class="col-sm-12 col-md-6">

																		<div class="form-group col-md-8">
																			<label>Cidade\Estado 1*</label> <input type="text"
																				class="form-control" value="${anEscolarCid1}"
																				name="cidade1" id="cidade1">

																		</div>

																		<div class="form-group col-md-8">
																			<label>Cidade\Estado 2</label> <input type="text"
																				class="form-control" value="${anEscolarCid2}"
																				name="cidade2" id="cidade2">
																		</div>

																		<div class="form-group col-md-8">
																			<label>Cidade\Estado 3</label> <input type="text"
																				class="form-control" value="${anEscolarCid3}"
																				name="cidade3" id="cidade3">
																		</div>

																	</div>
																	<!-- FIM COLUNA CIDADE -->
																</div>
															</div>
														</div>
													</div>
													<!-- FIM SEGUNDA LINHA -->

													<hr>
													<!-- INICIO TERCEIRA LINHA - MAPA -->
													<div class="row">
														<div class="col-sm-12 col-md-12">
															<div class="Panel with panel-warning class">
																<div class="panel-heading">
																	<b>Mapa</b>
																</div>
																<div class="panel-body">
																	<div class="col-md-4 row">
																		<input type="text" id="searchInput" name="searchInput"
																			placeholder="Informe a sua cidade"
																			class="form-control " />
																	</div>


																	<div id="map" style="height: 400px;"></div>
																	<div id="options">
																		<label for="radiusInput">Quantidade</label> <input
																			type="number" value="1" min="0" id="radiusInput"
																			name="radiusInput" autofocus /> <label
																			for="unitSelector">Marcar por:</label> <select
																			id="unitSelector" name="unitSelector">
																			<option value="km">Km</option>
																			<option value="mt">Metros</option>

																		</select>
																		<p>Click com o botão direito para remover o
																			circulo</p>
																	</div>

																	<input type="hidden" name="lat1" id="lat1"
																		value="${lat1}"> <input type="hidden"
																		name="long1" id="long1" value="${lon1}"> <input
																		type="hidden" name="raio1" id="raio1" value="${raio1}">
																	<input type="hidden" name="mt1" id="mt1" value="${m1}">

																	<input type="hidden" name="lat2" id="lat2"
																		value="${lat2}"> <input type="hidden"
																		name="long2" id="long2" value="${lon2}"> <input
																		type="hidden" name="raio2" id="raio2" value="${raio2}">
																	<input type="hidden" name="mt2" id="mt2" value="${m2}">

																	<input type="hidden" name="lat3" id="lat3"
																		value="${lat3}"> <input type="hidden"
																		name="long3" id="long3" value="${lon3}"> <input
																		type="hidden" name="raio3" id="raio3" value="${raio3}">
																	<input type="hidden" name="mt3" id="mt3" value="${m3}">

																	<input type="hidden" name="lat4" id="lat4"
																		value="${lat4}"> <input type="hidden"
																		name="long4" id="long4" value="${lon4}"> <input
																		type="hidden" name="raio4" id="raio4" value="${raio4}">
																	<input type="hidden" name="mt4" id="mt4" value="${m4}">

																	<input type="hidden" name="lat5" id="lat5"
																		value="${lat5}"> <input type="hidden"
																		name="long5" id="long5" value="${lon5}"> <input
																		type="hidden" name="raio5" id="raio5" value="${raio5}">
																	<input type="hidden" name="mt5" id="mt5" value="${m5}">

																	<input type="hidden" name="lat6" id="lat6"
																		value="${lat6}"> <input type="hidden"
																		name="long6" id="long6" value="${lon6}"> <input
																		type="hidden" name="raio6" id="raio6" value="${raio6}">
																	<input type="hidden" name="mt6" id="mt6" value="${m6}">

																</div>
															</div>

														</div>
													</div>

													<hr>
													<div class="row">
														<div class="form-group">
															<div class="col-sm-10">
																<label class="control-label">Descrição do anúncio</label>
																<textarea name="desc_anuncio" rows="4" cols=""
																	class="form-control" style=" resize: none;">
											${anEscolar.desc_anuncio}
											</textarea>

															</div>
														</div>
													</div>
													<input type="hidden" value="${anEscolar.id_anuncio }"
														name="id_anuncio">
													<!-- FIM TERCEIRA LINHA - MAPA -->
													<hr>
													<div align="right" style="margin-top: 10px;">
														<button type="button" onclick="voltarMyAnuncio(${usuarioLogado.id_usuario});" class="btn btn-danger">Voltar</button>
													  <button type="submit" class="btn btn-success">Atualizar</button>
													</div>
										</form>
												
										<!-- FIM FORMULARIO -->
								
								</div>
								<!-- FIM DA LINHA -->
								
								</div>
							</div>

							<!-- FIM PAINEL AZUL -->
                                 <!-- FIM - CONTEUDO -->
                         </div>
                    </div>
                </div>  
            </div>
            
                   <jsp:include page="/template/conf_layout.jsp"></jsp:include>
            
        </div>
	         

     
</div>




<script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDanv8HnOiFtaLoQ7tNzc5v82Kuxm2SEoU&amp;libraries=places"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/zepto/1.0/zepto.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/lodash/4.12.0/lodash.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/maps/js/gmaps-radius.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fileinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>


	







</body>
</html>