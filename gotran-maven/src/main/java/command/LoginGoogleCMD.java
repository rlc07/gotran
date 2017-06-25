package command;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.UsuarioBO;
import dao.UsuarioDAO;
import modelo.Usuario;

public class LoginGoogleCMD implements Command ,Serializable {

	private String proximo = "";
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			service(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proximo;
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuarioBO = new UsuarioBO();
		
		String nome = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String urlImgPerfil = request.getParameter("user_photo");
		String idUser = request.getParameter("user_id");
		
		
		if(email != null){
		List<Usuario> verificaEmail = usuarioBO.verificaEmail(email);
		
		if(verificaEmail.isEmpty()){
			
			Usuario usuario = new Usuario();
			
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setId_google(idUser);
			usuario.setImg_perfil(urlImgPerfil);
			
			usuarioBO.inserirUsuario(usuario);
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
	  		try {
				response.getWriter().write("true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			proximo = "privado/anunciante/meuperfil.jsp";
			
		}else{
			
			List<Usuario> userGoogle  = usuarioBO.verificarUsuarioGoogle(idUser, email);
			
			if(!userGoogle.isEmpty()){
				int idUsuario = 0;
				Usuario usuario = null;
				
				for(Usuario user : userGoogle){
					idUsuario = user.getId_usuario();
				}
				
				usuario = usuarioBO.localizarIdUsuario(idUsuario);
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuario);
				response.getWriter().write("true");
				
			}else{
				request.setAttribute("msgSocial", "Ja existe uma conta cadastrada com esse email!");
			}

			
		}

		}

		}

}
