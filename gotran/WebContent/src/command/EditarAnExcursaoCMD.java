package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioBO;
import bo.AnuncioExcursaoBO;
import bo.AnuncioFreteBO;
import bo.UsuarioBO;
import modelo.AnuncioExcursao;
import modelo.Usuario;
import modelo.Veiculo;

public class EditarAnExcursaoCMD implements Command, Serializable{

	private String proximo = "";
	private AnuncioBO anuncioBO;
	private AnuncioExcursaoBO anExcursaoBO;
	private UsuarioBO usuarioBO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "privado/anunciante/editar_anuncio_excursao.jsp";
		anuncioBO = new AnuncioBO();
		anExcursaoBO = new AnuncioExcursaoBO();
		AnuncioExcursao anExcursao = new AnuncioExcursao();
		usuarioBO = new UsuarioBO();
		Usuario usuario = null;
		
		String idUsuario = request.getParameter("id_usuario");
		String idAnuncio = request.getParameter("id_anuncio");
		
		HttpSession session = request.getSession();
		Object email = session.getAttribute("usuarioLogado");
		usuario = usuarioBO.localizarIdUsuario(Integer.parseInt(idUsuario));
		
		String emailBlok = usuario.getEmail();
		String emailPass = String.valueOf(email);
		
		List<AnuncioExcursao> list = anExcursaoBO.listarExId(Integer.parseInt(idAnuncio), emailPass);
		
		if(list.isEmpty() || !emailPass.equals(emailBlok)){
			proximo = "erro404.jsp";
		}else{
		List<Veiculo> listarVeiculo = anuncioBO.listarSelectVeiculoFretado(Integer.parseInt(idUsuario));
		request.setAttribute("listarVeiculo", listarVeiculo);
		
		anExcursao = anExcursaoBO.listarMyExcursaoId(Integer.parseInt(idAnuncio));
		request.setAttribute("anExcursao", anExcursao);
		}
		
		
		return proximo;
	}

}
