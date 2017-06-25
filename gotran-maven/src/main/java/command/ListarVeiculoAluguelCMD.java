package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioBO;
import bo.UsuarioBO;
import modelo.Usuario;
import modelo.Veiculo;

public class ListarVeiculoAluguelCMD implements Command, Serializable{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioBO anuncioBO;
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
           anuncioBO = new AnuncioBO();
           proximo = "privado/anunciante/anunciar_aluguel.jsp";
           String msg = "Você ainda não possui veiculo p/ frete."
   				+ "Cadastre um veiculo para criar um anúncio!";
           
           usuarioBO = new UsuarioBO();
           
           String id = request.getParameter("id_usuario");
           
           HttpSession session = request.getSession();
           Object email = session.getAttribute("usuarioLogado");
           
           List<Usuario> list = usuarioBO.verificarUsuarioSessao(Integer.parseInt(id), String.valueOf(email));
           
           if(list.isEmpty()){
        	   proximo = "erro404.jsp";
           }else{
           List<Veiculo> listar = anuncioBO.listarSelectVeiculoFretado(Integer.parseInt(id));
           
           if(listar == null || listar.isEmpty()){
        	   request.setAttribute("msgListaVazia", msg);
           }else{
        	   request.setAttribute("carregarSelect", listar);
           }
           }
           
		return proximo;
	}

}
