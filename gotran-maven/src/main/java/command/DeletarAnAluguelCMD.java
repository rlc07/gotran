package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioAluguelBO;
import bo.AnuncioEscolarBO;
import bo.AnuncioFreteBO;
import bo.VeiculoBO;
import modelo.AnuncioAluguel;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class DeletarAnAluguelCMD implements Serializable, Command{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioAluguelBO anAluguelBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
      
		anAluguelBO = new AnuncioAluguelBO();
		proximo = "privado/anunciante/meus_anuncios.jsp";
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioAluguel anAluguel = null;
		
         anAluguel = anAluguelBO.listarMyAluguelId(Integer.parseInt(idAnuncio));
		
         anAluguelBO.deletarAnAluguel(anAluguel);
		
		
		return proximo;
	}

}
