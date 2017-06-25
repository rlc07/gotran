<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet">
    
    
        
            <aside id="hoe-left-panel"  hoe-position-type="absolute">
                <div class="profile-box">
                    <div class="media">
                        <a class="pull-left" href="#">
                        
                        <c:if test="${usuarioLogado.img_perfil != null && usuarioLogado.id_google == null}">
                    <img class="img-circle" src="http://localhost:8080/gotran/img_gotran/img_perfil/${usuarioLogado.img_perfil}">
                        </c:if>
                        
                        <c:if test="${usuarioLogado.img_perfil == null}">
                         <img class="img-circle" src="http://graph.facebook.com/${usuarioLogado.id_facebook}/picture?width=150&height=150">
                        </c:if>
                         
                         <c:if test="${usuarioLogado.img_perfil != null && usuarioLogado.id_google != null}">
                         <img class="img-circle" src="${usuarioLogado.img_perfil }">
                        </c:if>
                         
                          
                     
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Bem vindo, ${usuarioLogado.nome}</h5>
                            <a href="${pageContext.request.contextPath}/main?action=minha-conta/" id="editPerfil">Editar Perfil</a>
                        </div>
                    </div>
                </div>
                <ul class="nav panel-list">
                    <li class="nav-level"></li>
                    <li class="">
                     <form  id="myVeiculo" method="post" action="${pageContext.request.contextPath}/main?action=meus-veiculos" >
                         <input type="hidden" name="id_usuario" value="${sessionScope.usuarioLogado.id_usuario}"/>
                    </form>
                        <a href="#" onClick="document.getElementById('myVeiculo').submit(); ">
                            <i class="fa fa-bus"></i>
                            <span class="menu-text">Meus Veiculos</span>
                            <span class="selected"></span>
                        </a>
                    </li>
                    
                    
                    
                    <li>
                    
                         <form  id="myAnuncio" method="post" action="${pageContext.request.contextPath}/main?action=meus-anuncios" >
                         <input type="hidden" name="id_usuario" value="${sessionScope.usuarioLogado.id_usuario}"/>
                    </form>
                        <a href="#" onClick="document.getElementById('myAnuncio').submit(); ">
                        
                            <i class="fa fa-comment"></i>
                            <span class="menu-text">Meus Anuncios</span>
                            <span class="selected"></span>
                        </a>
                    </li>
                    
                    <li class="hoe-has-menu">
                        <a href="javascript:void(0)">
                            <i class="fa fa-envelope"></i>
                            <span class="menu-text">Menssagens</span>
                            <span class="selected"></span>
                        </a>
            
                    </li>
           
                    <li class="nav-level">ANUNCIAR</li>
                    
                    <li>
                    <form  id="myAnuncioEscolar" method="post" action="${pageContext.request.contextPath}/main?action=anuncio-escolar/" >
                         <input type="hidden" name="id_usuario" value="${sessionScope.usuarioLogado.id_usuario}"/>
                    </form>
                         
                        <a href="#" onClick="document.getElementById('myAnuncioEscolar').submit(); ">
                            <i class="fa fa-bus"></i>
                            <span class="menu-text">Transporte Escolar</span>
                            <span class="selected"></span>
                        </a>
                    </li>
                    
                    <li>
                      <form  id="myAnuncioFrete" method="post" action="${pageContext.request.contextPath}/main?action=anuncio-frete_carreto/" >
                         <input type="hidden" name="id_usuario" value="${sessionScope.usuarioLogado.id_usuario}"/>
                    </form>
                         
                        <a href="#" onClick="document.getElementById('myAnuncioFrete').submit(); ">
                            <i class="fa fa-truck "></i>
                            <span class="menu-text">Frete\Carreto</span> 
                            <span class="selected"></span>
                        </a>
                    </li>
                    
                     <li>
                         <form  id="myAnuncioExcursao" method="post" action="${pageContext.request.contextPath}/main?action=anuncio-excursao/" >
                         <input type="hidden" name="id_usuario" value="${sessionScope.usuarioLogado.id_usuario}"/>
                    </form>
                         
                        <a href="#" onClick="document.getElementById('myAnuncioExcursao').submit(); ">
                            <i class="fa fa-ship "></i>
                            <span class="menu-text">Excursão</span> 
                            <span class="selected"></span>
                        </a>
                    </li>
                    
                    <li>
                        <form  id="myAnuncioAluguel" method="post" action="${pageContext.request.contextPath}/main?action=anuncio-aluguel_veiculo/" >
                         <input type="hidden" name="id_usuario" value="${sessionScope.usuarioLogado.id_usuario}"/>
                    </form>
                         
                        <a href="#" onClick="document.getElementById('myAnuncioAluguel').submit(); ">
                            <i class="fa fa-bus "></i>
                            <span class="menu-text">Aluguel de vans</span> 
                            <span class="selected"></span>
                        </a>
                    </li>
                    
                    <li class="nav-level">MAIS</li>
                    <li class="hoe-has-menu">
                        <a href="javascript:void(0)">
                            <i class="fa fa-search"></i>
                            <span class="menu-text">Buscar transporte</span>
                            <span class="selected"></span>
                        </a>
            
                    </li>
                </ul>
            </aside>
  

    <script src="${pageContext.request.contextPath}/resources/tmpl-hoe/js/1.11.2.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/tmpl-hoe/js/hoe.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>
    
