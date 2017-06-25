package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.EntityManagerUtil;
import modelo.AnuncioAluguel;
import modelo.AnuncioEscolar;

public class AnuncioAluguelDAO extends GenericoDAO<AnuncioAluguel>{

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public AnuncioAluguelDAO(){
		super.setClasse(AnuncioAluguel.class);
		em = EntityManagerUtil.getEntityManager();
		super.setEm(EntityManagerUtil.getEntityManager());
	}

	/*Listar todos meus anuncios*/
	@SuppressWarnings("unchecked")
	public List<AnuncioAluguel> listarMyAnAluguel(int id){
		return em.createQuery("select distinct aluguel from AnuncioAluguel aluguel inner join aluguel.veiculo veiculo where veiculo.usuario="+id+" ORDER BY data_cadastro DESC").getResultList();
	}
	
	/*Listar meus anuncio de aluguel por id*/
	public AnuncioAluguel listarMyAluguelId(int id){
		return em.find(AnuncioAluguel.class, id);
	}
	
	/*Listar anúncio de aluguel por cidade*/
	public List<AnuncioAluguel> listarAluguelCidade(String cidade){
		String sql = "SELECT aluguel FROM AnuncioAluguel aluguel WHERE aluguel.status=1 AND aluguel.cidade LIKE '%"+cidade+"%'";
		
		return em.createQuery(sql).getResultList();
	}
	
	/*Listar anuncio id*/
	@SuppressWarnings("unchecked")
	public List<AnuncioAluguel> listarAlId(int id, String email){
		String sql = "SELECT distinct aluguel FROM AnuncioAluguel aluguel inner join aluguel.veiculo veiculo where aluguel.id_anuncio ="+id
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
