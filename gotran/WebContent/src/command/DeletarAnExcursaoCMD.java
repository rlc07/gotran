package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioEscolarBO;
import bo.AnuncioExcursaoBO;
import bo.AnuncioFreteBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class DeletarAnExcursaoCMD implements Serializable, Command{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioExcursaoBO anExcursaoBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
      
		anExcursaoBO = new AnuncioExcursaoBO();
		proximo = "privado/anunciante/meus_anuncios.jsp";
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioExcursao anExcursao = null;
		
         anExcursao = anExcursaoBO.listarMyExcursaoId(Integer.parseInt(idAnuncio));
		
         anExcursaoBO.deletarAnExcursao(anExcursao);
		
		
		return proximo;
	}

}
