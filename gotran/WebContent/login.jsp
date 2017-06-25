<!DOCTYPE html>
   <%@page import="social.FBConnection"%>

<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <title>Login</title>
  
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

</head>

<body>


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
				    <li ><a href="#">Minha Conta</a></li>
					<li ><a href="#">Login</a></li>
          			<li ><a href="#">Contato</a></li>
        		</ul>
	    	</div><!-- fim opções da barra cabecalho -->		
		</div>
		<!--/.container-->			
	</nav>
	<!--end: Navbar -->

     <div class="container">
      <div class="row">
       <div class="col-md-12 col-xs-8" >
       <div align="center" style="margin-top: 20px;">
    <h1><p>Faça o login ou crie uma conta gratuita!</p></h1>
    </div>
       </div>
     </div>
     <!-- Login e Cadastro -->
     <div class="row" >
     
     <div class="col-md-1">
  
     </div>
      <!-- Login -->
       <div class="col-md-4" style="margin-top: 20px;">
    
              <div class="panel panel-default" style="margin-top: 15px;">
                    <div class="panel-heading" align="center">
                        <h3><i class="fa fa-sign-in "></i> Ja sou cadastrado</h3>
                    </div>
                    <div class="panel-body">
                    <div  align="center">
                    
                    </div>
                       <form action="" method="post" id="formLogin" >
                           <div id="erro-login"></div>
                           <div id="divCorpo"></div>
                         <div class="form-group">
                         <div>
                          <input type="text" placeholder="Informe seu email" class="form-control" name="email_login"
                          id="email_login">
                         </div>
                         </div>
                         
                         <div class="form-group">
                         <div>
                          <input type="password" placeholder="Informe sua senha" class="form-control" name="senha_login"
                          id="senha_login">
                         </div>
                         </div>
                         
                         <div class="checkbox">
							<label><input type="checkbox"> Lembrar de mim</label>
							|
							<a href="#" data-toggle="modal" data-target="#recupera_senha_modal">Esquecel a senha?</a>							
						</div>
	                  
	                					
                        <button type="submit" class="btn btn-success" id="btnEntrar">Entrar</button>
                        
                         <div id="carrega" align="center"></div>
                         
                     </form>
                    </div>
                </div>
                
                <div>
                
             <div >
             <form action="" method="POST" id="BsAnuncioFrete">
                        <a href="#" class="btn btn-block btn-social btn-facebook"  >
    <span class="fa fa-facebook"></span> Login com Facebook
   </a>
             
             </form>
    
  
       </div>
       
       <div align="center">
       <h4><b>---OU---</b></h4>
       </div>
      
      <div class="g-signin2" data-width="359" data-height="30" data-longtitle="true" data-onsuccess="loginGoogle">
      
      </div>
  
  <form action="" id="loginGoogle">
    <input type="hidden" name="user_name" id="user_name">
    <input type="hidden" name="user_photo" id="user_photo">
     <input type="hidden" name="user_email" id="user_email">
     <input type="hidden" name="user_id" id="user_id">
    </form>
  
       </div>
       </div>
      <!-- Fim login -->
      
      <div class="col-md-2" >
     
      </div>
      
      <!-- Cadastro -->
      <div class="col-md-4" style="margin-top: 30px;">
            <div class="panel panel-default">
                    <div class="panel-heading" align="center">
                        <h3><i class=""></i>Ainda não tenho cadastro</h3>
                    </div>
                    <div class="panel-body">
                    <div  align="center">

                    </div>
                        
                        <form action="" method="post" id="fmCadUsu" class="form-horizontal">
                        
                        <div class="form-group">
                         <div class="col-sm-12">
                          <input type="text" class="form-control" placeholder="Informe seu nome" name="nome_cadastro"
                          id="nome_cadastro">
                         </div>
                        </div>
                        
                        <div class="form-group">
                         <div class="col-sm-12">
                          <input type="text" class="form-control" placeholder="Informe seu sobre nome" name="snome_cadastro"
                          id="snome_cadastro">
                         </div>
                        </div>
                        
                        <div class="form-group">
                         <div class="col-sm-12">
                          <input type="text" class="form-control" placeholder="Informe seu email" name="email_cadastro">
                         </div>
                        </div>
                        
                        <div class="form-group">
                         <div class="col-sm-12">
                          <input type="password" class="form-control" placeholder="Informe uma senha" id="senha2_cadastro_id"
                           name="senha_cadastro">
                         </div>
                        </div>
                        
                        <div class="form-group">
                         <div class="col-sm-12">
                          <input type="password" class="form-control" placeholder="Informe a senha novamente" name="senha2_cadastro">
                         </div>
                        </div>
                        
                        <button type="submit" class="btn btn-danger">Cadastrar</button>
                        <div class="sucesso bg-success" id="sucesso"></div>
                        </form>
                    </div>
                </div>
      </div>
      <!-- Cadastro -->
     
     </div>
     <!-- Fim login e cadastro -->
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

<!-- Modal esq senha -->
<!-- Small modal -->
 <!-- Modal -->
  <div class="modal fade" id="recupera_senha_modal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">Recuperar senha</h3>
        </div>
        <div class="modal-body">

        <form  method="POST" id="fmModalRecuperaSenha">
              <div class="row">
        
        <div class="col-md-2" align="center">
        </div>
        <div class="col-md-8" align="center">
           <input class="form-control" placeholder="Informe o email que você perdeu a senha"
           id="email_recuperar" name="email_recuperar">
           
           <div style="margin-top: 10px;"></div>
                 <div id="carrega_email" align="center"></div>
           
           
           <div class="Panel with panel-success class" id="emailEnviado"></div>
        </div>
      </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-success">Recuperar senha</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        </div>
        </form>
                </div>
        
        
        
      </div>
      
    </div>
  </div>
  

<!-- Fim modal esq senha -->

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
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.isotope.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.imagesloaded.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/flexslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/carousel.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.cslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/slider.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.fancybox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsBuscador.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<!-- DATA -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/ui.datepicker-pt-BR.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
      <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>


<script src="${pageContext.request.contextPath}/resources/index/js/excanvas.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.stack.js"></script>
<script src="${pageContext.request.contextPath}/resources/index/js/jquery.flot.resize.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/index/js/custom.js"></script>	

</body>
</html>
