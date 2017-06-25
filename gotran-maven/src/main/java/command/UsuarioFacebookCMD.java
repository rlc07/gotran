package command;


import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import bo.UsuarioBO;
import dao.UsuarioDAO;
import modelo.Usuario;
import modelo.UsuarioFacebook;
import social.FBConnection;



public class UsuarioFacebookCMD implements Serializable, Command {

	
	private static final long serialVersionUID = -4125560757705675176L;
    
	UsuarioBO usuarioBO;
	String proximo;
	private String code="";
	
	
	@SuppressWarnings("unused")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		usuarioBO = new UsuarioBO();
		proximo = "login.jsp";
		FBConnection fbConnection = new FBConnection();
		
		code = request.getParameter("code");
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		String retorno = null;
		try {
			retorno = FBConnection.readURL(new URL(fbConnection.getFBGraphUrl(code)));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String accessToken = null;
		@SuppressWarnings("unused")
		Integer expires = null;
		String[] pairs = retorno.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			if (kv.length != 2) {				
				throw new RuntimeException("Resposta auth inesperada.");				
			} else {
				if (kv[0].equals("access_token")) {
					accessToken = kv[1];
				}
				if (kv[0].equals("expires")) {
					expires = Integer.valueOf(kv[1]);
				}
			}
		}

		JSONObject resp = null;
		try {
			try {
				resp = new JSONObject(FBConnection.readURL(new URL(
						"https://graph.facebook.com/me?fields=id,first_name,last_name,picture,email&access_token=" + accessToken)));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		try{
			
       UsuarioFacebook usuarioFacebook = new UsuarioFacebook(resp);
			
			
			
			
			String email = usuarioFacebook.getEmail();
		

			if(usuarioBO.localizarPorEmail(email) == false){
				Usuario usuario = new Usuario();

				usuario.setEmail(usuarioFacebook.getEmail());
				usuario.setNome(usuarioFacebook.getFirst_name());
				usuario.setSobre_nome(usuarioFacebook.getLast_name());
				usuario.setId_facebook(usuarioFacebook.getId());
				usuarioBO.inserirUsuario(usuario);
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuario);
				proximo = "main?action=minha-conta/";
			}else if(usuarioBO.localizarPorEmail(email)==true){
				Usuario usuario = null;
				
				List<Usuario> listar = usuarioBO.verificarUsuarioFace(usuarioFacebook.getId());
				
				if(!listar.isEmpty()){
					int idUsuarioFace = 0;
					
					
					for(Usuario user : listar){
						
						idUsuarioFace = user.getId_usuario();
						
					}
					
					
					
					usuario = usuarioBO.localizarIdUsuario(idUsuarioFace);
				
					HttpSession session = request.getSession();
					session.setAttribute("usuarioLogado", usuario);
	                proximo = "main?action=minha-conta/";
				}
			
			}
			
			
		}catch(Exception e){
			
		}
			

		
		


     return proximo;
	}


	
}

