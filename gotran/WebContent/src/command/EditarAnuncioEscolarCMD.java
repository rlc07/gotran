package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioBO;
import bo.AnuncioEscolarBO;
import bo.UsuarioBO;
import bo.VeiculoBO;
import modelo.AnuncioEscolar;
import modelo.Usuario;
import modelo.Veiculo;

public class EditarAnuncioEscolarCMD implements Serializable, Command {

	
	private static final long serialVersionUID = 1L;

	private AnuncioEscolarBO anEscolarBO;
	private String proximo = "";
	private AnuncioBO anBO;
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
         
		anEscolarBO = new AnuncioEscolarBO();
		anBO = new AnuncioBO();
		usuarioBO = new UsuarioBO();
		
		AnuncioEscolar anEscolar = null;
		proximo = "privado/anunciante/editar_anuncio_escolar.jsp";
		
		String idAnuncio = request.getParameter("id_anuncio");
		String idUsuario = request.getParameter("id_usuario");

		Usuario user = null;
		
		List<Veiculo> listarVeiculo = anBO.listarSelectVeiculoFretado(Integer.parseInt(idUsuario));
		request.setAttribute("carregarSelect", listarVeiculo);

   	    HttpSession sessao = request.getSession();
	    	
	    	 Object email = sessao.getAttribute("usuarioLogado");
	    	 
	   	    	user = usuarioBO.localizarIdUsuario(Integer.parseInt(idUsuario));
                 usuarioBO.localizarPorEmail(String.valueOf(email));
           

	   	    	String emailBlok = user.getEmail();
                String emailPass = String.valueOf(email);
       	        anEscolar = anEscolarBO.listarEscolarId(Integer.parseInt(idAnuncio));
       	        
       	        int idVeiculo = anEscolar.getVeiculo().getId_veiculo();
       	        
       	        /*Verifica se o anúncio X é do usuario*/
       	      List<AnuncioEscolar> anList =  anEscolarBO.listarEsId(Integer.parseInt(idAnuncio), emailPass);
       	   


