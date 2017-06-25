package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.EntityManagerUtil;
import modelo.AnuncioEscolar;
import modelo.AnuncioExcursao;
import modelo.AnuncioFrete;

public class AnuncioExcursaoDAO extends GenericoDAO<AnuncioExcursao>{


	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public AnuncioExcursaoDAO(){
		
		super.setClasse(AnuncioExcursao.class);
		em = EntityManagerUtil.getEntityManager();
		super.setEm(EntityManagerUtil.getEntityManager());
	}
	
	/**/
	
	/*Listar todos meus anuncios*/
	@SuppressWarnings("unchecked")
	public List<AnuncioExcursao> listarMyAnExcursao(int id){
		return em.createQuery("select distinct excursao from AnuncioExcursao excursao inner join excursao.veiculo veiculo where veiculo.usuario="+id+" ORDER BY data_cadastro DESC").getResultList();
	}
	
	/*Listar anuncio por id*/
	public AnuncioExcursao listarMyExcursaoID(int id){
		return em.find(AnuncioExcursao.class, id);
	}
	
	/*Listar anúncio excursao por cidade*/
	public List<AnuncioExcursao> listarExcursaoCidade(String cidade){
		String sql = "SELECT DISTINCT excursao FROM AnuncioExcursao excursao WHERE excursao.status= 1 AND excursao.cidade LIKE '%"+cidade+"%'";
		
		return em.createQuery(sql).getResultList();
	}
	
	/*Listar anúncio excursao por cidade*/
	public List<AnuncioExcursao> listarExcursaoFiltro(String condicao){
		String sql = "SELECT DISTINCT excursao FROM AnuncioExcursao excursao WHERE excursao.status= 1 AND "+condicao;
		
		return em.createQuery(sql).getResultList();
	}
	
	/*Listar anuncio id*/
	@SuppressWarnings("unchecked")
	public List<AnuncioExcursao> listarExId(int id, String email){
		String sql = "SELECT distinct excursao FROM AnuncioExcursao excursao inner join excursao.veiculo veiculo where excursao.id_anuncio ="+id
				+" AND veiculo.usuario.email = '"+email+"'";
		return em.createQuery(sql).getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
