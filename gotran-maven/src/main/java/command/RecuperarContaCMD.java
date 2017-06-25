package command;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import bo.UsuarioBO;
import modelo.Usuario;
import util.CriptoUtil;

public class RecuperarContaCMD implements Command, Serializable{
	
	private String proximo = "";
	private UsuarioBO usuarioBO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "login.jsp";
		usuarioBO = new UsuarioBO();
		
		String emailGotran = "gotrantcc@gmail.com";
		String senhaGotran = "gotrantcc2016";
		
		String emailUser = request.getParameter("email_recuperar");
		Usuario usuario = null;
		
		
		if(emailUser != ""){
			
			usuario = usuarioBO.localizarUserporEmail(emailUser);
			  CriptoUtil cript = new CriptoUtil();
			 
				
				String[] letras ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g"};
				  String codigo = "";
			      Random ran = new Random();
			      
				  for ( int i = 0; i < 9; i++){
				    int a = ran.nextInt(letras.length);
				    codigo += letras[a];
				  }
				  
				  usuario.setCodigo(codigo);
				  usuarioBO.atualizarUsuario(usuario);
				  
				  String link = "http://localhost:8080/gotran/alterar_senha.jsp";
				  
				  String mensagem = "<h4>Olá sr.(a) " + usuario.getNome() + "</h4>" +  
			                "<br>" +  
			                "<p> Recebemos uma solicitação para informação dos dados de autenticação para este e-mail, "
			                + "caso não tenha feito esta solicitação, favor desconsiderar o mesmo.</p>" +  
			                "<br>" +  
			                "<p>Os dados solicitados são: </p>" +  
			                "<ul>" + 
			                "<li><b> - Email: </b>" + usuario.getEmail()+ 
			                "<li><b> - Codigo: </b>" + codigo + 
			                "<b style='color:red;'> <h3> OBS: COPIE E COLE O LINK NO SEU NAVEGADOR. </h3> </b>"  + 
                            "<li><b> - Link: </b>"   + link +  
			                "</ul>" +  
			                "<br>" +  
			                "<p> Att, </p>" +  
			                "<br>" +  
			                "app@gotran.com.br" +  
			                "<br> \n";  
					
					HtmlEmail email = new HtmlEmail();
					email.setSSLOnConnect(true);
					email.setHostName( "pop.gmail.com" );
					email.setSmtpPort(995);
					email.setAuthentication(emailGotran, senhaGotran);
					try {
					    email.setFrom( "app@gotran.com.br");
					     
					    email.setDebug(true); 
					     
					    email.setSubject( "Recuperação de senha" );
					    email.setHtmlMsg(mensagem);
					    email.addTo( emailUser );
					     
					    email.send();
					     
					} catch (EmailException e) {
					    e.printStackTrace();
					}
		         }
	
		return proximo;
	}

}
