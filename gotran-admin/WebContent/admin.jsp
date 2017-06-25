<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Relatorio</title>
    
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
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        top:0;
left:0;
width:100%;
height:70%;
margin-top: 80px;
      }
#floating-panel {
  position: absolute;
  top: 10px;
  left: 25%;
  z-index: 5;
  background-color: #fff;
  padding: 5px;
  border: 1px solid #999;
  text-align: center;
  font-family: 'Roboto','sans-serif';
  line-height: 30px;
  padding-left: 10px;
}

      #floating-panel {
        background-color: #fff;
        border: 1px solid #999;
        left: 25%;
        padding: 5px;
        position: absolute;
        top: 10px;
        z-index: 5;
      }
    </style>
  </head>

  <body >
      <jsp:include page="/template/cabecalho_admin.jsp"></jsp:include>
  
    <div class="container">
          <div class="row">
								 		<div class="col-sm-12 col-md-12">
								 		<div class="Panel with panel-warning class">
											
											<div class="panel-body">
								<div class="col-md-4 row" >
								<input type="text" id="searchInput" name="searchInput"
									placeholder="Informe a sua cidade" class="form-control " /> 
								</div>
								
								
								<div id="map-canvas" style="height: 400px;"></div>
								
								
					
							
							  </div>
							 </div>
							
							</div>
							</div>
							</div>
							
							
							<script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDanv8HnOiFtaLoQ7tNzc5v82Kuxm2SEoU&amp;libraries=places"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/zepto/1.0/zepto.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/relatorio.js"></script>
							
  </body>
</html>