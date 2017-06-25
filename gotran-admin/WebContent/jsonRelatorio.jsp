<%@page import="bo.RelatorioBO"%>
<%@page import="modelo.Relatorio"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>

<%

    RelatorioBO relatorioBO = new RelatorioBO();

     
   List<Relatorio> lsRelatorio = relatorioBO.relatorioEscolar();
      Gson gson = new Gson();

      String aux = gson.toJson(lsRelatorio);
       
       System.out.println(aux);
       
       PrintWriter oPrintWriter = response.getWriter();
       oPrintWriter.print(aux);
         	
	
%>