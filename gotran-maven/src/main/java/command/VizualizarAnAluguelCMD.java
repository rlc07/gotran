package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.io.STAXEventReader;

import bo.AnuncioAluguelBO;
import bo.AnuncioEscolarBO;
import bo.AnuncioFreteBO;
import bo.VeiculoBO;
import modelo.AnuncioAluguel;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class VizualizarAnAluguelCMD implements Command, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String proximo = "";
	private AnuncioAluguelBO anAluguelBO;
	private VeiculoBO veiculoBO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/ver_anuncio_aluguel.jsp";
		anAluguelBO = new AnuncioAluguelBO();
		veiculoBO = new VeiculoBO();
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioAluguel anAluguel;
		Veiculo veiculo = null;
		
		anAluguel = anAluguelBO.listarMyAluguelId(Integer.parseInt(idAnuncio));
		
		int idVeiculo = anAluguel.getVeiculo().getId_veiculo();
		
		veiculo = veiculoBO.listarVeiculoID(idVeiculo);
		String fone_cel = veiculo.getUsuario().getTelefone_cel();
		String fone_fixo = veiculo.getUsuario().getTelefone_fixo();

		
          /*Verifica se usuario esta logado */
		HttpSession session = request.getSession();

		if(session.getAttribute("usuarioLogado") == null){
			request.setAttribute("anAluguel", anAluguel);
			request.setAttribute("anVeiculo", veiculo);
			
			/*Tratar telefone*/
			if(fone_cel != null){
			String cel = fone_cel.substring(0, 10);
            request.setAttribute("fone_cel", cel);
            
            String fixo = fone_fixo.substring(0, 10);
            request.setAttribute("fone_fixo", fixo);
			}


		}else{
			request.setAttribute("anVeiculo", veiculo);
			request.setAttribute("anAluguel", anAluguel);
            request.setAttribute("fone_cel", fone_cel);
            request.setAttribute("fone_fixo", fone_fixo);



		}


		
		
		
		return proximo;
	}

}
