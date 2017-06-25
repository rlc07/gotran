package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.dom4j.io.STAXEventReader;

import bo.AnuncioEscolarBO;
import bo.AnuncioFreteBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class VizualizarAnFreteCMD implements Command, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String proximo = "";
	private AnuncioFreteBO anFreteBO;
	private VeiculoBO veiculoBO;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {

		proximo = "publico/buscador/ver_anuncio_frete.jsp";
		anFreteBO = new AnuncioFreteBO();
		veiculoBO = new VeiculoBO();
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioFrete anFrete = null;
		Veiculo veiculo = null;
		
		anFrete = anFreteBO.listarAnFreteID(Integer.parseInt(idAnuncio));
		
		int idVeiculo = anFrete.getVeiculo().getId_veiculo();
		
		veiculo = veiculoBO.listarVeiculoID(idVeiculo);
		String fone_cel = veiculo.getUsuario().getTelefone_cel();
		String fone_fixo = veiculo.getUsuario().getTelefone_fixo();

		/*Recuperar carga suportada*/
		String tipo_carga = anFrete.getTipo_carga();
		double carga = anFrete.getCarga();
		
		String tcarga = tipo_carga += ": " +carga;

		request.setAttribute("carga", tcarga);
		
          /*Verifica se usuario esta logado */
		HttpSession session = request.getSession();

		if(session.getAttribute("usuarioLogado") == null){
			request.setAttribute("anFrete", anFrete);
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
			request.setAttribute("anFrete", anFrete);
            request.setAttribute("fone_cel", fone_cel);
            request.setAttribute("fone_fixo", fone_fixo);



		}


		
		
		
		return proximo;
	}

}
