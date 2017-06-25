package bo;

import java.util.List;

import dao.RelatorioDAO;
import modelo.Relatorio;

public class RelatorioBO {
	
	private RelatorioDAO relatorioDAO;
	
	@SuppressWarnings("rawtypes")
	public RelatorioBO(){
		relatorioDAO = new RelatorioDAO();
	}
	
	@SuppressWarnings("unchecked")
	public boolean gravar(Relatorio relatorio){
		return relatorioDAO.persist(relatorio);
	}
	
	@SuppressWarnings("unchecked")
	public boolean atualizar(Relatorio relatorio){
		return relatorioDAO.update(relatorio);
	}
	
	public Relatorio recuperaId(int id){
		return relatorioDAO.recuperaporId(id);
	}
	
	public List<Relatorio> relatorioEscolar(){
		return relatorioDAO.relatorioEscolar();
	}
	
	public boolean remover(Relatorio relatorio){
		return relatorioDAO.remove(relatorio);
	}
	

}
