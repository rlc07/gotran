package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AnuncioBO;
import bo.UsuarioBO;
import bo.VeiculoBO;
import modelo.Usuario;
import modelo.Veiculo;

public class ListarMyVeiculoCMD implements Command{

	private VeiculoBO veiculoBO;
	private UsuarioBO usuarioBO;
	private String proximo = "";
	@SuppressWarnings("unused")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		proximo = "privado/anunciante/meus_veiculos.jsp";
		
		veiculoBO = new VeiculoBO();
		usuarioBO = new UsuarioBO();
		Usuario usuario = null;
		String msg = "Você ainda não possui nenhum veiculo, clique em 'Novo Veiculo' "
				+ " para cadastrar seu 1º veiculo!";
		
		String id = request.getParameter("id_usuario");
		String idVeiculo = request.getParameter("id_veiculo");
		
		HttpSession session = request.getSession();
		
		Object email = session.getAttribute("usuarioLogado");
		
		usuario = usuarioBO.localizarIdUsuario(Integer.parseInt(id));
		
		List<Usuario> verifica = usuarioBO.verificarUsuarioSessao(Integer.parseInt(id), String.valueOf(email));
		
		if(verifica.isEmpty()){
			proximo = "erro404.jsp";
		}else{
		
		List<Veiculo> listarVeiculo = veiculoBO.listarMeusVeiculos(Integer.parseInt(id));

		if(id != null){
			
			if(listarVeiculo.isEmpty() || listarVeiculo == null){
				request.setAttribute("listaVazia", msg);

			}else{
				request.setAttribute("listarMyVeiculo", listarVeiculo);
			}			
		}else if(idVeiculo != null || idVeiculo != ""){
			veiculoBO = new VeiculoBO();
			Veiculo veiculo = null;
			
			veiculo = veiculoBO.listarVeiculoID(Integer.parseInt(idVeiculo));
	
			
			
			veiculoBO.deletarVeiculo(veiculo);

			}
		}
		
		return proximo;
	}

}
