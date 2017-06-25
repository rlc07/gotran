<%@page import="bo.UsuarioBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <%
   
   UsuarioBO usuarioBO = new UsuarioBO();
   
   String email = request.getParameter("email_cadastro");
   String email_recuperar = request.getParameter("email_recuperar");
   
  
    if(usuarioBO.localizarPorEmail(email)){
		email.trim().equalsIgnoreCase(email);
    	out.println("false");
    }else{
    	out.println("true");

    }
   
   
   
   
   
   
   %>