package bo;

import java.util.List;

import dao.AnuncioDAO;
import dao.VeiculoDAO;
import modelo.Anuncio;
import modelo.Veiculo;

public class AnuncioBO {
	
	private AnuncioDAO anuncioDAO;
	
	public AnuncioBO(){
		anuncioDAO = new AnuncioDAO();
	}
	
	/*Metodo responsavel por carregar os veiculos do usuario no select*/
	public List<Veiculo> listarSelectVeiculoFretado(int id){
		
		List<Veiculo> listar = null;
		
		try{
			listar = anuncioDAO.listarMeusVeiculosFretado(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Metodo responsavel por carregar os veiculos do usuario no select*/
	public List<Veiculo> listarSelectVeiculoFrete(int id){
		
		List<Veiculo> listar = null;
		
		try{
			listar = anuncioDAO.listarMeusVeiculosFrete(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Metodo responsavel por persistir os dados no banco - ANUNCIO ESCOLAR*/
	public boolean salvarAnuncioEscolar(Anuncio anuncio){
		return anuncioDAO.persist(anuncio);
	}
	
	public Veiculo localizarVeiculoId(int id){
		
		return anuncioDAO.consultarPorId(id);
	}

	public List<Veiculo> listarMyVeiculos(int id){
		
		List<Veiculo> listar = null;
		
		try{
			listar = anuncioDAO.listarMeusVeiculos2(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	public List<Anuncio> listarAnunciodoUser(int idVeiculo){
		
		return anuncioDAO.listarAnunciodoUser(idVeiculo);	
	}
}
