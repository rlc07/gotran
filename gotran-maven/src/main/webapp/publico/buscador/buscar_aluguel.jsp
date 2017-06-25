<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Transporte - Aluguel</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <link href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>



<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/resources/mapa-busca/css/estiloMapa.css" rel="stylesheet" type="text/css"/>
</head>
<body  style="background-color: #C7C7C7;">
    
    <jsp:include page="/template/cabecalho_buscador.jsp"></jsp:include>
    <jsp:include page="/template/barra_transporte.jsp"></jsp:include>
    

       <!-- iNICIO CONTAINER -->
       <div class="container conteudoEscolar" style=" margin-top: 20px; background-color:  #ffffff;">
       
      
       <!-- Linha 1 -->
       <div class="row" style="margin-top: 60px;">
       <div class="col-md-12">
        <form method="POST" action="${pageContext.request.contextPath}/buscar?action=buscar-anuncio-aluguel">
      
         
          <div class="form-group col-md-4">
                   <label><span class="fa fa-globe "></span> Cidade\Estado</label>
                              <input type="text" class="form-control" name="cidadeFiltro" value="${cidFiltro}">
                    
                     <div align="right" style="margin-top: 10px;">
                              <button type="submit" class="btn btn-primary" id="btnFiltro">
                             	<span class="fa fa-search"></span> Buscar</button>
                             </div>
         </div>
         
   
                                     <input type="hidden" value="${lat}" name="lat_usuario">
									<input type="hidden" value="${lon}" name="lon_usuario">
									<input type="hidden" value="${cid}" name="cidade_aluguel">
									
                          
        </form>
       </div>
       </div>
       <!-- Fim linha 1 -->
       <hr><hr>
             <!-- Linha 2 -->
             <div class="row">
              <div class="col-md-12">
              
                                <table class="row-border hover" id="tbBuscarAluguel">
                                  <thead>
                                     <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        
                                     </tr>
                                  </thead> 
                                  <tbody>
                                     <c:forEach items="${lsAluguel}" var="anAluguel">
                                          <tr>
                                           
                                           
                                           <td style="width: 180px;">
                                           <img src="http://localhost:8080/gotran/img_gotran/img_veiculo/${anAluguel.veiculo.img_veiculo}" 
                                           style="height: 100px;" class="img-responsive img-thumbnail" >
                                           </td>
                                           
                                           <td>
                                           <a href="${pageContext.request.contextPath}/buscar?action=vizualizar-anuncio-aluguel&id_anuncio=${anAluguel.id_anuncio}" ><b style="font-size: 17px;">${anAluguel.nome_empresa}</b></a>
                                           
                                           <div style="margin-top: 30px;">
                                           ${anAluguel.cidade}
                                           </div>
                                           </td>
                                           
                                           <td></td>
                                           <td></td>
                                           
                                           <td>
                                           <b>A PARTIR DE:</b></br>
                                           <b style="color:green;"><c:if test="${anAluguel.valor == '0.0'}">A COMBINAR</c:if></b>
                                           <b style="color:green;"><c:if test="${anAluguel.valor != '0.0'}">R$ ${anAluguel.valor}</c:if></b>
                                           
                                           <div style="margin-top: 20px;">
                                           Publicado em: ${anAluguel.data_cadastro}
                                           </div>
                                           </td>
                                            
                                         
                                                                                    
                                          
                                          </tr>
                                     </c:forEach>                                  
                                  </tbody>                             
                              </table>
              </div>
             </div>
             <!-- Fim linha 2 -->
       
       
       </div>
       <!-- fIM CONTAIER -->
    
    <jsp:include page="/template/rodape_buscador.jsp"></jsp:include>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsBuscador.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>



<script type="text/javascript">
$(document).ready(function(){
	 $('#tbBuscarAluguel').DataTable({
	    "language": {
        "lengthMenu": " _MENU_ Anúncio por pagina",
        "zeroRecords": "<h3>Ops, não existe nenhum anúncio de aluguel disponivel no momento!<h3>",
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