<!DOCTYPE html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html >
<head>
  <meta charset="UTF-8">
  <title>GOTRAN</title>
  
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
   <!-- start: CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/index/css/style.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	
		
	<link href="resources/index/css/parallax-slider.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Droid+Serif">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Boogaloo">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Economica:700,400italic">
	<!-- end: CSS -->

</head>

<body>

    <jsp:include page="/template/cabecalho_buscador.jsp"></jsp:include>

	<!-- start: Slider -->
	<div class="slider-wrapper">

		<div id="da-slider" class="da-slider">
			<div class="da-slide">
				<h2>Transporte Escolar</h2>
				<p>Encontre os melhores serviços de transporte escolar e universitário perto de você.</p>
				<a href="#" class="da-link">Saiba mais</a>
				<div class="da-img"><img src="resources/img/img-buscador/vanescolarbusca.png" alt="image01" style="width: 400px;"/></div>
			</div>
			<div class="da-slide">
				<h2>Frete e Carreto</h2>
				<p>Vai se mudar? Encontre aqui os melhores serviços de frete e carreto da sua região.</p>
				<a href="#" class="da-link">Saiba Mais</a>
				<div class="da-img"><img src="resources/img/img-icone/frete-img.png" alt="image02" style="width: 400px;"  /></div>
			</div>
			<div class="da-slide">
				<h2>Excursão</h2>
				<p>Encontre excursões que estão acontecendo em sua região.</p>
				<a href="index.html#" class="da-link">Saiba Mais</a>
				<div class="da-img"><img src="resources/img/img-icone/excursao-img.png" alt="image03" style="width: 400px;" /></div>
			</div>
			<div class="da-slide">
				<h2>Aluguel de Vans</h2>
				<p>Vai viajar? Encontre um veículo ideal aqui..</p>
				<a href="index.html#" class="da-link">Saiba Mais</a>
				<div class="da-img"><img src="resources/img/img-buscador/aluguelbusca.png" alt="image04" style="width: 400px;" /></div>
			</div>
			<nav class="da-arrows">
				<span class="da-arrows-prev"></span>
				<span class="da-arrows-next"></span>
			</nav>
		</div>
		
	</div>
	<!-- end: Slider -->
	
	 <div align="center" style="margin-top: 30px;">
                   <h1><p>Os melhores serviços de transporte, você encontra aqui.</p></h1>
                   </div>
                   <hr>
                   
			<div class="container">
		<div class="row">
		 <div class="col-md-4">
                <div class="panel panel-default Panel with panel-warning class">
                    <div class="panel-heading" align="center">
                        <h4><i class="fa fa-bus "></i> Transporte Escolar\Universitário</h4>
                    </div>
                    <div class="panel-body">
                    <div  align="center">
                    <img src="resources/img/img-icone/escolar-img.png" class=" img-circle img-responsive"
						style="width: 300px; height: 200px;"/>
                    </div>
                        <div style="margin-top: 15px;">
                        <p>Encontre os melhores serviços de transporte escolar e universitário perto de você.</p>
                        </div>
                        <a href="http://localhost:8080/gotran/publico/buscador/buscar_transporte.jsp" class="btn btn-default">Saiba mais</a>
                    </div>
                </div>
            </div>
            
             <div class="col-md-4">
                <div class="panel panel-default Panel with panel-success class">
                    <div class="panel-heading" align="center">
                        <h4><i class="fa fa-truck "></i> Frete\Carreto</h4>
                    </div>
                    <div class="panel-body">
                    <div  align="center">
                    <img src="resources/img/img-icone/frete-img.png" class=" img-circle img-responsive"
						style="width: 300px; height: 200px;"/>
                    </div>
                        <div style="margin-top: 15px;">
                        <p>Encontre os melhores serviços de frete e carreto perto de você.</p>
                        </div>
                        <a href="http://localhost:8080/gotran/publico/buscador/buscar_transporte.jsp" class="btn btn-default">Saiba mais</a>
                    </div>
                </div>
            </div>
            
                 <div class="col-md-4">
                <div class="panel panel-default Panel with panel-danger class">
                    <div class="panel-heading" align="center">
                        <h4><i class="fa fa-suitcase "></i> Excursão</h4>
                    </div>
                    <div class="panel-body">
                    <div  align="center">
                    <img src="resources/img/img-icone/excursao-img.png" class=" img-circle img-responsive"
						style="width: 300px; height: 200px;"/>
                    </div>
                        <div style="margin-top: 15px;">
                        <p>Encontre as excursões que estão p/ acontecer em sua região.</p>
                        </div>
                        <a href="http://localhost:8080/gotran/publico/buscador/buscar_transporte.jsp" class="btn btn-default">Saiba mais</a>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="panel panel-default Panel with panel-info class">
                    <div class="panel-heading" align="center">
                        <h4><i class="fa fa-bus "></i> Aluguel de van</h4>
                    </div>
                    <div class="panel-body">
                    <div  align="center">
                    <img src="resources/img/img-icone/aluguel-img.png" class=" img-circle img-responsive"
						style="width: 300px; height: 200px;"/>
                    </div>
                        <div style="margin-top: 15px;">
                        <p>Encontre as melhores vans para alugar perto de você.</p>
                        </div>
                        <a href="http://localhost:8080/gotran/publico/buscador/buscar_transporte.jsp" class="btn btn-default">Saiba mais</a>
                    </div>
                </div>
            </div>
            
            
		</div>
	</div>

	<!-- start: Footer Menu -->
	<div id="footer-menu" class="hidden-sm hidden-xs">

		<!-- start: Container -->
		<div class="container">
			
			<!-- start: Row -->
			<div class="row">

				<!-- start: Footer Menu Logo -->
				<div class="col-sm-2">
					<div id="footer-menu-logo">
						<a class="brand" href="index.html#">Go<span>Tran</span>.</a>
					</div>
				</div>
				<!-- end: Footer Menu Logo -->
             </div>
			<!-- end: Row -->
		</div>
		<!-- end: Container  -->	
  </div>	
	<!-- end: Footer Menu -->



	<!-- start: Copyright -->
	<div id="copyright">
	
		<!-- start: Container -->
		<div class="container">
		
			<div class="col-sm-12">
				
				<p>
					&copy; 2016, GoTran. Todos os direitos reservado.
				</p>
				
			</div>
	
		</div>
		<!-- end: Container  -->
		
	</div>
	
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.imagesloaded.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/flexslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/carousel.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.cslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/slider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.fancybox.js"></script>

<script src="${pageContext.request.contextPath}/resources/index/js/excanvas.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.stack.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.resize.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/index/js/custom.js"></script>	
</body>
</html>
