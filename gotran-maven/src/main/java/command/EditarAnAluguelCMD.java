package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioAluguelBO;
import bo.AnuncioBO;
import bo.UsuarioBO;
import modelo.AnuncioAluguel;
import modelo.Usuario;
import modelo.Veiculo;

public class EditarAnAluguelCMD implements Command, Serializable{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioAluguelBO anAluguelBO;
	private AnuncioBO anuncioBO;
	private UsuarioBO usuarioBO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
 
		proximo = "privado/anunciante/editar_anuncio_aluguel.jsp";
		anAluguelBO = new AnuncioAluguelBO();
		anuncioBO = new AnuncioBO();
		usuarioBO = new UsuarioBO();
		AnuncioAluguel anAluguel = new AnuncioAluguel();
		Usuario usuario = null;
		
		String idUsuario = request.getParameter("id_usuario");
		String idAnuncio = request.getParameter("id_anuncio");
		
		HttpSession session = request.getSession();
		Object email = session.getAttribute("usuarioLogado");
		
		usuario = usuarioBO.localizarIdUsuario(Integer.parseInt(idUsuario));
		
		String emailBlok = usuario.getEmail();
		String emailPass = String.valueOf(email);

		anAluguelBO.listarAlId(Integer.parseInt(idAnuncio), emailPass);
		List<AnuncioAluguel> list = anAluguelBO.listarAlId(Integer.parseInt(idAnuncio), emailPass);
		
		if(list.isEmpty() || !emailPass.equals(emailBlok)){
			proximo = "erro404.jsp";
		}else{
		List<Veiculo> listarVeiculo = anuncioBO.listarMyVeiculos(Integer.parseInt(idUsuario));
		request.setAttribute("listVeiculo", listarVeiculo);
		
		anAluguel = anAluguelBO.listarMyAluguelId(Integer.parseInt(idAnuncio));
		request.setAttribute("anAluguel", anAluguel);
		}
		
		return proximo;
	}

}
