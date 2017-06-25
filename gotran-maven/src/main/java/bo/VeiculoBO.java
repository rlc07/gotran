package bo;

import java.util.List;

import dao.VeiculoDAO;
import modelo.Veiculo;

public class VeiculoBO {
	
	private VeiculoDAO veiculoDAO;
	
	public VeiculoBO(){
		veiculoDAO = new VeiculoDAO();
	}
	
	//Metodo responsavel por cadastrar o veiculo
	public boolean salvarVeiculo(Veiculo veiculo){
		return veiculoDAO.persist(veiculo);
		
	}
	
	//Metodo responsavel por Listar os veiculos
	public List<Veiculo> listarMeusVeiculos(int id){
		List<Veiculo> listar = null;
		
		try{
			listar = veiculoDAO.listarMeusVeiculos(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	//Metodo responsavel por Listar todos veiculos
	public List<Veiculo> listarTodosVeiculos(){
		List<Veiculo> listar = null;
		
		try{
			listar = veiculoDAO.listarTodosVeiculos();
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar veiculo por id*/
	public Veiculo listarVeiculoID(int id){
		Veiculo veiculo = null;
		
		try{
			veiculo = veiculoDAO.listarVeiculoID(id);
		}catch(Exception e){
			e.getMessage();
		}
		return veiculo;
	}
	
	/*Listar veiculo por id*/
	public List<Veiculo> VerificarVeiculoID(int id, String email){
		List<Veiculo> listar = null;
		
		try{
			listar = veiculoDAO.listarVeiculoId(id, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Metodo deletar*/
	public boolean deletarVeiculo(Veiculo veiculo){
		return veiculoDAO.remove(veiculo);
	
	}
	
	/*Listar veiculo id  usuario*/
	@SuppressWarnings("unchecked")
	public List<Veiculo> listarVeiculoIdUsuario(int idUsuario){
		
	List<Veiculo> listar = null;
		
		try{
			listar = veiculoDAO.listarVeiculoIdUsuario(idUsuario);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
		
	}

}
