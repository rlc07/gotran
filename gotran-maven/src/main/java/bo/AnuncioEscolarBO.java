package bo;

import java.util.List;

import dao.AnuncioDAO;
import dao.AnuncioEscolarDAO;
import modelo.Anuncio;
import modelo.AnuncioEscolar;
import modelo.BairroEscolar;
import modelo.Veiculo;

public class AnuncioEscolarBO {
	
	private AnuncioDAO anuncioDAO;
	private AnuncioEscolarDAO anEscolarDAO;
	
	public AnuncioEscolarBO(){
		anuncioDAO = new AnuncioDAO();
		anEscolarDAO = new AnuncioEscolarDAO();
	}
	
	/*Metodo responsavel por carregar os veiculos do usuario no select*/
	public List<Veiculo> listarSelectVeiculo(int id){
		
		List<Veiculo> listar = null;
		
		try{
			listar = anuncioDAO.listarMeusVeiculosFretado(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Metodo responsavel por persistir os dados no banco - ANUNCIO ESCOLAR*/
	public boolean salvarAnuncioEscolar(AnuncioEscolar anEscolar){
		return anuncioDAO.persist(anEscolar);
	}
	
	/*Metodo responsavel por persistir os dados no banco - ANUNCIO ESCOLAR*/
	public boolean atualizarAnuncioEscolar(AnuncioEscolar anEscolar){
		return anuncioDAO.update(anEscolar);
	}
	
	/*Listar anuncio buscador*/
	public List<AnuncioEscolar> listarAnuncio(int id, String condicao){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.listarAnuncio(id,condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	public List<BairroEscolar> listarLatLon(){
		
		List<BairroEscolar> listar = null;
		
		try{
			listar = anEscolarDAO.listarLatLon();
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anúncio para usuario buscador atravez de filtros*/
	public List<AnuncioEscolar> FiltroCompleto(int id, String instituicao, String cidade, String turno, String condicao){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.filtroCompleto(id, instituicao, cidade, turno, condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anúncio para usuario buscador atravez de filtro de instituicao*/
	public List<AnuncioEscolar> FiltroInstituicao(int id, String instituicao, String condicao){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.filtroInstituicao(id, instituicao, condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anúncio para usuario buscador atravez de filtro de cidade*/
	public List<AnuncioEscolar> FiltroCidade(int id, String cidade, String condicao){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.filtroCidade(id, cidade, condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anúncio para usuario buscador atravez de filtro de turno*/
	public List<AnuncioEscolar> FiltroTurno(int id, String turno, String condicao){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.filtroTurno(id, turno, condicao);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Listar anúncio para usuario buscador atravez de filtro de opcional*/
	public List<AnuncioEscolar> FiltroOpcional(int id,String condicao, String opcional){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.filtroOpcional(id,condicao,opcional);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica anuncio existe*/
	public List<AnuncioEscolar> listarEsId(int id, String email){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.listarEsId(id, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
    
	/*Listar meus anuncio escolar */
	public List<AnuncioEscolar> listarMyAnEscolar(int id){
		List<AnuncioEscolar> listar = null;
		try{
			listar = anEscolarDAO.listarMyAnEscolar(id);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}

	/*Listar anúncio por id*/
    public AnuncioEscolar listarEscolarId(int id){
    	return anEscolarDAO.listarEscolarId(id);
    }
    
    /*Listar anúncio por id*/
    public BairroEscolar listarBairroId(int id){
    	return anEscolarDAO.listarBairroId(id);
    }
    /*Deletar anuncio escolar*/
    public boolean deletarAnuncio(AnuncioEscolar anEscolar){
    	return anEscolarDAO.remove(anEscolar);
    }
    
    /*Atualiza anuncio escolar*/
    public boolean atualizaAnuncio(AnuncioEscolar anEscolar){
    	return anEscolarDAO.update(anEscolar);
    }
}
