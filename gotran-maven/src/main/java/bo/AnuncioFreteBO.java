package bo;

import java.io.Serializable;
import java.util.List;

import dao.AnuncioFreteDAO;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class AnuncioFreteBO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private AnuncioFreteDAO anFreteDAO;
	
	public AnuncioFreteBO(){
		anFreteDAO = new AnuncioFreteDAO();
	}
	
	/*Listar veiculos*/
	public List<Veiculo> listarMyVeiculo(int id){
		List<Veiculo> listar = null;
		
		try{
			listar = anFreteDAO.listarVeiculo(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	/*Cadastra anuncio*/
	public boolean cadastrarAnuncio(AnuncioFrete anFrete){
		return anFreteDAO.persist(anFrete);
	}
	
	/*Listar veiculos*/
	public List<AnuncioFrete> listarMyAnFrete(int id){
		List<AnuncioFrete> listar = null;
		
		try{
			listar = anFreteDAO.listarMyAnFrete(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	public AnuncioFrete listarAnFreteID(int id){
		AnuncioFrete anFrete = null;
		anFrete= anFreteDAO.listarFreteId(id);
		
		return anFrete;
	}
	
	/*remover anuncio*/
	public boolean deletarAnFrete(AnuncioFrete anFrete){
		return anFreteDAO.remove(anFrete);
	}

	/*atualizar anuncio*/
	public boolean alterarAnuncio(AnuncioFrete anFrete){
		return anFreteDAO.update(anFrete);
	}
	
	/*Listar anúncio de frete por cidade*/
	public List<AnuncioFrete> listarFreteCidade(String cidade){
		List<AnuncioFrete> listar = null;
		
		try{
			listar = anFreteDAO.listarFreteCidade(cidade);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anúncio de frete por cidade*/
	public List<AnuncioFrete> listarFreteFiltro(String condicao){
		List<AnuncioFrete> listar = null;
		
		try{
			listar = anFreteDAO.listarFreteFiltro(condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica anuncio existe*/
	public List<AnuncioFrete> listarFrId(int id, String email){
		List<AnuncioFrete> listar = null;
		try{
			listar = anFreteDAO.listarFrId(id, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
}