   	    if(!emailPass.equals(emailBlok) || anList.isEmpty()){
   	    	proximo = "erro404.jsp";
   	    }else{

   	        anEscolar = anEscolarBO.listarEscolarId(Integer.parseInt(idAnuncio));
   			request.setAttribute("anEscolar", anEscolar);
   			
   			int tamanho = anEscolar.getInstituicao().size();
   			
   			
   			for(int i=0; i<=tamanho; i++){
   				
   				if(tamanho == 1){
   					request.setAttribute("anEscolarInt1", anEscolar.getInstituicao().get(0).getNome_instituicao());
   					request.setAttribute("anEscolarCid1", anEscolar.getInstituicao().get(0).getCidade_instituicao());			}
   				else if(tamanho == 2){
   					
   					request.setAttribute("anEscolarInt1", anEscolar.getInstituicao().get(0).getNome_instituicao());
   					request.setAttribute("anEscolarCid1", anEscolar.getInstituicao().get(0).getCidade_instituicao());

   					request.setAttribute("anEscolarInt2", anEscolar.getInstituicao().get(1).getNome_instituicao());
   					request.setAttribute("anEscolarCid2", anEscolar.getInstituicao().get(1).getCidade_instituicao());

   				}
   				else if(tamanho == 3){
   					request.setAttribute("anEscolarInt1", anEscolar.getInstituicao().get(0).getNome_instituicao());
   					request.setAttribute("anEscolarCid1", anEscolar.getInstituicao().get(0).getCidade_instituicao());

   					request.setAttribute("anEscolarInt2", anEscolar.getInstituicao().get(1).getNome_instituicao());
   					request.setAttribute("anEscolarCid2", anEscolar.getInstituicao().get(1).getCidade_instituicao());
   					
   					request.setAttribute("anEscolarInt3", anEscolar.getInstituicao().get(2).getNome_instituicao());
   					request.setAttribute("anEscolarCid3", anEscolar.getInstituicao().get(2).getCidade_instituicao());
   	     		}
   			

   			}
   			
   			int tamanho2 = anEscolar.getBairroEscolar().size();
   			
   			for(int i=0; i<tamanho2; i++){
   				
   				if(tamanho2 == 1){
   					request.setAttribute("lat1", anEscolar.getBairroEscolar().get(0).getLatitude());
   					request.setAttribute("lon1", anEscolar.getBairroEscolar().get(0).getLongitude());
   					request.setAttribute("raio1", anEscolar.getBairroEscolar().get(0).getKm());
   					request.setAttribute("m1", anEscolar.getBairroEscolar().get(0).getMetro());
   				}
   				
   				if(tamanho2 == 2){
   					request.setAttribute("lat1", anEscolar.getBairroEscolar().get(0).getLatitude());
   					request.setAttribute("lon1", anEscolar.getBairroEscolar().get(0).getLongitude());
   					request.setAttribute("raio1", anEscolar.getBairroEscolar().get(0).getKm());
   					request.setAttribute("m1", anEscolar.getBairroEscolar().get(0).getMetro());
   					
   					request.setAttribute("lat2", anEscolar.getBairroEscolar().get(1).getLatitude());
   					request.setAttribute("lon2", anEscolar.getBairroEscolar().get(1).getLongitude());
   					request.setAttribute("raio2", anEscolar.getBairroEscolar().get(1).getKm());
   					request.setAttribute("m2", anEscolar.getBairroEscolar().get(1).getMetro());
   				}
   				
   				if(tamanho2 == 3){
   					request.setAttribute("lat1", anEscolar.getBairroEscolar().get(0).getLatitude());
   					request.setAttribute("lon1", anEscolar.getBairroEscolar().get(0).getLongitude());
   					request.setAttribute("raio1", anEscolar.getBairroEscolar().get(0).getKm());
   					request.setAttribute("m1", anEscolar.getBairroEscolar().get(0).getMetro());
   					
   					request.setAttribute("lat2", anEscolar.getBairroEscolar().get(1).getLatitude());
   					request.setAttribute("lon2", anEscolar.getBairroEscolar().get(1).getLongitude());
   					request.setAttribute("raio2", anEscolar.getBairroEscolar().get(1).getKm());
   					request.setAttribute("m2", anEscolar.getBairroEscolar().get(1).getMetro());
   					
   					request.setAttribute("lat3", anEscolar.getBairroEscolar().get(2).getLatitude());
   					request.setAttribute("lon3", anEscolar.getBairroEscolar().get(2).getLongitude());
   					request.setAttribute("raio3", anEscolar.getBairroEscolar().get(2).getKm());
   					request.setAttribute("m3", anEscolar.getBairroEscolar().get(2).getMetro());
   				}
   				if(tamanho2 == 4){
   					request.setAttribute("lat1", anEscolar.getBairroEscolar().get(0).getLatitude());
   					request.setAttribute("lon1", anEscolar.getBairroEscolar().get(0).getLongitude());
   					request.setAttribute("raio1", anEscolar.getBairroEscolar().get(0).getKm());
   					request.setAttribute("m1", anEscolar.getBairroEscolar().get(0).getMetro());
   					
   					request.setAttribute("lat2", anEscolar.getBairroEscolar().get(1).getLatitude());
   					request.setAttribute("lon2", anEscolar.getBairroEscolar().get(1).getLongitude());
   					request.setAttribute("raio2", anEscolar.getBairroEscolar().get(1).getKm());
   					request.setAttribute("m2", anEscolar.getBairroEscolar().get(1).getMetro());
   					
   					request.setAttribute("lat3", anEscolar.getBairroEscolar().get(2).getLatitude());
   					request.setAttribute("lon3", anEscolar.getBairroEscolar().get(2).getLongitude());
   					request.setAttribute("raio3", anEscolar.getBairroEscolar().get(2).getKm());
   					request.setAttribute("m3", anEscolar.getBairroEscolar().get(2).getMetro());
   					
   					request.setAttribute("lat4", anEscolar.getBairroEscolar().get(3).getLatitude());
   					request.setAttribute("lon4", anEscolar.getBairroEscolar().get(3).getLongitude());
   					request.setAttribute("raio4", anEscolar.getBairroEscolar().get(3).getKm());
   					request.setAttribute("m4", anEscolar.getBairroEscolar().get(3).getMetro());
   				}
   				
   				if(tamanho2 == 5){
   					request.setAttribute("lat1", anEscolar.getBairroEscolar().get(0).getLatitude());
   					request.setAttribute("lon1", anEscolar.getBairroEscolar().get(0).getLongitude());
   					request.setAttribute("raio1", anEscolar.getBairroEscolar().get(0).getKm());
   					request.setAttribute("m1", anEscolar.getBairroEscolar().get(0).getMetro());
   					
   					request.setAttribute("lat2", anEscolar.getBairroEscolar().get(1).getLatitude());
   					request.setAttribute("lon2", anEscolar.getBairroEscolar().get(1).getLongitude());
   					request.setAttribute("raio2", anEscolar.getBairroEscolar().get(1).getKm());
   					request.setAttribute("m2", anEscolar.getBairroEscolar().get(1).getMetro());
   					
   					request.setAttribute("lat3", anEscolar.getBairroEscolar().get(2).getLatitude());
   					request.setAttribute("lon3", anEscolar.getBairroEscolar().get(2).getLongitude());
   					request.setAttribute("raio3", anEscolar.getBairroEscolar().get(2).getKm());
   					request.setAttribute("m3", anEscolar.getBairroEscolar().get(2).getMetro());
   					
   					request.setAttribute("lat4", anEscolar.getBairroEscolar().get(3).getLatitude());
   					request.setAttribute("lon4", anEscolar.getBairroEscolar().get(3).getLongitude());
   					request.setAttribute("raio4", anEscolar.getBairroEscolar().get(3).getKm());
   					request.setAttribute("m4", anEscolar.getBairroEscolar().get(3).getMetro());
   					
   					request.setAttribute("lat5", anEscolar.getBairroEscolar().get(4).getLatitude());
   					request.setAttribute("lon5", anEscolar.getBairroEscolar().get(4).getLongitude());
   					request.setAttribute("raio5", anEscolar.getBairroEscolar().get(4).getKm());
   					request.setAttribute("m5", anEscolar.getBairroEscolar().get(4).getMetro());
   				}
   				if(tamanho2 == 6){
   					request.setAttribute("lat1", anEscolar.getBairroEscolar().get(0).getLatitude());
   					request.setAttribute("lon1", anEscolar.getBairroEscolar().get(0).getLongitude());
   					request.setAttribute("raio1", anEscolar.getBairroEscolar().get(0).getKm());
   					request.setAttribute("m1", anEscolar.getBairroEscolar().get(0).getMetro());
   					
   					request.setAttribute("lat2", anEscolar.getBairroEscolar().get(1).getLatitude());
   					request.setAttribute("lon2", anEscolar.getBairroEscolar().get(1).getLongitude());
   					request.setAttribute("raio2", anEscolar.getBairroEscolar().get(1).getKm());
   					request.setAttribute("m2", anEscolar.getBairroEscolar().get(1).getMetro());
   					
   					request.setAttribute("lat3", anEscolar.getBairroEscolar().get(2).getLatitude());
   					request.setAttribute("lon3", anEscolar.getBairroEscolar().get(2).getLongitude());
   					request.setAttribute("raio3", anEscolar.getBairroEscolar().get(2).getKm());
   					request.setAttribute("m3", anEscolar.getBairroEscolar().get(2).getMetro());
   					
   					request.setAttribute("lat4", anEscolar.getBairroEscolar().get(3).getLatitude());
   					request.setAttribute("lon4", anEscolar.getBairroEscolar().get(3).getLongitude());
   					request.setAttribute("raio4", anEscolar.getBairroEscolar().get(3).getKm());
   					request.setAttribute("m4", anEscolar.getBairroEscolar().get(3).getMetro());
   					
   					request.setAttribute("lat5", anEscolar.getBairroEscolar().get(4).getLatitude());
   					request.setAttribute("lon5", anEscolar.getBairroEscolar().get(4).getLongitude());
   					request.setAttribute("raio5", anEscolar.getBairroEscolar().get(4).getKm());
   					request.setAttribute("m5", anEscolar.getBairroEscolar().get(4).getMetro());
   					
   					request.setAttribute("lat6", anEscolar.getBairroEscolar().get(5).getLatitude());
   					request.setAttribute("lon6", anEscolar.getBairroEscolar().get(5).getLongitude());
   					request.setAttribute("raio6", anEscolar.getBairroEscolar().get(5).getKm());
   					request.setAttribute("m6", anEscolar.getBairroEscolar().get(5).getMetro());
   				}
   			}
   			
   			
   	    }
         
       
		
		return proximo;
	}

}
