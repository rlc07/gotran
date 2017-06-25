<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Minha Conta</title>

<!-- IMPORTE DO BOOTSTRAP.CSS -->
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css"/>

		
<!-- IMPORTE DO ESTILO.CSS -->
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/fileinput.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/tmpl-hoe/css/hoe.css" rel="stylesheet" type="text/css"/>
    <meta name="google-signin-client_id" content="1065941594927-f3p61821fg0gug1eu29e5nn5b69o60v9.apps.googleusercontent.com">


</head>
<body>

<!-- IMPORTE SIDEBAR E CABECALHO -->

       <div id="hoeapp-wrapper" class="hoe-hide-lpanel" hoe-device-type="desktop" style="margin-top: -50px;">
          <!-- IMPORTE CABECALHO -->
       <jsp:include page="/template/cabecalho_layout.jsp"></jsp:include>
         <!-- IMPORTE SIDEBAR -->
       <div id="hoeapp-container" hoe-color-type="lpanel-bg10" hoe-lpanel-effect="shrink">
       <jsp:include page="/template/sidebar_layout.jsp"></jsp:include>
	         
	         <div id="main-content">
			    <div class="inner-content">
                    <div class="panel theme-panel">
                        <div class="panel-body">
                                 <!-- CONTEUDO -->
                        
                            <!-- INICIO PAINEL MINHA CONTA -->
							<div class="panel panel-primary span9 panelMinhaConta">
								<div class="panel-heading">
									<b>Minha Conta</b>
								</div>
								<div class="panel-body">
									<div class="container-fluid">

										<!-- PAINEL - FOTO PERFIL -->
										<div class="row">

											<div class="col-sm-6 col-md-3">
												<div style="margin-left: 30px;">
													<h4>MINHA FOTO</h4>
												</div>
		
									
								<form class="text-center" method="post"
								 enctype="multipart/form-data" id="foto" >
								 
								 <input type="hidden" class="form-control" id="id_usuario"
										name="${sessionScope.usuarioLogado.id_usuario}"
										value="${sessionScope.usuarioLogado.id_usuario}">
										
										<input type="hidden" class="form-control" id="email"
										name="${sessionScope.usuarioLogado.email}"
										value="${sessionScope.usuarioLogado.email}">
										
										
										<div class="kv-avatar center-block" style="width: 200px">
												<input id="avatar-1" name="avatar-1" type="file"class="file-loading">
													</div>
                                    </form>
                                    
                                    <div id="kv-avatar-errors-1" class="center-block"
													style="width: 600px; display: none"></div>
												<!-- FIM PAINEL - FOTO PERFIL -->
											</div>


											<!-- FORMULARIO MINHA CONTA -->
											<div>
												<form id="fmAtuUsu" method="post">
													<div class="col-sm-6 col-md-4">

														<input type="hidden" name="id_usuario"
															value="${usuarioLogado.id_usuario}">

														<div class="form-group">
															<input type="text" placeholder="Nome"
																class="form-control" name="nome_atualizacao" id="nome_atualizacao"
																value="${usuarioLogado.nome}">
														</div>

														<div class="form-group">
															<input type="text"
																placeholder="Informe seu telefone fixo"
																class="form-control" name="fone_fixo" 
																value="${usuarioLogado.telefone_fixo}" id="fone_fixo">
														</div>

														<div class="form-group">
															<input type="text" placeholder="Email"
																class="form-control" name="email_atualizacao" 
																value="${usuarioLogado.email}" readonly="readonly">
															<a>Alterar email</a>
														</div>

														<!-- FIM PRIMEIRA COLUNA FORMULARIO -->
													</div>

													<!-- INICIO SEGUNDA COLUNA  -->
													<div class="col-sm-6 col-md-4">

														<div class="form-group">
															<input type="text" placeholder="Sobre nome"
																class="form-control" name="snome_atualizacao" id="snome_atualizacao"
																value="${usuarioLogado.sobre_nome}">
														</div>

														<div class="form-group">
															<input type="text"
																placeholder="Informe seu telefone celular"
																class="form-control" name="fone_cel" 
																value="${usuarioLogado.telefone_cel}" id="fone_cel">
														</div>
                                                          
														<div class="form-group">
															<input type="password" placeholder="******"
																class="form-control" name="senha_atualizacao"
																value="${usuarioLogado.senha}" readonly="readonly">
															<a href="#" data-toggle="modal" data-target="#modalSenha">Alterar
																senha</a>


														</div>
														<hr>
														<div class="form-group" align="right">
															<button type="submit" class="btn btn-danger">Salvar</button>
														</div>

													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- FIM PAINEL MINHA CONTA -->
         
         

                                 <!-- FIM - CONTEUDO -->
                         </div>
                    </div>
                </div>  
            </div>
            
                   <jsp:include page="/template/conf_layout.jsp"></jsp:include>
            
        </div>
	 </div>



	<!-- INICIO MODAL - ALTERAR SENHA -->
             <div class="modal fade" id="modalSenha" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Alterar Senha</h4>
        </div>
        <div class="modal-body">

            <!-- INICIO DO FORMULARIO - ALTERAR SENHA -->
            
            <form action="" method="post" id="fmModalSenha">
                   <input type="hidden" name="id_usuario" value="${usuarioLogado.id_usuario}">
						<div class="row">
							<div class="col-sm-6 col-md-6">
							<div>
				<c:out value="${msgSenha}"></c:out>
				
							</div>
								<div class="form-group">
									<label>Senha atual</label> <input type="password"
										placeholder="Digite a senha atual" class="form-control" name="atual_senha_modal" id="sw_modal">
								</div>
								
								<div class="form-group">
									<label>Confirmar senha atual</label> <input type="password"
										placeholder="Digite a senha atual novamente" class="form-control" name="atual_senha_modal2">
								</div>
								<hr>
								<div class="form-group">
									<label>Nova senha</label> <input type="password"
										placeholder="Digite a nova senha" class="form-control" name ="nova_senha_modal">
								</div>
								
							</div>
						</div>
		<div class="modal-footer">
          <button type="submit" class="btn btn-success">Alterar</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        </div>
					</form>
            
            <!-- FIM DO FORMULARIO - ALTERAR SENHA -->
            

        </div>
   
      </div>
      
    </div>
  </div>
 <!-- FIM MODAL - ALTERAR SENHA -->





