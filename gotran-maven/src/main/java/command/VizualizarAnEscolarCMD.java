package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.io.STAXEventReader;

import bo.AnuncioEscolarBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.Veiculo;

public class VizualizarAnEscolarCMD implements Command, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String proximo = "";
	private AnuncioEscolarBO anEscolarBO;
	private VeiculoBO veiculoBO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/ver_anuncio_escolar.jsp";
		anEscolarBO = new AnuncioEscolarBO();
		veiculoBO = new VeiculoBO();
		
		String idAnuncio = request.getParameter("id_anuncio");
		
		AnuncioEscolar anEscolar = null;
		Veiculo veiculo = null;
		
		anEscolar = anEscolarBO.listarEscolarId(Integer.parseInt(idAnuncio));
		
		int idVeiculo = anEscolar.getVeiculo().getId_veiculo();
		
		veiculo = veiculoBO.listarVeiculoID(idVeiculo);
		String fone_cel = veiculo.getUsuario().getTelefone_cel();
		String fone_fixo = veiculo.getUsuario().getTelefone_fixo();
		String email = veiculo.getUsuario().getEmail();

		/*recupera as instituições*/
		int tmInstituicao = anEscolar.getInstituicao().size();
		
		for(int i=0; i<=tmInstituicao; i++){
			
			if(tmInstituicao == 1){
				
				request.setAttribute("inst1", anEscolar.getInstituicao().get(0).getNome_instituicao());
				request.setAttribute("cid1", anEscolar.getInstituicao().get(0).getCidade_instituicao());
         
			}else if(tmInstituicao == 2){
				
				request.setAttribute("inst1", anEscolar.getInstituicao().get(0).getNome_instituicao());
				request.setAttribute("cid1", anEscolar.getInstituicao().get(0).getCidade_instituicao());
				request.setAttribute("inst2", anEscolar.getInstituicao().get(1).getNome_instituicao());
				request.setAttribute("cid2", anEscolar.getInstituicao().get(1).getCidade_instituicao());
				
			}else if(tmInstituicao == 3){
				
				request.setAttribute("inst1", anEscolar.getInstituicao().get(0).getNome_instituicao());
				request.setAttribute("cid1", anEscolar.getInstituicao().get(0).getCidade_instituicao());
				request.setAttribute("inst2", anEscolar.getInstituicao().get(1).getNome_instituicao());
				request.setAttribute("cid2", anEscolar.getInstituicao().get(1).getCidade_instituicao());
				request.setAttribute("inst3", anEscolar.getInstituicao().get(2).getNome_instituicao());
				request.setAttribute("cid3", anEscolar.getInstituicao().get(2).getCidade_instituicao());
				
				
			}
			
		}
		
		
          /*Verifica se usuario esta logado */
		HttpSession session = request.getSession();

		if(session.getAttribute("usuarioLogado") == null){
			request.setAttribute("anEscolar", anEscolar);
			request.setAttribute("anVeiculo", veiculo);
			
			/*Tratar telefone*/
			if(!fone_cel.equals("")){
			String cel = fone_cel.substring(0, 10);
			request.setAttribute("fone_cel", cel);

			}
			if(!fone_fixo.equals("")){
				String fixo = fone_fixo.substring(0, 10);
	            request.setAttribute("fone_fixo", fixo);
			}


		}else{
			request.setAttribute("anVeiculo", veiculo);
			request.setAttribute("anEscolar", anEscolar);
            request.setAttribute("fone_cel", fone_cel);
            request.setAttribute("fone_fixo", fone_fixo);



		}


		
		
		
		return proximo;
	}

}
