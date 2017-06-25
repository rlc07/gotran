package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioBO;
import bo.AnuncioFreteBO;
import bo.UsuarioBO;
import modelo.AnuncioFrete;
import modelo.Usuario;
import modelo.Veiculo;

public class EditarAnFreteCMD implements Command,Serializable {

	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioFreteBO anFreteBO;
	private AnuncioBO anBO;
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "privado/anunciante/editar_anuncio_carreto.jsp";
		anFreteBO = new AnuncioFreteBO();
		anBO = new AnuncioBO();
		usuarioBO = new UsuarioBO();
		Usuario usuario = null;
		
		AnuncioFrete anFrete = null;
		
		String idUsuario = request.getParameter("id_usuario");
		String idAnuncio = request.getParameter("id_anuncio");
		
		HttpSession session = request.getSession();
		Object email = session.getAttribute("usuarioLogado");
		String emailPass = String.valueOf(email);
		
		usuario = usuarioBO.localizarIdUsuario(Integer.parseInt(idUsuario));
		String emailBlok = usuario.getEmail();

		
		List<AnuncioFrete> list = anFreteBO.listarFrId(Integer.parseInt(idAnuncio), emailPass);
		
		if(list.isEmpty() || !emailPass.equals(emailBlok)){
			proximo = "erro404.jsp";
		}else{
		
		List<Veiculo> listarVeiculo = anBO.listarSelectVeiculoFrete(Integer.parseInt(idUsuario));
		request.setAttribute("listSelect", listarVeiculo);
		
	    anFrete =  anFreteBO.listarAnFreteID(Integer.parseInt(idAnuncio));
		request.setAttribute("anFrete", anFrete);
		

              if(anFrete.getTipo_carga().equals("tonelada")){
          		request.setAttribute("tonelada", anFrete.getCarga());
              }else if(anFrete.getTipo_carga().equals("kilo")){
            		request.setAttribute("kilo", anFrete.getCarga());

              }
		}
		return proximo;
	}

}
