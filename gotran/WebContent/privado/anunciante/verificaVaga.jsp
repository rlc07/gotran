<%@page import="modelo.Veiculo"%>
<%@page import="bo.VeiculoBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String vaga_escolar = request.getParameter("vaga_escolar");
    String veiculo = request.getParameter("veiculo");


      System.out.println(vaga_escolar);
      System.out.println(veiculo);


      
      VeiculoBO veiculoBO = new VeiculoBO();
      Veiculo vec = null;
      
      
      
    if(vaga_escolar == "30"){
		out.print("true");
    	
    	}else {
    		vaga_escolar.trim().equalsIgnoreCase(vaga_escolar);

    		out.print("false");
    	}

%>