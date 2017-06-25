package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.EntityManagerUtil;
import modelo.Anuncio;
import modelo.Usuario;
import modelo.Veiculo;

public class AnuncioDAO extends GenericoDAO<Anuncio>{
	
	private static final long serialVersionUID = 1L;
	
	  private EntityManager em;
		
		public AnuncioDAO(){
			super.setClasse(Anuncio.class);
			em = EntityManagerUtil.getEntityManager();
			super.setEm(EntityManagerUtil.getEntityManager());
		}
		
		public List<Veiculo> listarMeusVeiculosFretado(int id){
			return em.createQuery("from Veiculo where tipo_veiculo = 'fretado' and USUARIO = "+id).getResultList();
			
		}
		
		public List<Veiculo> listarMeusVeiculosFrete(int id){
			return em.createQuery("from Veiculo where tipo_veiculo = 'frete' and USUARIO = "+id).getResultList();
			
		}
		public List<Veiculo> listarMeusVeiculos2(int id){
			return em.createQuery("FROM Veiculo WHERE usuario = "+id).getResultList();
			
		}

		public Veiculo consultarPorId(int id) {
		    Veiculo veiculo = null;
		      veiculo = em.find(Veiculo.class, id);		   
		    return veiculo;
		  }
		
		public List<Anuncio> listarAnunciodoUser(int idVeiculo){
			String sql="SELECT DISTINCT anuncio FROM Anuncio anuncio WHERE VEICULO="+idVeiculo;
			
			return em.createQuery(sql).getResultList();
			
		}
		
		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}
		
		

}
