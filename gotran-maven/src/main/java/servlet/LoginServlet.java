package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.UsuarioBO;
import dao.UsuarioDAO;
import modelo.Usuario;
import util.CriptoUtil;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private UsuarioBO usuarioBO;
	private UsuarioDAO usuarioDAO;
	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     usuarioBO = new UsuarioBO();
     usuarioDAO = new UsuarioDAO();
     Usuario usuarioLogado = new Usuario();
     CriptoUtil cript = new CriptoUtil();

     
     /*Recuperar valores*/
     String email = request.getParameter("email_login");
     String senha = request.getParameter("senha_login");
     
     /*Dados google*/
        String nome = request.getParameter("user_name");
		String emailGoogle = request.getParameter("user_email");
		String urlImgPerfil = request.getParameter("user_photo");
		String idUser = request.getParameter("user_id");
      
		if(emailGoogle!= null){
			
			List<Usuario> verificaEmail = usuarioBO.verificaEmail(emailGoogle);
			if(verificaEmail.isEmpty()){
				
				Usuario usuario = new Usuario();
				
				usuario.setEmail(emailGoogle);
				usuario.setNome(nome);
				usuario.setId_google(idUser);
				usuario.setImg_perfil(urlImgPerfil);
				
				usuarioBO.inserirUsuario(usuario);
				
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuario);
		  		response.getWriter().write("true");
			}else{
				
				List<Usuario> userGoogle  = usuarioBO.verificarUsuarioGoogle(idUser, emailGoogle);
				
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

		}else{
     
     if(email != null){
    	 
     if(usuarioBO.login(email, cript.criptoStringMD5(senha)) == true){
    	 usuarioLogado = usuarioDAO.localizarPorEmail(email);
    	 HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", usuarioLogado);
  		response.getWriter().write("true");
     }
     
     }else{
    	 request.getSession().invalidate();
    	 request.setAttribute("email-sair", "");
    	 request.getRequestDispatcher("login.jsp").forward(request, response);
     }
     
     
     
	
	}
	}

}
