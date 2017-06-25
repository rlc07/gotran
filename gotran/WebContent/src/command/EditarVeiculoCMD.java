package command;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.VeiculoBO;
import modelo.Veiculo;

public class EditarVeiculoCMD implements Serializable, Command {

	
	private static final long serialVersionUID = 1L;

	private VeiculoBO veiculoBO;
	private String proximo = "";
	
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
         
		veiculoBO = new VeiculoBO();
		Veiculo veiculo = null;
		proximo = "privado/anunciante/editar_veiculo.jsp";
		
		String idVeiculo = request.getParameter("id_veiculo");
		
		HttpSession sessao = request.getSession();
		Object email = sessao.getAttribute("usuarioLogado");
		
        List<Veiculo> list = veiculoBO.VerificarVeiculoID(Integer.parseInt(idVeiculo), String.valueOf(email));
        
        if(list.isEmpty()){
        	proximo= "erro404.jsp";
        }else{
        	veiculo = veiculoBO.listarVeiculoID(Integer.parseInt(idVeiculo));
    		request.setAttribute("veiculo", veiculo);
        }
		
		
		
		
		return proximo;
	}

}
