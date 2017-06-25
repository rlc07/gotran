package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import bo.AnuncioBO;
import bo.UsuarioBO;
import jdk.nashorn.api.scripting.JSObject;
import modelo.Usuario;
import modelo.Veiculo;

public class ListarVeiculoEscolar implements Command{

	private AnuncioBO anuncioBO;
	private String proximo = "";
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		proximo = "privado/anunciante/anunciar_escolar.jsp";
		anuncioBO  = new AnuncioBO();
		usuarioBO = new UsuarioBO();
		
		String id = request.getParameter("id_usuario");
		String msg = "Você ainda não possui veiculo p/ frete."
				+ "Cadastre um veiculo para frete para criar um anúncio!";
		
		   HttpSession session = request.getSession();
           Object email = session.getAttribute("usuarioLogado");
           
           List<Usuario> list = usuarioBO.verificarUsuarioSessao(Integer.parseInt(id), String.valueOf(email));
           
           if(list.isEmpty()){
        	   proximo = "erro404.jsp";
           }else{
		
		List<Veiculo> listarVeiculo = anuncioBO.listarSelectVeiculoFretado(Integer.parseInt(id));
		
		if(listarVeiculo == null || listarVeiculo.isEmpty()){
			request.setAttribute("msgListaVazia", msg);

		}else{
			 
			List<Veiculo> listarMyVeiculo = anuncioBO.listarMyVeiculos(Integer.parseInt(id));
			 
		      Gson gson = new Gson();

		      String aux = gson.toJson(listarMyVeiculo);
				request.setAttribute("carregarMyVeiculo", listarMyVeiculo);

		       
			request.setAttribute("carregarSelect", listarVeiculo);

		}
		
           }
		return proximo;
	}

}
