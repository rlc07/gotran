package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.EntityManagerUtil;
import modelo.Relatorio;
import modelo.Usuario;

public class RelatorioDAO<T> extends GenericoDAO<T> {

	
	private static final long serialVersionUID = 1L;
	
   private EntityManager em;
	
	public RelatorioDAO(){
		super.setClasse(Relatorio.class);
		em = EntityManagerUtil.getEntityManager();
		super.setEm(EntityManagerUtil.getEntityManager());
	}
	
	public List<Relatorio> relatorioEscolar(){
		String sql = "SELECT DISTINCT relatorio FROM Relatorio relatorio";
		
		return em.createQuery(sql).getResultList();
	}
	
	public Relatorio recuperaporId(int id){
		return em.find(Relatorio.class, id);
	}
		

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
