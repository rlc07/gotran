package command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.VeiculoBO;
import modelo.Veiculo;

public class DeletarVeiculoCMD implements Serializable, Command{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private VeiculoBO veiculoBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
      
		veiculoBO = new VeiculoBO();
		proximo = "privado/anunciante/meus_veiculos.jsp";
		String id = request.getParameter("id_veiculo");
		
		Veiculo veiculo = null;
		
		veiculo = veiculoBO.listarVeiculoID(Integer.parseInt(id));
		
		veiculoBO.deletarVeiculo(veiculo);
		
		
		return proximo;
	}

}
