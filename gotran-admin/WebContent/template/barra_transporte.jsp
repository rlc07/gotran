<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/mapa-busca/css/estiloMapa.css" rel="stylesheet" type="text/css"/>

  <div  style="background-color:#29a9df; " class="row ">
       	<div class="col-sm-2 nav  navbar-nav"  style="background-color:#29a9df; opacity: 0.6;"></div>
				<div class="col-sm-2 nav  navbar-nav" style="background-color:#29a9df; ">
				<form id="BsAnuncioEscolar" method="post"
				action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-escolar">
				<input type="hidden" name="lat_usuario" id="lat_usuario" value="${lat}"/>
				<input type="hidden" name="lon_usuario" id="lon_usuario" value="${lon}"/>
				<input type="hidden" name="cidade_escolar" id="cidade_escolar" value="${cid}">
		</form>
				
						<li ><a onClick="document.getElementById('BsAnuncioEscolar').submit();" href="#" style="color: White; font-size: 15px;"><span class="fa fa-bus "></span> Transporte Escolar</a></li>
				</div>
				
				<div class="col-sm-2 nav  navbar-nav"  style="background-color:#29a9df; ">
				<form id="BsAnuncioFrete" method="post"
										action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-frete">
										<input type="hidden" name="cidade_frete" id="cidade_frete" value="${cid}"/>
										<input type="hidden" name="lat_usuario" id="lat_usuario" value="${lat}"/>
				                        <input type="hidden" name="lon_usuario" id="lon_usuario" value="${lon}"/>
									</form>
						<li><a onClick="document.getElementById('BsAnuncioFrete').submit();" href="#" style="color: White; font-size: 15px;"><span class="fa fa-truck "></span> Frete\Carreto</a></li>
				</div>
				
				<div class="col-sm-2 nav  navbar-nav"  style="background-color:#29a9df; ">
				                      <form id="BsAnuncioExcursao" method="post"
										action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-excursao">
										<input type="hidden" name="cidade_excursao" id="cidade_excursao" value="${cid}"/>
										<input type="hidden" name="lat_usuario" id="lat_usuario" value="${lat}"/>
				                        <input type="hidden" name="lon_usuario" id="lon_usuario" value="${lon}"/>
									</form>
						<li><a onClick="document.getElementById('BsAnuncioExcursao').submit();" href="#" style="color: White; font-size: 15px;"><samp class="fa fa-suitcase "></samp> Excursão</a></li>
				</div>
				
				<div class="col-sm-2 nav  navbar-nav"  style="background-color:#29a9df; ">
				<form id="BsAnuncioAluguel" method="post"
						action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-aluguel">
					   <input type="hidden" name="cidade_aluguel" id="cidade_aluguel" value="${cid}"/>
					   <input type="hidden" name="lat_usuario" id="lat_usuario" value="${lat}"/>
				<input type="hidden" name="lon_usuario" id="lon_usuario" value="${lon}"/>
				</form>
						<li><a onClick="document.getElementById('BsAnuncioAluguel').submit();" href="#" style="color: White; font-size: 15px;"><span class="fa fa-bus "></span> Aluguel de Van</a></li>
			   </div>
		</div>




<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsBuscador.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>