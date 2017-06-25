<!DOCTYPE html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
   <!-- start: CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/index/css/style.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/bootstrap/assets/bootstrap-social.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="1065941594927-f3p61821fg0gug1eu29e5nn5b69o60v9.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
		
	<link href="${pageContext.request.contextPath}/resources/index/css/parallax-slider.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Serif">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Boogaloo">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Economica:700,400italic">
	<!-- end: CSS -->




<!--start: Navbar -->
	<nav class="navbar navbar-default" role="navigation">		
		<!--start: Container -->
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
	    	<div class="navbar-header">
	      		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-navigation">
	        		<span class="sr-only">Toggle navigation</span>
	        		<span class="icon-bar"></span>
	        		<span class="icon-bar"></span>
	        		<span class="icon-bar"></span>
	      		</button>
	      		<a class="navbar-brand" href="index.jsp"><i class="fa fa-bus"></i> Go<span>Tran</span>.</a>
	    	</div>

	    	<!-- Opçoes da barra de cabecalho -->
	    	<div class="collapse navbar-collapse" id="main-navigation">
	      		<ul class="nav navbar-right navbar-nav">
	      			<c:if test="${usuarioLogado != null }"><li ><a href="${pageContext.request.contextPath}/main?action=minha-conta/&id_usuario=${usuarioLogado.id_usuario}">Minha Conta</a></li></c:if>	      		
				    <c:if test="${usuarioLogado == null }"><li ><a href="#" onclick="fazerLogin();"><span class="fa fa-sign-in "></span> Login</a></li></c:if>
          			<li ><a href="#">Contato</a></li>
        		</ul>
	    	</div><!-- fim opções da barra cabecalho -->		
		</div>
		<!--/.container-->			
	</nav>
	<!--end: Navbar -->
          

		
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.imagesloaded.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.cslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/slider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.fancybox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<!-- DATA -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/ui.datepicker-pt-BR.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>


<script src="${pageContext.request.contextPath}/resources/index/js/excanvas.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.stack.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.resize.min.js"></script>

<script>
function fazerLogin(){
	window.open("login.jsp")
}
</script>