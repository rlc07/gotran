<%@page import="bo.UsuarioBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <%
   
   UsuarioBO usuarioBO = new UsuarioBO();
   
   String email_recuperar = request.getParameter("email_recuperar");
   
  
    if(usuarioBO.localizarPorEmail(email_recuperar)){
    	email_recuperar.trim().equalsIgnoreCase(email_recuperar);
    	out.println("true");
    }else{
    	out.println("false");

    }
   
   
   
   
   
   
   %>