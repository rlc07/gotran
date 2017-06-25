package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioEscolarBO;
import bo.AnuncioFreteBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class DeletarAnFreteCMD implements Serializable, Command{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioFreteBO anFreteBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
      
		anFreteBO = new AnuncioFreteBO();
		proximo = "privado/anunciante/meus_anuncios.jsp";
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioFrete anFrete = null;
		
         anFrete = anFreteBO.listarAnFreteID(Integer.parseInt(idAnuncio));
		
         anFreteBO.deletarAnFrete(anFrete);
		
		
		return proximo;
	}

}
