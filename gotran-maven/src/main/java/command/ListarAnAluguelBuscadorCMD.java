package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioAluguelBO;
import bo.AnuncioEscolarBO;
import bo.AnuncioFreteBO;
import modelo.AnuncioAluguel;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.BairroEscolar;
import modelo.Usuario;
import servlet.BsServlet;
import util.GeoUtils;

public class ListarAnAluguelBuscadorCMD implements Command, Serializable{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioAluguelBO anAluguelBO;
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/buscar_aluguel.jsp";
		anAluguelBO = new AnuncioAluguelBO();
		
		String cidade = request.getParameter("cidade_aluguel");
        String cidadeFiltro = request.getParameter("cidadeFiltro");
		
			request.setAttribute("cid", cidade);
			request.setAttribute("cidFiltro", cidadeFiltro);
			String latUsuario = request.getParameter("lat_usuario");
			String lonUsuario = request.getParameter("lon_usuario");
			
			request.setAttribute("lat", latUsuario);
			request.setAttribute("lon", lonUsuario);
			
			if(cidadeFiltro != null){
	List<AnuncioAluguel> listar = anAluguelBO.listarAluguelCidade(cidadeFiltro);
				
				request.setAttribute("lsAluguel", listar);
				
			}else{
				List<AnuncioAluguel> listar = anAluguelBO.listarAluguelCidade(cidade);
				
				request.setAttribute("lsAluguel", listar);
			}
            
			
			
		
		
		
		return proximo;
	}

}
