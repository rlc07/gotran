<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String ano = request.getParameter("ano_veiculo");

      System.out.println(ano);
      
    if(Integer.parseInt(ano) >= 1990){
    	response.getWriter().write("true");
    	
    	}else if(Integer.parseInt(ano) < 1990){
        	response.getWriter().write("false");
    	}

%>