package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UsuarioBO;
import modelo.Usuario;
import util.CriptoUtil;

public class UsuarioCMD implements Command{

	private String proximo = "";
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "login.jsp";
		usuarioBO = new UsuarioBO();
		
		/*Recuperar Valores*/
		
		String nome  = request.getParameter("nome_cadastro");
		String snome = request.getParameter("snome_cadastro");
		String email = request.getParameter("email_cadastro");
		String senha = request.getParameter("senha_cadastro");
		
		/*Seta os valores*/
		Usuario usuario = new Usuario();
		CriptoUtil cript = new CriptoUtil();
		
		usuario.setNome(nome);
		usuario.setSobre_nome(snome);
		usuario.setEmail(email);
		usuario.setSenha(cript.criptoStringMD5(senha));
		usuario.setImg_perfil("default_avatar_male.jpg");
		
		/*Persiste os dados no banco*/
		usuarioBO.inserirUsuario(usuario);
		
		return proximo;
	}


}
