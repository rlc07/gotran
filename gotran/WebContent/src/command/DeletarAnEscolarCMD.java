package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioEscolarBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.Veiculo;

public class DeletarAnEscolarCMD implements Serializable, Command{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioEscolarBO anEscolarBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
      
		anEscolarBO = new AnuncioEscolarBO();
		proximo = "privado/anunciante/meus_anuncios.jsp";
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioEscolar anEscolar = null;
		
         anEscolar = anEscolarBO.listarEscolarId(Integer.parseInt(idAnuncio));
		
         anEscolarBO.deletarAnuncio(anEscolar);
		
		
		return proximo;
	}

}
