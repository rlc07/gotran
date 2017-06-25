package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.EntityManagerUtil;
import modelo.Usuario;

public class UsuarioDAO<T> extends GenericoDAO<T> {

	
	private static final long serialVersionUID = 1L;
	
   private EntityManager em;
	
	public UsuarioDAO(){
		super.setClasse(Usuario.class);
		em = EntityManagerUtil.getEntityManager();
		super.setEm(EntityManagerUtil.getEntityManager());
	}
	
	//METODO DE LOGIN	
		public boolean login(String email, String senha){
			
			
			Query query = em.createQuery("FROM Usuario WHERE upper(email) = :email "
					+ "and upper(senha) = :senha");
			
			query.setParameter ("email", email.toUpperCase());
			query.setParameter("senha", senha.toUpperCase());
			
			if(!query.getResultList().isEmpty()){
				return true;
			}else{
				return false;
			}
		}
		
		//VERIFICA SE EXISTE UM EMAIL
		public Usuario localizarPorEmail(String email){
			return (Usuario) em.createQuery("from Usuario where upper(email) = :email").
					setParameter("email", email.toUpperCase()).getSingleResult();
		}
		
		//VERIFICA SE EXISTE UM EMAIL
		public Usuario localizarSenha(String senha){
			return (Usuario) em.createQuery("from Usuario where upper(senha) = :senha").
					setParameter("senha", senha.toUpperCase()).getSingleResult();
		}
		
		//Verificar ID
		public Usuario consultarPorId(int id) {
		    Usuario usuario = null;
		      usuario = em.find(Usuario.class, id);

		   
		    return usuario;
		  }
	
		/*Verifica id usuario sessao*/
		public List<Usuario> verificaUsuarioSessao(int idUsuario, String email){
			String sql = "SELECT distinct user FROM Usuario user WHERE user.id_usuario = "+idUsuario+" "
					+ " AND user.email = '"+email+"'";
			
			return em.createQuery(sql).getResultList();
		}
		/*Verifica id facebook*/
		public List<Usuario> verificarUsuarioFace(long idUsuario){
			
			String sql = "SELECT distinct user FROM Usuario user WHERE user.id_facebook= "+idUsuario+"";
			
			return em.createQuery(sql).getResultList();
		}
		
		
		
		/*Verifica id Google*/
		public List<Usuario> verificarUsuarioGoogle(String idUsuario, String email){
			
			String sql = "SELECT distinct user FROM Usuario user WHERE user.id_google= '"+idUsuario+"'"
					+ " AND user.email = '"+email+"'";
			
			return em.createQuery(sql).getResultList();
		}
		
		/*Verifica se email existe */
		public List<Usuario> verificarEmail(String email){
			
			String sql = "SELECT distinct user FROM Usuario user WHERE user.email = '"+email+"'";
			
			return em.createQuery(sql).getResultList();
		}
		
		/*Verifica se senha existe */
		public List<Usuario> verificarEmaileCodigo(String email, String codigo){
			
			String sql = "SELECT distinct user FROM Usuario user WHERE user.email = '"+email+"' "
					+ " AND user.codigo ='"+codigo+"'";
			
			return em.createQuery(sql).getResultList();
		}
		
	
		

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
