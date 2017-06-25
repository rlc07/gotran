package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.EntityManagerUtil;
import modelo.AnuncioFrete;
import modelo.Usuario;
import modelo.Veiculo;

public class VeiculoDAO extends GenericoDAO<Veiculo>{
	
	private static final long serialVersionUID = 1L;
	
	  private EntityManager em;
		
		public VeiculoDAO(){
			super.setClasse(Veiculo.class);
			em = EntityManagerUtil.getEntityManager();
			super.setEm(EntityManagerUtil.getEntityManager());
		}
		
		public List<Veiculo> listarMeusVeiculos(int id){
			return em.createQuery("FROM Veiculo WHERE usuario = "+id).getResultList();
			
		}
		
		public List<Veiculo> listarTodosVeiculos(){
			return em.createQuery("FROM Veiculo").getResultList();
			
		}
		

		
		public Veiculo listarVeiculoID(int id){
			
			return em.find(Veiculo.class, id);
		}
		
		public Veiculo localizarVeiculo(String modelo){
			return (Veiculo) em.createQuery("from Veiculo where upper(modelo) = :modelo").
					setParameter("modelo", modelo.toUpperCase()).getSingleResult();
		}
		
		/*Listar anuncio id*/
		@SuppressWarnings("unchecked")
		public List<Veiculo> listarVeiculoId(int id, String email){
			String sql = "SELECT distinct veiculo FROM Veiculo veiculo inner join veiculo.usuario user where veiculo.id_veiculo ="+id
					+" AND user.email = '"+email+"'";
			return em.createQuery(sql).getResultList();
		}
		
		/*Listar veiculo id  usuario*/
		@SuppressWarnings("unchecked")
		public List<Veiculo> listarVeiculoIdUsuario(int idUsuario){
			String sql = "SELECT distinct veiculo FROM Veiculo veiculo WHERE USUARIO ="+idUsuario;
			return em.createQuery(sql).getResultList();
		}
		
		

		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}
		
		

}
