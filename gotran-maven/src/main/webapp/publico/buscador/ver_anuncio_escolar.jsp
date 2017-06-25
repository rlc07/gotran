<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transporte Escolar</title>

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
                        
                         <!-- Inicio linha 1 -->
                            <div class="row">
                          <!-- Inicio coluna 1 -->
                          <div class="col-md-4 col-sm-10">
                         
                                   <div class="panel panel-default">
										<div class="panel-body" align="center">
										<img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anEscolar.veiculo.img_veiculo}"
										style="width: 280px;" class="img-responsive">
										
										<div align="center">
										<h3><b style="">${anEscolar.nome_empresa }</b></h3>
										</div>
										</div>
									</div>
									
									<div style="margin-top: 30px;">
									
									<b><p>CONTATO</p></b>
									
									<p>${anVeiculo.usuario.nome} ${anVeiculo.usuario.sobre_nome}</p>
									<p><span class="fa fa-envelope-o"></span> ${anVeiculo.usuario.email}</p>
									<p> <c:if test="${anVeiculo.usuario.telefone_cel != '' && anVeiculo.usuario.telefone_cel != null }">
									<span class="fa fa-mobile"></span> ${fone_cel}  <c:if test="${usuarioLogado == null }"><a href="#" onclick="fazerLogin();">mais</a></c:if></c:if></p>
									
									<p> <c:if test="${anVeiculo.usuario.telefone_fixo != '' && anVeiculo.usuario.telefone_fixo != null }">
									<span class="fa fa-phone"></span> ${fone_fixo} <c:if test="${usuarioLogado == null }"><a href="#" onclick="fazerLogin();">mais</a></c:if></c:if></p>
									
									</div>
									
								</div>
                          <!-- Fim coluna 1 -->
                          
                          <!-- Inicio coluna 2 -->
                          <div class="col-sm-12 col-md-8">

									<div class="Panel with panel-warning class">
										<div class="panel-heading">
											<b><span class="fa fa-graduation-cap "> </span> Dados da Instituição</b>
										</div>
										<div class="panel-body">
										
										<table class="table table-bordered table-striped">
										 <thead>
										   <tr>
										      <td><b><span class="fa fa-university"> </span> INSTITUIÇÃO</b></td>
										      <td><b><span class="fa fa-globe"> </span> CIDADE</b></td>
										      
										   </tr>
										 </thead>
										 <tbody>
										    <tr>
										       <td ><c:if test="${int1 != '' }"><h5> ${inst1}</h5></c:if></td>
										       <td><c:if test="${cid1 != '' }"><h5>${cid1}</h5></c:if></td>
										    </tr>
										    
										    <tr>
										    <td ><c:if test="${int2 != '' }"><h5> ${inst2}</h5></c:if></td>
										       <td><c:if test="${cid2 != '' }"><h5>${cid2}</h5></c:if></td>
										       
										    </tr>
										    
										    <tr>
										    <td ><c:if test="${int3 != '' }"><h5> ${inst3}</h5></c:if></td>
										       <td><c:if test="${cid3 != '' }"><h5>${cid3}</h5></c:if></td>
										       
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
                          <div class="Panel with panel-warning class">
										<div class="panel-heading">
											<b><span class="fa fa-bus "> </span> Dados do Veículo</b>
										</div>
										<div class="panel-body">
										
										<!-- Col 1 -->
										<div class="col-sm-12 col-md-4">
										
										<p><b>Marca: </b> ${anEscolar.veiculo.marca }</p>
										
										</div>
										<!-- Fim COl 1 -->
										
										<!-- Col 2 -->
										<div class="col-sm-12 col-md-4">
										
										<p><b>Modelo: </b> ${anEscolar.veiculo.modelo }</p>
										
										</div>
										<!-- Fim Col 2 -->
										
										<!-- Col 3 -->
										<div class="col-sm-12 col-md-2">
										
										<p><b>Ano: </b> ${anEscolar.veiculo.ano }</p>
										
										</div>
										<!-- Fim col 3 -->
										
										<!-- Col 4 -->
										<div class="col-sm-12 col-md-2">
										
										<p><b>Qtd. de assento: </b> ${anEscolar.veiculo.qtd_assento }</p>
										
										</div>
										<!-- Fim col 4 -->
										
								<!-- Col 3 -->
										<div class="col-sm-12 col-md-6">
										
										<p><b>Descrição do veículo: </b> </p>
										<textarea rows="3" cols="" class="form-control" readonly="readonly"
										style=" resize: none;">
										${anEscolar.veiculo.desc_veiculo}
										</textarea>
										
										</div>
										<!-- Fim col 3 -->
										
										</div>
										</div>
                          </div>
                          <!-- Fim col 1 -->
                          </div>
                          <!-- Fim linha 2 -->
                          
                          <hr>
                          <!-- Inicio linha 3 -->
                          <div class="row">
                          <!-- Col 1 -->
                          <div class="col-md-12 col-sm-12">
                          <div class="Panel with panel-warning class">
										<div class="panel-heading">
											<b><span class="fa fa-bullhorn "> </span> Dados do Anúncio</b>
										</div>
										<div class="panel-body">
										
										<!-- Col 1 -->
										<div align="right">
										
										<p><b>Publicado em: </b> ${anEscolar.data_cadastro}</p>
										
										</div>
										<!-- Fim COl 1 -->
										
										<!-- Col 1 -->
										<div class="col-sm-12 col-md-2">
										<p><b>Turno: </b> ${anEscolar.turno}</p>
										
										
										</div>
										<!-- Fim COl 1 -->
										
										<!-- Col 2 -->
										<div class="col-sm-12 col-md-2">
										<p><b>Vagas Disponivel: </b> ${anEscolar.vaga_disp}</p>
										</div>
										<!-- Fim COl 2 -->
										
										
										
										<!-- Col 3 -->
										<div class="col-sm-12 col-md-4">
										<p><c:if test="${anEscolar.valor != '0.0'}"><b>Valor: </b> R$ ${anEscolar.valor}</c:if></p>
										
										<p><c:if test="${anEscolar.valor == '0.0'}"><b>Valor: </b> A COMBINAR</c:if></p>
										</div>
										<!-- Fim COl 3 -->
										
										<!-- Col 4 -->
										<div class="col-sm-12 col-md-6">
									    <textarea rows="3" cols="" readonly="readonly" style="resize: none;"
									    class="form-control">
									    ${anEscolar.desc_anuncio }
									    </textarea>
										</div>
										<!-- Fim COl 4 -->
										
										<div class="col-sm-12 col-md-6">
                           <div align="right" style="margin-right: 10px; margin-top: 30px;">
                           
						 <button type="button" class="btn btn-danger" onclick="Chat();"><span class="fa fa-weixin "></span>
						 Chat</button>
						 
						 
                           
                          </div>
										</div>
										
										
								
										
										</div>
										</div>
                          </div>
                          <!-- Fim col 1 -->
                          
                          </div>
                          <!-- Fim linha 3 -->
                          <!-- Inicio linha 4 -->
                       
                          <!-- Fim linha 4 -->
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