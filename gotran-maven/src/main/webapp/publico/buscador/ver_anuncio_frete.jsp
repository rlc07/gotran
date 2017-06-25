<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Frete\Carreto</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>



<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/resources/mapa-busca/css/estiloMapa.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background-color: #ddd;">
    
    <jsp:include page="/template/cabecalho_buscador.jsp"></jsp:include>
  

       <!-- iNICIO CONTAINER -->
       <div class="container buscaDiv" style="background-color: White; margin-top: 30px;">
       
    
         <div style="margin-top: 30px;" class="buscaDiv">
                                 <!-- CONTEUDO -->
                                 <!-- CONTEUDO -->
                        
                         <!-- Inicio linha 1 -->
                            <div class="row">
                          <!-- Inicio coluna 1 -->
                          <div class="col-md-4 col-sm-10">
                         
                                   <div class="panel panel-default">
										<div class="panel-body" align="center">
										<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anFrete.veiculo.img_veiculo}"
										style="width: 280px;" class="img-responsive">
										
										<div align="center">
										<h3><b style="">${anFrete.nome_empresa}</b></h3>
										</div>
										</div>
									</div>
									
									<div style="margin-top: 30px;">
									
									<b><p>CONTATO</p></b>
									
									<p>${anVeiculo.usuario.nome} ${anVeiculo.usuario.sobre_nome}</p>
									<p><span class="fa fa-envelope-o"></span> ${anVeiculo.usuario.email}</p>
									<p> <c:if test="${anVeiculo.usuario.telefone_cel != '' && anVeiculo.usuario.telefone_cel != null }">
									<span class="fa fa-mobile"></span> ${fone_cel}<c:if test="${usuarioLogado == null }"><a href="#" onclick="fazerLogin();">mais</a></c:if></c:if></p>
									
									<p> <c:if test="${anVeiculo.usuario.telefone_fixo != '' && anVeiculo.usuario.telefone_fixo != null }">
									<span class="fa fa-phone"></span> ${fone_fixo}<c:if test="${usuarioLogado == null }"><a href="#" onclick="fazerLogin();">mais</a></c:if></c:if></p>
									
									</div>
									
								</div>
                          <!-- Fim coluna 1 -->
                          
                          <!-- Inicio coluna 2 -->
                          <div class="col-sm-12 col-md-8">

									<div class="Panel with panel-success class">
										<div class="panel-heading">
											<b><span class="fa fa-truck "> </span> Dados do Veículo</b>
										</div>
										<div class="panel-body" >
										
										<table class="table table-bordered table-striped">
										 <thead>
										   <tr>
										   
										      <td><b><span class="fa fa-globe"> </span> MARCA</b></td>
										      <td><b><span class="fa fa-globe"> </span> MODELO</b></td>
										      <td><b><span class="fa fa-globe"> </span> ANO</b></td>
										      <td><b><span class="fa fa-globe"> </span> COMBUSTIVEL</b></td>
										      <td><b><span class="fa fa-globe"> </span> QTD. ASSENTO</b></td>
										      
										   </tr>
										 </thead>
										 <tbody>
										    <tr>
										       <td >${anVeiculo.marca}</td>
										       <td>${anVeiculo.modelo}</td>
										       <td >${anVeiculo.ano}</td>
										       <td >${anVeiculo.combustivel}</td>
										       <td >${anVeiculo.qtd_assento}</td>
										   </tr>
										  
										 </tbody>										
										</table>
																				
										</div>
									</div>

								</div>
                          <!-- fim coluna 2 -->
                          </div>
                          <!-- Fim linha1 -->
                          <hr>
                          <!-- Inicio linha 2 -->
                          <div class="row">
                          <!-- Col 1 -->
                          <div class="col-md-12 col-sm-12">
                          <div class="Panel with panel-success class">
										<div class="panel-heading">
											<b><span class="fa fa fa-bullhorn "> </span> Dados do Anúncio</b>
										</div>
										<div class="panel-body">
										
										<!-- Col 1 -->
										<div align="right">
										 <p><b>Publicado em:</b> ${anFrete.data_cadastro}</p>
										</div>
										<!-- Fim COl 1 -->
										
										<!-- Col 2 -->
										<div class="col-sm-12 col-md-10">
										
										<p><b>Endereço: </b><c:if test="${anFrete.rua != null || anFrete.rua != ''}">
										${anFrete.rua}, </c:if> <c:if test="${anFrete.numero == 0 }">S\N </c:if> 
										<c:if test="${anFrete.numero != 0 }"> ${anFrete.numero} </c:if> 
										<c:if test="${anFrete.bairro != null || anFrete.bairro != ''}">${anFrete.bairro}, </c:if>
										<c:if test="${anFrete.bairro == null || anFrete.bairro == ''}">S\B, </c:if>
										${anFrete.cidade }</p>
										
										</div>
										<!-- Fim Col 2 -->
										
										<!-- Col 3 -->
										<div class="col-sm-12 col-md-4">
										
										<p><b>Carga Suportada: </b> ${carga} </p>
										
										</div>
										<!-- Fim col 3 -->
										
										<!-- Col 4 -->
										<div class="col-sm-12 col-md-4">
										
										<p><b>Viaja p/ outro estado: </b> <c:if test="${anFrete.disp_viagem == false}">Sim</c:if>
										<c:if test="${anFrete.disp_viagem == true}">Não</c:if></p>
										
										</div>
										<!-- Fim col 4 -->
										
											<!-- Col 4 -->
										<div class="col-sm-12 col-md-4">
										
										<p><b>Valor: </b> <c:if test="${anFrete.valor == '0.0'}">A COMBINAR</c:if>
										<c:if test="${anFrete.valor != '0.0'}">A partir de R$ ${anFrete.valor}</c:if></p>
										
										</div>
										<!-- Fim col 4 -->
										
								<!-- Col 3 -->
										<div class="col-sm-12 col-md-6">
										
										<p><b>Descrição do anúncio: </b> </p>
										<textarea rows="4" cols="" class="form-control" readonly="readonly"
										style=" resize: none;">
										${anFrete.desc_anuncio}
										</textarea>
										
										</div>
										<!-- Fim col 3 -->
								</div>
					
					<hr>
                          <div class="row"></div>
                      
                      <div class="col-md-12" align="right" style="margin-top: -30px;">
                     		 <button type="button" class="btn btn-danger" onclick="Chat();"><span class="fa fa-weixin "></span>
						 Chat</button>
						 
						
						 <div style="margin-top: 10px;">
						 
						 </div>
                      </div>
                      
						</div>
                          </div>
                          <!-- Fim col 1 -->
                          </div>
                          <!-- Fim linha 2 -->
                          
                     
                  
                                 <!-- FIM - CONTEUDO -->
                        
            </div>
       </div>
       <!-- fIM CONTAIER -->
    
    <jsp:include page="/template/rodape_buscador.jsp"></jsp:include>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsBuscador.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>



<script type="text/javascript" >

        

$(document).ready(function(){
	 $('#tbBuscarEscolar').DataTable({
	    "language": {
        "lengthMenu": " _MENU_ Anúncio por pagina",
        "zeroRecords": "<h3>Ops, não existe nenhum anúncio escolar disponivel no momento!<h3>",
        "info": "Mostrando página _PAGE_ de _PAGES_",
        "infoEmpty": "Nenhum registro disponíveis",
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


</script>

</body>
</html>