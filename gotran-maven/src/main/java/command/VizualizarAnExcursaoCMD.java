package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.io.STAXEventReader;

import bo.AnuncioEscolarBO;
import bo.AnuncioExcursaoBO;
import bo.AnuncioFreteBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class VizualizarAnExcursaoCMD implements Command, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String proximo = "";
	private AnuncioExcursaoBO anExcursaoBO;
	private VeiculoBO veiculoBO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/ver_anuncio_excursao.jsp";
		anExcursaoBO = new AnuncioExcursaoBO();
		veiculoBO = new VeiculoBO();
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioExcursao anExcursao = null;
		Veiculo veiculo = null;
		
		anExcursao = anExcursaoBO.listarMyExcursaoId(Integer.parseInt(idAnuncio));
		
		
		int idVeiculo = anExcursao.getVeiculo().getId_veiculo();
		
		veiculo = veiculoBO.listarVeiculoID(idVeiculo);
		String fone_cel = veiculo.getUsuario().getTelefone_cel();
		String fone_fixo = veiculo.getUsuario().getTelefone_fixo();

		/*Pegar data e hora separado da excursao*/
		String dt_pt = anExcursao.getData_excursao();
		String dt_partida = dt_pt.substring(0, 10);
		request.setAttribute("dt_partida", dt_partida);
		
		String hora_pt = dt_pt.substring(10,16);
		request.setAttribute("hora_pt", hora_pt);
		
		String dt_rt = anExcursao.getData_retorno();
		String dt_retorno = dt_rt.substring(0, 10);
		request.setAttribute("dt_retorno", dt_retorno);
		
		String hora_rt = dt_rt.substring(10,16);
		request.setAttribute("hora_rt", hora_rt);



		
          /*Verifica se usuario esta logado */
		HttpSession session = request.getSession();

		if(session.getAttribute("usuarioLogado") == null){
			request.setAttribute("anVeiculo", veiculo);
			request.setAttribute("anExcursao", anExcursao);

			/*Tratar telefone*/
			if(fone_cel != null){
			String cel = fone_cel.substring(0, 10);
            request.setAttribute("fone_cel", cel);
            
            String fixo = fone_fixo.substring(0, 10);
            request.setAttribute("fone_fixo", fixo);
			}


		}else{
			request.setAttribute("anVeiculo", veiculo);
            request.setAttribute("fone_cel", fone_cel);
            request.setAttribute("fone_fixo", fone_fixo);


			request.setAttribute("anExcursao", anExcursao);

		}


		
		
		
		return proximo;
	}

}
