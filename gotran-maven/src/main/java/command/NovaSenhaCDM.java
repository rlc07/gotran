package command;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UsuarioBO;
import modelo.Usuario;
import util.CriptoUtil;

public class NovaSenhaCDM implements Command, Serializable{

	private String proximo = "";
	private  UsuarioBO usuarioBO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "alterar_senha.jsp";
		usuarioBO = new UsuarioBO();
		
		CriptoUtil cripto = new CriptoUtil();
		
		String codigo = request.getParameter("codigo");
		String nsenha = request.getParameter("nsenha");
		String email = request.getParameter("email");
		
		if(codigo == "" || codigo == null && nsenha == "" || nsenha == null &&
				email == "" || email == null){
			
			request.setAttribute("msgVazia", "O campo deve ser preenchido!");
			
		}else{
		List<Usuario> lista = usuarioBO.verificarEmaileCodigo(email, codigo);
		
		if(!lista.isEmpty()){
			
			int idUsuario = 0;
			
			for(Usuario user : lista){
				idUsuario = user.getId_usuario();
			}
			
			Usuario usuario = null;
			usuario = usuarioBO.localizarIdUsuario(idUsuario);
			
			usuario.setSenha(cripto.criptoStringMD5(nsenha));
			usuario.setCodigo("");
			usuarioBO.atualizarUsuario(usuario);
			request.setAttribute("msgOk", "Senha alterada com sucesso!");
			
		}else{
			request.setAttribute("msgErro", "Email ou Codigo invalido!");
	  	    try {
				response.getWriter().write("gol");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		
		}
		
		
		return proximo;
	}
	


}
