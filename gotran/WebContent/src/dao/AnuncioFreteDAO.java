package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import jpa.EntityManagerUtil;
import modelo.AnuncioEscolar;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class AnuncioFreteDAO extends GenericoDAO<AnuncioFrete> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public AnuncioFreteDAO(){
		super.setClasse(AnuncioFrete.class);
		em = EntityManagerUtil.getEntityManager();
		super.setEm(EntityManagerUtil.getEntityManager());
	}
	
	/*Listar veiculo*/
	public List<Veiculo> listarVeiculo(int id){
		return em.createQuery("from Veiculo where tipo_veiculo = 'frete' and USUARIO = "+id).getResultList();
	}

	/*Listar todos meus anuncios*/
	@SuppressWarnings("unchecked")
	public List<AnuncioFrete> listarMyAnFrete(int id){
		return em.createQuery("select distinct frete from AnuncioFrete frete inner join frete.veiculo veiculo where veiculo.usuario="+id+" ORDER BY data_cadastro DESC").getResultList();
	}
	
	/*Listar anúncio por id*/
    public AnuncioFrete listarFreteId(int id){
		
		return em.find(AnuncioFrete.class, id);
	}
	
    /*Listar Anúncio de frete por cidade*/
    public List<AnuncioFrete> listarFreteCidade(String cidade){
    	
    	String sql = "SELECT DISTINCT frete FROM AnuncioFrete frete WHERE frete.status= 1 AND frete.cidade LIKE '%"+cidade+"%'";
    	
    	return em.createQuery(sql).getResultList();
    }
    
    /*Listar Anúncio de frete por filtro*/
    public List<AnuncioFrete> listarFreteFiltro(String condicao){
    	
    	String sql = "SELECT DISTINCT frete FROM AnuncioFrete frete WHERE frete.status= 1 AND "+condicao+"";
    	
    	return em.createQuery(sql).getResultList();
    }
    
	/*Listar anuncio id*/
	@SuppressWarnings("unchecked")
	public List<AnuncioFrete> listarFrId(int id, String email){
		String sql = "SELECT distinct frete FROM AnuncioFrete frete inner join frete.veiculo veiculo where frete.id_anuncio ="+id
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
