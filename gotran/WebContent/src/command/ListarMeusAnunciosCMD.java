package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioAluguelBO;
import bo.AnuncioEscolarBO;
import bo.AnuncioExcursaoBO;
import bo.AnuncioFreteBO;
import bo.UsuarioBO;
import modelo.AnuncioAluguel;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;
import modelo.AnuncioFrete;
import modelo.Usuario;

public class ListarMeusAnunciosCMD implements Command, Serializable {

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioEscolarBO anEscolarBO;
	private AnuncioFreteBO anFreteBO;
	private AnuncioExcursaoBO anExcursaoBO;
	private AnuncioAluguelBO anAluguelBO;
	private UsuarioBO usuarioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

        proximo = "privado/anunciante/meus_anuncios.jsp";
        anEscolarBO = new AnuncioEscolarBO();
        anFreteBO = new AnuncioFreteBO();
        anExcursaoBO = new AnuncioExcursaoBO();
        anAluguelBO = new AnuncioAluguelBO();
        usuarioBO = new UsuarioBO();
        Usuario usuario = null;
        
        
        String idUsuario = request.getParameter("id_usuario");
        
        List<AnuncioEscolar> listarEscolar = anEscolarBO.listarMyAnEscolar(Integer.parseInt(idUsuario));
        List<AnuncioFrete> listarFrete = anFreteBO.listarMyAnFrete(Integer.parseInt(idUsuario));
        List<AnuncioExcursao> listarExcursao = anExcursaoBO.listarMyAnExcursao(Integer.parseInt(idUsuario));
        List<AnuncioAluguel> listarAluguel = anAluguelBO.listarMyAnAluguel(Integer.parseInt(idUsuario));
        
        HttpSession session = request.getSession();
        Object  email = session.getAttribute("usuarioLogado");
        
       List<Usuario> list =  usuarioBO.verificarUsuarioSessao(Integer.parseInt(idUsuario), String.valueOf(email));

       if(list.isEmpty()){
    	   proximo = "erro404.jsp";
       }else{

        if(!listarEscolar.isEmpty()){
           request.setAttribute("listarAnEscolar", listarEscolar);          
        }
        
        if(!listarFrete.isEmpty()){
            request.setAttribute("listarAnFrete", listarFrete);
        }
        
        if(!listarExcursao.isEmpty()){
            request.setAttribute("listarAnExcursao", listarExcursao);
        }
        
        if(!listarAluguel.isEmpty()){
            request.setAttribute("listarAnAluguel", listarAluguel);
        }
        
        
       }
		
		return proximo;
	}

}
