

<%@page import="bo.VeiculoBO"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="bo.AnuncioBO"%>
<%@page import="modelo.Veiculo"%>
<%@page import="java.util.List"%>

<%

      AnuncioBO anuncioBO = new AnuncioBO();
     VeiculoBO veiculoBO = new VeiculoBO();
      String id = "2";
      
      List<Veiculo> listarVeiculo = veiculoBO.listarTodosVeiculos();
 
      Gson gson = new Gson();

      String aux = gson.toJson(listarVeiculo);
       
       System.out.println(aux);
       
       PrintWriter oPrintWriter = response.getWriter();
       oPrintWriter.print(aux);
         	
	
%>