package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioEscolarBO;
import bo.AnuncioExcursaoBO;
import bo.AnuncioFreteBO;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;
import modelo.AnuncioFrete;
import modelo.BairroEscolar;
import servlet.BsServlet;
import util.GeoUtils;

public class ListarAnExcursaoBuscador implements Command, Serializable{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioExcursaoBO anExcursaoBO;
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/buscar_excursao.jsp";
		anExcursaoBO = new AnuncioExcursaoBO();
		
		String cidade = request.getParameter("cidade_excursao");
		String cidadeFiltro = request.getParameter("cidadeFiltro");
		String destino = request.getParameter("destino");
		
		request.setAttribute("cidFiltro", cidadeFiltro);
		request.setAttribute("destino", destino);
		request.setAttribute("cid", cidade);
		
		String latUsuario = request.getParameter("lat_usuario");
		String lonUsuario = request.getParameter("lon_usuario");
		
		request.setAttribute("lat", latUsuario);
		request.setAttribute("lon", lonUsuario);



		if(cidadeFiltro != null && !cidadeFiltro.equals("") || destino != null && !destino.equals("")){
			
			if(!cidadeFiltro.equals("") && destino.equals("")){
				
			   List<AnuncioExcursao> listar = anExcursaoBO.listarExcursaoCidade(cidadeFiltro);
		       request.setAttribute("lsExcursao", listar);
			
			}else if(cidadeFiltro.equals("") && !destino.equals("")){
				
				String condicao = "excursao.destino LIKE '%"+destino+"%'";
				
			   List<AnuncioExcursao> listar = anExcursaoBO.listarExcursaoFiltro(condicao);
			   request.setAttribute("lsExcursao", listar);
			
			}else if(!cidadeFiltro.equals("") && !destino.equals("")){
				
				  String condicao = "excursao.destino LIKE '%"+destino+"%' AND excursao.cidade = '"+cidadeFiltro+"'";
				
				   List<AnuncioExcursao> listar = anExcursaoBO.listarExcursaoFiltro(condicao);
				   request.setAttribute("lsExcursao", listar);
			}
			
			
		}else{
			request.setAttribute("cid", cidade);
			
	        List<AnuncioExcursao> listar = anExcursaoBO.listarExcursaoCidade(cidade);
	        
	        request.setAttribute("lsExcursao", listar);
		}
	
		
		
		
		return proximo;
	}

}
