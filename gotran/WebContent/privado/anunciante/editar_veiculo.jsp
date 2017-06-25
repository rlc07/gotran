<%@page import="modelo.Usuario"%>
<%@page import="bo.VeiculoBO"%>
<%@page import="modelo.Veiculo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Atualizar - Veiculo</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css"/>

<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/fileinput.css" rel="stylesheet" type="text/css"/>
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
                        <div class="panel-body">
                                 <!-- CONTEUDO -->
                        
                            <!-- INICIO PAINEL MINHA CONTA -->
							<div class="panel panel-primary span9 panelMinhaConta">
								<div class="panel-heading">
									<b>Atualizar Veiculos</b>
								</div>
								<div class="panel-body">
									<div class="container-fluid">
                                  <!-- PAINEL - FOTO PERFIL -->
										<div class="row">
                                      <form  method="post" enctype="multipart/form-data" id="fmAddVeiculo">
								 					<div class="row">
								 <div class="col-sm-6 col-md-4">
								 <div class="panel panel-default">
                              <div class="panel-body text-center">
                              
								 <input type="hidden" class="form-control" id="id_usuario"
										name="${sessionScope.usuarioLogado.id_usuario}"
										value="${sessionScope.usuarioLogado.id_usuario}">
										
										<div class="kv-avatar center-block" style="width: 200px">
												<input id="avatar-1" name="avatar-1" type="file" class="file-loading">
													</div>
                                    
                                    
                                    <div id="kv-avatar-errors-1" class="center-block"
													style="width: 600px; display: none"></div>
												<!-- FIM PAINEL - FOTO PERFIL -->
							</div>
							</div>
							
							</div>

							<!-- Formulario do veiculo -->


								
							<div class="col-sm-12 col-md-4">
                              
                                <div class="form-group ">
									<div class="col-sm-10">
										<label class="control-label" for="senha">Marca*</label>
											<input type="text" class="form-control" name="marca_veiculo"
												id="marca_veiculo" value="${veiculo.marca}">
									</div>
								</div>

								<div class="form-group fmAtVeiculo">
									<div class="col-sm-10">
										<label class="control-label" >Modelo*</label>
											<input type="text" class="form-control" name="modelo_veiculo"
												id="modelo_veiculo" value="${veiculo.modelo}">
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" >Ano*</label>
											<input type="text" class="form-control" name="ano_veiculo"
												id="ano_veiculo" value="${veiculo.ano}">
									</div>
								</div>
								
								
							</div>


							<!-- COLUNA 2 -->
								<div class="col-sm-10 col-md-4">
                                     <div class="form-group ">
										<div class="col-sm-10">
											<label class="control-label">Qtd. de Assento* </label> 
											<input type="text" class="form-control" name="qtd_assento" id="qtd_assento" 
											value="${veiculo.qtd_assento}">
										</div>
									</div>
								
								     
                                     <div class="form-group ">
										<div class="col-sm-10">
										<label class="control-label">Tipo de Combustivel* </label> 
										<select class="form-control " name="combustivel_veiculo" id="combustivel_veiculo">
										    <option value="Gasolina" <c:if test="${veiculo.combustivel == 'Gasolina'}"><c:out value= "selected=selected"/></c:if>>Gasolina</option>
											<option value="Gas" <c:if test="${veiculo.combustivel == 'Gas' }"><c:out value="selected=selected"/></c:if>>Gás</option>
											<option value="Alcool" <c:if test="${veiculo.combustivel == 'Alcool'}"><c:out value="selected=selected" /></c:if> >Álcool</option>
											<option value="Flex" <c:if test="${veiculo.combustivel == 'Flex'}"><c:out value="selected=selected" /></c:if> >Flex</option>
											<option value="Diesel" <c:if test="${veiculo.combustivel == 'Diesel'}"><c:out value="selected=selected" /></c:if> >Diesel</option>
											
										</select>
									</div>
									</div>
									
									
                                     <div class="form-group">
										<div class="col-sm-10">
										<label class="control-label">Tipo de veiculo* </label> 
										<select class="form-control " name="tipo_veiculo" id="tipo_veiculo">
										
										    <option value="fretado" <c:if test="${veiculo.tipo_veiculo == 'fretado'}"><c:out value= "selected=selected"/></c:if>>Veiculo Fretado</option>
											<option value="frete" <c:if test="${veiculo.tipo_veiculo == 'frete'}"><c:out value= "selected=selected"/></c:if>>Veiculo p/ Frete e Carreto</option>
											
										</select>
									</div>
									</div>
		
									
									
                                </div>

							

                              
                            
                                 <div class="col-md-offset-4">
								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label">Descrição*</label>
										<textarea name="desc_veiculo" rows="" cols="" class="form-control" 
											style=" resize: none; text-align: left;" >
											${veiculo.desc_veiculo}</textarea>

									</div>
								</div>
								
								<input type="hidden" value="${veiculo.id_veiculo}" name="id_veiculo">
							</div>
							
							
                         </div>
                         
                        
				  <hr style="width: 880px;">
                              
								<div  align="right" style="margin-right: 10px; margin-top: 90px;">
									<button type="button" class="btn btn-default" onclick="voltarMyVeiculo(${usuarioLogado.id_usuario});">Voltar</button>
										
									<button type="submit" class="btn btn-primary">Atualiar</button>
								</div>
							</form>
                                      

										</div>
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
	 </div>








	



<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fileinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/datatables.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js" ></script>


<script type="text/javascript">

var img = $("#img_veiculo").val();

var t =$("#avatar-1").fileinput({
    overwriteInitial: true,
    maxFileSize: 1500,
    showClose: false,
    showCaption: false,
    browseLabel: '',
    removeLabel: '',
    browseIcon: '<i class="fa fa-folder-open "></i>',
    removeIcon: '<i class="fa fa-times"></i>',
    removeTitle: 'Cancelar',
    elErrorContainer: '#kv-avatar-errors-1',
    msgErrorClass: 'alert alert-block alert-danger',
    defaultPreviewContent: '<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${veiculo.img_veiculo}" alt="Meu Veiculo" style="width:160px">',
    layoutTemplates: {main2: '{preview} ' +  ' {remove} {browse}'},
    allowedFileExtensions: ["jpg", "png", "gif"]
  });


</script>



</body>
</html>