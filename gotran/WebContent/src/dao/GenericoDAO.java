package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;


public class GenericoDAO <T>  implements Serializable{


	private static final long serialVersionUID = -4842923199732544952L;
		
		@SuppressWarnings("rawtypes")
		private Class classe;
		private EntityManager em;
	
		
		private void iniciarTransacao(){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
		}
		
		private void rollbackTransacao(){
			iniciarTransacao();
			em.getTransaction().rollback();
		}
		
		private void commitTransacao(){
			iniciarTransacao();
			em.getTransaction().commit();
		}
		
		public boolean persist(T obj){
			
			try{
				iniciarTransacao();
				em.persist(obj);
				commitTransacao();
				return true;
			}catch(Exception e){
				rollbackTransacao();
				return false;
			}
		}

		public boolean update(T obj){

			try{
				iniciarTransacao();
				em.merge(obj);
				commitTransacao();
				return true;
			}catch(Exception e){
				rollbackTransacao();
				
				return false;
			}
		}
		
	public boolean remove(T obj){
			
			try{
				iniciarTransacao();
				em.remove(obj);
				commitTransacao();
				return true;
			}catch(Exception e){
				rollbackTransacao();

				return false;
			}
		}

	@SuppressWarnings("rawtypes")
	public Class getClasse() {
		return classe;
	}

	@SuppressWarnings("rawtypes")
	public void setClasse(Class classe) {
		this.classe = classe;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

		
}
