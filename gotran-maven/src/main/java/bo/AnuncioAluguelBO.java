package bo;

import java.io.Serializable;
import java.util.List;

import dao.AnuncioAluguelDAO;
import modelo.AnuncioAluguel;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;

public class AnuncioAluguelBO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private AnuncioAluguelDAO anAluguelDAO;
	
	public AnuncioAluguelBO(){
		anAluguelDAO = new AnuncioAluguelDAO();
	}
	
	/*Cadastrar anuncio*/
	public boolean cadastrarAnuncio(AnuncioAluguel anAluguel){
		return anAluguelDAO.persist(anAluguel);
	}
	
	/*listar meus veiculos de aluguel de vans*/
	public List<AnuncioAluguel> listarMyAnAluguel(int id){
		List<AnuncioAluguel> listar = null;
		
		try{
			listar = anAluguelDAO.listarMyAnAluguel(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}

	/*Listar meus anúncios de aluguel por id*/
	public AnuncioAluguel listarMyAluguelId(int idAnuncio){
		return anAluguelDAO.listarMyAluguelId(idAnuncio);
	}
	
	/*Deletar anuncio*/
	public boolean deletarAnAluguel(AnuncioAluguel anAluguel){
		return anAluguelDAO.remove(anAluguel);
	}
	
	/*atualizar anúncio*/
	public boolean update(AnuncioAluguel anAluguel){
		return anAluguelDAO.update(anAluguel);
	}
	
	/*listar meus veiculos de aluguel de vans*/
	public List<AnuncioAluguel> listarAluguelCidade(String cidade){
		List<AnuncioAluguel> listar = null;
		
		try{
			listar = anAluguelDAO.listarAluguelCidade(cidade);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica anuncio existe*/
	public List<AnuncioAluguel> listarAlId(int id, String email){
		List<AnuncioAluguel> listar = null;
		try{
			listar = anAluguelDAO.listarAlId(id, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
}
