<%@page import="modelo.Usuario"%>
<%@page import="bo.VeiculoBO"%>
<%@page import="modelo.Veiculo"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Meus Veículos</title>

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
									<b>Meus Veiculos</b>
								</div>
								<div class="panel-body">
									<div class="container-fluid">
                                  <!-- PAINEL - FOTO PERFIL -->
										<div class="row">
                                      
                                      	<div >
				
				<div align="center" class="offset-7">
				<button type="button" class="btn btn-danger" data-toggle="modal"
				 data-target="#modalAddVeiculo">+ Novo Veiculo</button>
			
				</div>
				
				<div style="margin-top: 20px;" align="center">
				<b style="font-family: sans-serif;"><c:out value="${listaVazia}"></c:out></b>
				</div>
						<hr>
						<div class="container">
						 <div class="row">
						    <div class="col-md-10 col-lg-10">
						<table id="tbMyVeiculo" class="table table-hover ">
						
						 <thead>
						    <tr>
						    
						       <td></td>
						       <td></td>
						       <td></td>
						       
						    </tr>
						 </thead>
						 
						 
						 <tbody>
						  
						
						   
						     <c:forEach var="veiculo" items="${listarMyVeiculo}">
						        <tr>
						        
						        <td style="width: 50px;">
						        <img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${veiculo.img_veiculo}" style="width: 100px; ">
						        </td>
						        
						      
						        
						         <td>
						         <b style="font-size: 120%"><c:out value="${veiculo.marca}"></c:out></b></br>
						         <c:out value="${veiculo.modelo}"></c:out></br>
						         
						         <div style="margin-top: 20px;">
						         
                                 
						         <a href="${pageContext.request.contextPath}/main?action=editar-veiculo&id_veiculo=${veiculo.id_veiculo}"  ><samp class="fa fa-pencil-square-o ">
						         </samp>editar</a>
						         
						         <a href="#" id="excluir" onClick=" apagarVeiculo(${veiculo.id_veiculo},${usuarioLogado.id_usuario})"  style="color: red; margin-left: 10px;"><samp class="fa fa-trash-o ">
						         </samp>excluir</a>
						         
						         </div>
						         </td>
						         
						        
						        <td>
						        <b>Cadastrado em</b></br>
						        <c:out value="${veiculo.data_atual }"></c:out></td>
						        
						        </tr>
						     </c:forEach>
						     
						 </tbody>
						 
						 
						</table>
		                     </div>
		                     </div>
		                     </div>
							
		                      </div>

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







<!-- INICIO DO MODAL DE CADASTRO DE VEICULO -->
	<div class="modal fade bs-example-modal-lg" id="modalAddVeiculo" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Cadastrar Veiculo</h4>
				</div>
				<div class="modal-body">
				
				
					

							
									
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


								
							<div class="col-sm-10 col-md-4">
                              
                              <div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" for="senha">Marca*</label>
											<input type="text" class="form-control" name="marca_veiculo"
												id="marca_veiculo">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" >Modelo*</label>
											<input type="text" class="form-control" name="modelo_veiculo"
												id="modelo_veiculo">
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" >Ano*</label>
											<input type="text" class="form-control" name="ano_veiculo"
												id="ano_veiculo" >
									</div>
								</div>
								
								
							</div>


							<!-- COLUNA 2 -->
								<div class="col-sm-10 col-md-4">
                                     <div class="form-group ">
										<div class="col-sm-10">
											<label class="control-label">Qtd. de Assento* </label> 
											<input type="text" class="form-control" name="qtd_assento" id="qtd_assento">
										</div>
									</div>
								
								     
                                     <div class="form-group ">
										<div class="col-sm-10">
										<label class="control-label">Tipo de Combustivel* </label> 
										<select class="form-control " name="combustivel_veiculo" id="combustivel_veiculo">
											<option value="">Selecione o combustivel</option>
										    <option value="Gasolina">Gasolina</option>
											<option value="Gas">Gás</option>
											<option value="Alcool">Álcool</option>
											<option value="Flex">Flex</option>
											<option value="Diesel">Diesel</option>
											
										</select>
									</div>
									</div>
									
									
                                     <div class="form-group">
										<div class="col-sm-10">
										<label class="control-label">Tipo de veiculo* </label> 
										<select class="form-control " name="tipo_veiculo" id="tipo_veiculo">
											<option value="">Selecione a opção</option>
										    <option value="fretado">Veiculo Fretado</option>
											<option value="frete">Veiculo p/ Frete e Carreto</option>
											
											
										</select>
									</div>
									</div>
									
									
                                </div>

							

                              
                            
                                 <div class="col-md-offset-4">
								<div class="form-group">
									<div class="col-sm-10">
										<label class="control-label" for="senha">Descrição*</label>
										<textarea name="desc_veiculo" id="desc_veiculo" rows="" cols="" class="form-control" 
											style=" resize: none;" placeholder="Exemplo: (Wifi, Radio, Tv, etc..)" ></textarea>

									</div>
								</div>
							</div>
							
							
                               
							
							</div>
				  <hr style="width: 880px;">
                              
								<div  align="right" style="margin-right: 10px; margin-top: 90px;">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancelar</button>
									<button type="submit" class="btn btn-primary">Salvar</button>
								</div>
							</form>
						
						
					</div>
				</div>
			</div>
		</div>
	<!-- FIM DO MODAL DE CADASTRO DE VEICULO -->
	


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fileinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/datatables.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js" charset="utf-8"></script>


  <script type="text/javascript">
  $(document).ready(function() {
	    $('#tbMyVeiculo').DataTable({
	    	"language": {
            "lengthMenu": " _MENU_ registros por página",
            "zeroRecords": "Nenhum registro encontrado",
            "info": " página _PAGE_ de _PAGES_",
            "infoEmpty": "Não há registros disponíveis",
            "infoFiltered": "(_MAX_ registros totais)",
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
    defaultPreviewContent: '<img src="${pageContext.request.contextPath}/resources/img/img-icone/sem_foto.jpg" alt="Meu Veiculo" style="width:160px">',
    layoutTemplates: {main2: '{preview} ' +  ' {remove} {browse}'},
    allowedFileExtensions: ["jpg", "png", "gif"]
  });


</script>



</body>
</html>