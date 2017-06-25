<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Anunciar - Transporte Escolar</title>
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
										
										<!-- INICIO FORMULARIO -->
											
										<form  method="POST" id="fmCadAnEs">
										<div class="col-sm-12 col-md-4">
											    <div class="form-group ">
										<label class="control-label">Veiculo*</label> 
										<select class="form-control " id="veiculo"  name="veiculo">
											<option value="">Selecione o veiculo</option>
														<c:forEach var="vec" items="${carregarSelect}">
															<option value="${vec.id_veiculo}">
																${vec.modelo}</option>
														</c:forEach>
													</select>
									</div>
									
										 <div class="form-group">
										 <label>Titulo*</label>
										 <input type="text" placeholder="Ex.:(Gotran Transportes Escolares)"
										 class="form-control" name="titulo" id="titulo">
										 </div>
									
										 
										 <div class="form-group">
										 <label>Valor</label>
										 <input type="text" placeholder="Ex.:(100,00)"
										 class="form-control" data-symbol="R$" name="valor" id="valor">
										 </div>
										 
								 </div>
								 
								 <!-- Segunda coluna -->
								 
								 		<div class="col-sm-12 col-md-4">
										
										
										 
										    <div class="form-group ">
										<label class="control-label">Turno*</label> 
										<select class="form-control " name="turno_escolar" id="turno_escolar">
											<option value="">Selecione o turno</option>
										    <option value="manha">Manhã</option>
											<option value="tarde">Tarde</option>
											<option value="noite">Noite</option>
											<option value="integral">Integral</option>
											
										</select>
									</div>
										
										<div class="form-group">
										 <label>Vagas disponivel*</label>
										 <input type="text" placeholder="Ex.:(6)"
										 class="form-control" name="vaga_escolar" id ="vaga_escolar">
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
										 <label>Instituição 1*</label>
										 <input type="text" class="form-control" placeholder="Informe o nome da instituição"
										 name="instituicao1" id="instituicao1" >
										 </div>
										 
										   <div class="form-group col-md-8" >
										 <label>Instituição 2</label>
										 <input type="text" class="form-control" placeholder="Informe o nome da instituição"
										 name="instituicao2" id="instituicao2">
										 </div>
										 
										  <div class="form-group col-md-8"  >
										 <label>Instituição 3</label>
										 <input type="text" class="form-control" placeholder="Informe o nome da instituição"
										 name="instituicao3" id="instituicao3">
										 </div>
									</div>
									
									<!-- INICIO COLUNA CIDADE -->
									<div class="col-sm-12 col-md-6">
                                         
                                         <div class="form-group col-md-8"  >
										 <label>Cidade\Estado 1*</label>
										 <input type="text" class="form-control" placeholder="Informe a cidade\estado"
										 name="cidade1" id="cidade1">
										 
										 </div>
										 
										   <div class="form-group col-md-8" >
										 <label>Cidade\Estado 2</label>
										 <input type="text" class="form-control" placeholder="Informe a cidade\estado"
										 name="cidade2" id="cidade2">
										 </div>
										 
										  <div class="form-group col-md-8">
										 <label>Cidade\Estado 3</label>
										 <input type="text" class="form-control" placeholder="Informe a cidade\estado"
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
								<div class="col-md-4 row" >
								<input type="text" id="searchInput" name="searchInput"
									placeholder="Informe a sua cidade" class="form-control " /> 
								</div>
								
								
								<div id="map" style="height: 400px;"></div>
								<div id="options" >
									<input type="hidden" value="1" min="0" id="radiusInput" 
										name="radiusInput" autofocus /> 
										<select id="unitSelector" name="unitSelector" disabled="disabled">
										<option value="km"> Raio de 1 Km</option>
										<option value="mt">Metros</option>

									</select>
									<p>Click com o botão direito para remover o circulo</p>
								</div>
								
							<input type="hidden" name="lat1" id="lat1" >
							<input type="hidden" name="long1" id="long1">
							<input type="hidden" name="raio1" id="raio1">
							<input type="hidden" name="mt1" id="mt1">
							
							 <input type="hidden" name="lat2" id="lat2">
							 <input type="hidden" name="long2" id="long2">
							 <input type="hidden" name="raio2" id="raio2">
							 <input type="hidden" name="mt2" id="mt2">
							
							 <input type="hidden" name="lat3" id="lat3">
							 <input type="hidden" name="long3" id="long3">
							 <input type="hidden" name="raio3" id="raio3">
							 <input type="hidden" name="mt3" id="mt3">
							 
							 <input type="hidden" name="lat4" id="lat4">
							 <input type="hidden" name="long4" id="long4">
							 <input type="hidden" name="raio4" id="raio4">
							 <input type="hidden" name="mt4" id="mt4">
							 
							 <input type="hidden" name="lat5" id="lat5">
							 <input type="hidden" name="long5" id="long5">
							 <input type="hidden" name="raio5" id="raio5">
							 <input type="hidden" name="mt5" id="mt5">
							 
							 <input type="hidden" name="lat6" id="lat6">
							 <input type="hidden" name="long6" id="long6">
							 <input type="hidden" name="raio6" id="raio6">
							 <input type="hidden" name="mt6" id="mt6">
							
							  </div>
							 </div>
							
							</div>
							</div>
							
							<hr>
								 <div class="row">
								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" >Descrição do anúncio</label>
										<textarea name="desc_anuncio" rows="4" cols="" class="form-control" 
											style=" resize: none;" placeholder="Escreva algo sobre o seu anúncio..." ></textarea>

									</div>
								</div>
							</div>
								 <!-- FIM TERCEIRA LINHA - MAPA -->
								 <hr>
								 <input type="hidden" name="id_usuario" id="id_usuario" value="${usuarioLogado.id_usuario}">
								   <div align="right" style="margin-top: 10px;">
								   <button type="submit" class="btn btn-success">Salvar</button>
									 <button type="reset" class="btn btn-danger">Cancelar</button>
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

<script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDanv8HnOiFtaLoQ7tNzc5v82Kuxm2SEoU&amp;libraries=places"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/zepto/1.0/zepto.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/maps/js/gmaps-radius.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js" charset="UTF-8"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<!-- DATA -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/ui.datepicker-pt-BR.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
      <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>




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



</body>
</html>