<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/meujs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.maskMoney.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fileinput.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/data/js/bootstrap-datetimepicker.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
             <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
      
<script>
var btnCust = '<button type="submit" class="btn btn-default" id="btnSalvarImgPerfil" title="Add ">' +
    '<i class="fa fa-floppy-o"></i>' +
    '</button>'; 
$("#avatar-1").fileinput({
    maxFileSize: 1500,
    showClose: false,
    showCaption: false,
    browseLabel: '',
    removeLabel: '',
    browseIcon: '<i class="fa fa-folder-open "></i>',
    removeIcon: '<i class="fa fa-times"></i>',
    removeTitle: 'Cancelar',
    elErrorContainer: '#kv-avatar-errors-1',
    msgErrorClass: 'alert alert-block alert-danger',
    defaultPreviewContent: '<c:if test="${usuarioLogado.img_perfil == null}"><img class="img-circle" src="http://graph.facebook.com/${usuarioLogado.id_facebook}/picture?width=150&height=150"</c:if>'+
    '<c:if test="${usuarioLogado.img_perfil != null && usuarioLogado.id_google == null}"><img class="img-circle" src="http://localhost:8080/gotran/img_gotran/img_perfil/${usuarioLogado.img_perfil}" style="width:160px" alt="Minha Foto"> </c:if>'+
    '<c:if test="${usuarioLogado.img_perfil != null && usuarioLogado.id_google != null}"><img class="img-circle" src="${usuarioLogado.img_perfil}" style="width:160px" alt="Minha Foto"> </c:if>',
    layoutTemplates: {main2: '{preview} ' +  btnCust + ' {remove} {browse}'},
    allowedFileExtensions: ["jpg", "png", "gif"]
});

</script>

<script type="text/javascript">
jQuery("#fone_cel")
.mask("(99) 9999-9999?9")
.focusout(function (event) {  
    var target, phone, element;  
    target = (event.currentTarget) ? event.currentTarget : event.srcElement;  
    phone = target.value.replace(/\D/g, '');
    element = $(target);  
    element.unmask();  
    if(phone.length > 10) {  
        element.mask("(99) 99999-999?9");  
    } else {  
        element.mask("(99) 9999-9999?9");  
    }  
});

jQuery("#fone_fixo")
.mask("(99) 9999-9999")
.focusout(function (event) {  
    var target, phone, element;  
    target = (event.currentTarget) ? event.currentTarget : event.srcElement;  
    phone = target.value.replace(/\D/g, '');
    element = $(target);  
    element.unmask();  
    if(phone.length > 10) {  
        element.mask("(99) 99999-999?9");  
    } else {  
        element.mask("(99) 9999-9999?9");  
    }  
});

</script>
</body>
</html>