<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet">
    <meta name="google-signin-client_id" content="1065941594927-f3p61821fg0gug1eu29e5nn5b69o60v9.apps.googleusercontent.com">
    
        
        <header id="hoe-header" hoe-lpanel-effect="shrink">
        
        <!-- SIDER - LOGO E NOME -->
            <div class="hoe-left-header">
                <a href="#"> <img src="${pageContext.request.contextPath}/resources/tmpl-hoe/img/logo.png" style="width: 30px;"/></a>
                <span class="hoe-sidebar-toggle"><a href="#"></a></span>
                
                <a><span><b>GO</b>TRAN</span></a>
            </div>
        <!-- FIM SIDER - LOGO E NOME -->

        <!-- SIDER - BARRA CABECALHO - MENSAGENS -->

            <div class="hoe-right-header" hoe-position-type="relative" >
                <span class="hoe-sidebar-toggle"><a href="#"></a></span>
                <ul class="left-navbar">
					<li class="dropdown hoe-rheader-submenu message-notification">
						<a href="#" class="dropdown-toggle icon-circle" data-toggle="dropdown">
							<i class="fa fa-envelope-o"></i>
							<span class="badge badge-danger">5</span>
						</a>
						<ul class="dropdown-menu ">
							<li class="hoe-submenu-label">
								<h3>Você tem <span class="bold">5</span> Novas Menssagens <a href="#">ver todas</a></h3>
							</li>
							
							
						</ul>
					</li>
					        <!-- SIDER - BARRA CABECALHO - NOTIFICAÇÃO -->
					
					<li class="dropdown hoe-rheader-submenu message-notification left-min-30">
						<a href="#" class="dropdown-toggle icon-circle" data-toggle="dropdown" >
							<i class="fa fa-bell-o"></i>
							<span class="badge badge-success">6</span>
						</a>
						<ul class="dropdown-menu ">
							<li class="hoe-submenu-label">
								<h3><span class="bold">6 Notificação</span> pendentes <a href="#">ver todas</a></h3>
							</li>
						</ul>
					</li> 
		
					
				</ul> 
									        <!--FIM SIDER - BARRA CABECALHO - NOTIFICAÇÃO -->
				
									        <!-- SIDER - BARRA CABECALHO - USUARIO -->
				
                <ul class="right-navbar">
					<li class="dropdown hoe-rheader-submenu hoe-header-profile">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span>
						   <c:if test="${usuarioLogado.img_perfil != null && usuarioLogado.id_google == null}">
                    <img class="img-circle" src="http://localhost:8080/gotran/img_gotran/img_perfil/${usuarioLogado.img_perfil}">
                        </c:if>
                        
                        <c:if test="${usuarioLogado.img_perfil == null}">
                         <img class="img-circle" src="http://graph.facebook.com/${usuarioLogado.id_facebook}/picture?width=150&height=150">
                        </c:if>
                         
                         <c:if test="${usuarioLogado.img_perfil != null && usuarioLogado.id_google != null}">
                         <img class="img-circle" src="${usuarioLogado.img_perfil }">
                        </c:if>
                        
                       
							</span>
                            <span>${usuarioLogado.nome} ${usuarioLogado.sobre_nome} <i class=" fa fa-angle-down"></i></span>
						</a> 
						<ul class="dropdown-menu ">
							<li><a href="#"><i class="fa fa-user"></i>Meu Perfil</a></li>
							<li>
							<c:if test="${usuarioLogado.id_google != null }"><a href="#" onclick="signOut();"><i class="fa fa-power-off"></i>Sair</a></c:if>
							 <c:if test="${usuarioLogado.id_google == null }"><a href="${pageContext.request.contextPath}/login" ><i class="fa fa-power-off"></i>Sair</a></c:if>
							</li>
						</ul>
					</li>
				
				</ul>
								<!-- FIM SIDER - BARRA CABECALHO - USUARIO -->
			</div>
			
								<!-- SIDERBAR  -->
			
        </header>
 
    
    <script src="${pageContext.request.contextPath}/resources/tmpl-hoe/js/1.11.2.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/tmpl-hoe/js/hoe.js"></script>
    
      <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
    
    <script type="text/javascript">
 	/*sair conta do google*/
    function signOut() {
    	    var auth2 = gapi.auth2.getAuthInstance();
    	    auth2.signOut().then(function () {
    	      location = "login.jsp";
    	    });
    	  }

       function onLoad() {
    	      gapi.load('auth2', function() {
    	        gapi.auth2.init();
    	      });
    	    }
    </script>