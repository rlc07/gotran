package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UsuarioBO;
import modelo.Usuario;

public class AtualizarUsuarioCMD implements Command, Serializable{

	
	private static final long serialVersionUID = -3007152272434559413L;
    private UsuarioBO usuarioBO;
    private String proximo = "";
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		usuarioBO = new UsuarioBO();
		proximo = "privado/anunciante/minha_conta.jsp";
		
		/*recupera valores*/
		String id_usuario = request.getParameter("id_usuario");
		String nome = request.getParameter("nome_atualizacao");
		String snome = request.getParameter("snome_atualizacao");
		String foneFixo = request.getParameter("fone_fixo");
		String foneCel = request.getParameter("fone_cel");
		String email = request.getParameter("email_atualizacao");
		String senha = request.getParameter("senha_atualizacao");
		
		/*Recuperar dados modal*/
		String senha_atual = request.getParameter("atual_senha_modal");
		String nova_senha = request.getParameter("nova_senha_modal");
		
		String foneFixoAnuncio = request.getParameter("fone_fixoAnuncio");
		String foneCelAnuncio = request.getParameter("fone_celAnuncio");
		
		if(foneFixoAnuncio != null || foneCelAnuncio != null){
			Usuario usuario = null;
			usuario = usuarioBO.localizarIdUsuario(Integer.parseInt(id_usuario));

			if(foneFixoAnuncio != ""){
				usuario.setTelefone_fixo(foneFixoAnuncio);
			}if(foneCelAnuncio != ""){
				usuario.setTelefone_cel(foneCelAnuncio);
			}
			
			usuarioBO.atualizarUsuario(usuario);
			
		}else{
		
		try{
		if(usuarioBO.localizarPorEmail(email) == true  &&
				usuarioBO.localizarIdUsuario(Integer.parseInt(id_usuario))!=null){
			Usuario atualizarUsuario = new Usuario();
			atualizarUsuario = usuarioBO.localizarIdUsuario(Integer.parseInt(id_usuario));
			atualizarUsuario.setId_usuario(Integer.parseInt(id_usuario));
			atualizarUsuario.setEmail(email);
			atualizarUsuario.setNome(nome);
			atualizarUsuario.setSenha(senha);
			atualizarUsuario.setSobre_nome(snome);
			atualizarUsuario.setTelefone_cel(foneCel);
			atualizarUsuario.setTelefone_fixo(foneFixo);
			
			usuarioBO.atualizarUsuario(atualizarUsuario);
			
		}else if(senha_atual != null){
            Usuario atualizarSenha = new Usuario();
            atualizarSenha = usuarioBO.localizarIdUsuario(Integer.parseInt(id_usuario));
            String senha_atual_banco = atualizarSenha.getSenha();
            if(senha_atual.equals(senha_atual_banco )){
            	atualizarSenha.setSenha(nova_senha);
                usuarioBO.atualizarUsuario(atualizarSenha);
                request.getSession().invalidate();
        		proximo = "/gotran/login.jsp";

                
            }else{
            	
            	request.setAttribute("msgSenha", "A senha informada é diferente da senha atual.");

            }
		}
		}catch(Exception e){
			e.getMessage();
		}
		}

		return proximo;
	}



}
