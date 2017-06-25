package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioEscolarBO;
import bo.AnuncioFreteBO;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.BairroEscolar;
import servlet.BsServlet;
import util.GeoUtils;

public class ListarAnFreteBuscador implements Command, Serializable{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioFreteBO anFreteBO;
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/buscar_frete.jsp";
		anFreteBO = new AnuncioFreteBO();
		
		String cidade = request.getParameter("cidade_frete");

		String carga = request.getParameter("tipo");
		
		String cidadeFiltro = request.getParameter("cidadeFiltro");
		
			request.setAttribute("cid", cidade);
			request.setAttribute("cidFiltro", cidadeFiltro);
			request.setAttribute("tipo_carga", carga);

			String latUsuario = request.getParameter("lat_usuario");
			String lonUsuario = request.getParameter("lon_usuario");
			
			request.setAttribute("lat", latUsuario);
			request.setAttribute("lon", lonUsuario);
			
		
		
		String msg = "Ops, não existe nenhum anuncio escolar disponivel no momento!";
		
		if(cidadeFiltro != null && !cidadeFiltro.equals("") || carga != null && !carga.equals("")){
           
			if(!cidadeFiltro.equals("") && carga.equals("")){
				List<AnuncioFrete> listar = anFreteBO.listarFreteCidade(cidadeFiltro);
				request.setAttribute("lsFrete", listar);
				
			}else if(cidadeFiltro.equals("") && !carga.equals("")){
				String condicao = "frete.tipo_carga = '"+carga+"' AND frete.cidade = '"+cidade+"'";
				List<AnuncioFrete> listar = anFreteBO.listarFreteFiltro(condicao);
				request.setAttribute("lsFrete", listar);

				
			}else if(!cidadeFiltro.equals("") && !carga.equals("")){
				String condicao = "frete.tipo_carga = '"+carga+"' AND frete.cidade = '"+cidadeFiltro+"'";
				List<AnuncioFrete> listar = anFreteBO.listarFreteFiltro(condicao);
				request.setAttribute("lsFrete", listar);

			}
		
		}else{
			List<AnuncioFrete> listar = anFreteBO.listarFreteCidade(cidade);
			
	        request.setAttribute("lsFrete", listar);
		}
		
		
		
		return proximo;
	}

}
