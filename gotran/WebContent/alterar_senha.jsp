<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/mapa-busca/css/estiloMapa.css" rel="stylesheet" type="text/css"/>
<title>Alterar Senha</title>
</head>
<body style="background-color: #C7C7C7;">

 <jsp:include page="/template/cabecalho_buscador.jsp"></jsp:include>
    
     <!-- Container -->
     <div class="container conteudoEscolar" style=" margin-top: 20px; background-color:  #ffffff;" >
     
           <div class="row">
           <div class="col-md-12 col-sm-12" style="margin-top: 40px;">
           
           <div class="col-md-4"></div>
           <div class="col-md-4" align="center">
           <div class="panel panel-default">
      <div class="panel-heading"><b>Alterar senha</b></div>
      <div class="panel-body">
      
      <div>
		  <img src="${pageContext.request.contextPath}/resources/img/img-icone/logo.png" style="width: 100px;"/>
      </div>
      
      <div style="margin-top: 20px;">
		  <form action="buscar?action=nova-senha"  method="POST">
		  
		   <div align="left">
		  <label>Informe o seu email</label>
		  <input class="form-control" id="email" name="email">
		  		   <div><b style="color: red;">${msgVazia}</b></div>
		  
		  
		 
		  </div>
		  
		  <div align="left" style="margin-top: 10px;">
		  <label>Informe o codigo recebido por email</label>
		  <input class="form-control" id="codigo" name="codigo">
		   <div><b style="color: red;">${msgVazia}</b></div>
		 
		  </div>
		  
		  <div class="Panel with panel-success class" style="margin-top: 10px;">
		  <b style="color: green;">${msgOk}</b>
		  </div>
		  
		  <div class="Panel with panel-danger class" style="margin-top: 10px;">
		  <b style="color: red;">${msgErro}</b>
		  </div>
		  
		  <div style="margin-top: 10px;">
		  <p><h3>----- Nova senha ------</h3></p>
		  </div>
		  <div align="left">
		  <label>Informe a nova senha</label>
		  <input class="form-control" id="nsenha" name="nsenha" type="password">
		  		   <div><b style="color: red;">${msgVazia}</b></div>
		  
		  </div>
		  
		   <div align="right" style="margin-top: 10px;">
		  <button type="submit"  class="btn btn-success">Enviar</button>
		  
		  </div>
		  		  </form>
		  
      </div>
      
      </div>
    </div>
    </div>
           
           </div>
           
           </div>

     </div>
     <!-- Fim container -->
    
    
    <jsp:include page="/template/rodape_buscador.jsp"></jsp:include>





<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsBuscador.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

	

</body>
</html>