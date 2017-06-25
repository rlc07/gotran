package bo;

import java.io.Serializable;
import java.util.List;

import dao.AnuncioExcursaoDAO;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;

public class AnuncioExcursaoBO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private AnuncioExcursaoDAO anExcursaoDAO;
	
	public AnuncioExcursaoBO(){
		anExcursaoDAO = new AnuncioExcursaoDAO();
	}
	
	/*Salvar*/
	public boolean cadastrarAnuncio(AnuncioExcursao anExcursao){
		return anExcursaoDAO.persist(anExcursao);
	}
	
	/*Listar meus an�ncios de excursao*/
	public List<AnuncioExcursao> listarMyAnExcursao(int id){
		List<AnuncioExcursao> listar = null;
		
		try{
			listar = anExcursaoDAO.listarMyAnExcursao(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anuncio de excursao por id*/
	public AnuncioExcursao listarMyExcursaoId(int id){
		return anExcursaoDAO.listarMyExcursaoID(id);
	}
	
	/*Deletar anuncio*/
	public boolean deletarAnExcursao(AnuncioExcursao anExcursao){
		return anExcursaoDAO.remove(anExcursao);
	}
	
	/*Atualizar anuncio*/
  public boolean update(AnuncioExcursao anExcursao){
	  return anExcursaoDAO.update(anExcursao);
	
   }
  
	/*Listar an�ncio excursao por cidade*/
	public List<AnuncioExcursao> listarExcursaoCidade(String cidade){
		List<AnuncioExcursao> listar = null;
		
		try{
			listar = anExcursaoDAO.listarExcursaoCidade(cidade);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar an�ncio excursao por excursao*/
	public List<AnuncioExcursao> listarExcursaoFiltro(String condicao){
		List<AnuncioExcursao> listar = null;
		
		try{
			listar = anExcursaoDAO.listarExcursaoFiltro(condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica anuncio existe*/
	public List<AnuncioExcursao> listarExId(int id, String email){
		List<AnuncioExcursao> listar = null;
		try{
			listar = anExcursaoDAO.listarExId(id, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}

}
