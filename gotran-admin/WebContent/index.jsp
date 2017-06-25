<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/index/css/style.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/assets/bootstrap-social.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<title>GOTRAN-ADM</title>
</head>
<body style="background-color: #002033;">
      <jsp:include page="/template/cabecalho_admin.jsp"></jsp:include>


	  <div class="container conteudoEscolar" style=" margin-top: 20px; background-color:  #002033;" >
     
           <div class="row">
           <div class="col-md-12 col-sm-12" style="margin-top: 40px;">
           
           <div class="col-md-4"></div>
           <div class="col-md-4" align="center">
           <div class="panel panel-default">
      <div class="panel-heading"><h4><b>Sistema de Relatorio</b></h4></div>
      <div class="panel-body">
      
      <div>
		  <img src="${pageContext.request.contextPath}/resources/img/img-icone/logo.png" style="width: 100px;"/>
      </div>
      
      <div style="margin-top: 20px;">
		  <form action="admin.jsp"  method="POST">
		  
		   <div align="left">
		  <input class="form-control" id="email" name="email" placeholder="usuario">
		  </div>
		 
		  <div align="left" style="margin-top: 10px;">
		  <input class="form-control" id="nsenha" name="nsenha" type="password" placeholder="****">
		  
		  </div>
		  
		   <div align="right" style="margin-top: 10px;">
		  <button type="submit"  class="btn btn-success">Entrar</button>
		  
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
     
</body>
</html>