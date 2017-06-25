package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.EntityManagerUtil;
import modelo.Anuncio;
import modelo.AnuncioEscolar;
import modelo.BairroEscolar;
import modelo.Usuario;
import modelo.Veiculo;

public class AnuncioEscolarDAO extends GenericoDAO<AnuncioEscolar>{
	
	private static final long serialVersionUID = 1L;
	
	  private EntityManager em;
		
		public AnuncioEscolarDAO(){
			super.setClasse(AnuncioEscolar.class);
			em = EntityManagerUtil.getEntityManager();
			super.setEm(EntityManagerUtil.getEntityManager());
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> listarAnuncio(int id, String condicao){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p where  p.id_bairroMaps ="+id+condicao+" AND e.status = 1 ORDER BY data_cadastro DESC";
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> filtroTurno(int id, String turno, String condicao){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p where e.status = 1 AND  e.turno = '"+turno+"' AND p.id_bairroMaps ="+id+condicao;
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> filtroCidade(int id, String cidade, String condicao){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p inner join e.instituicao i where e.status = 1 AND i.cidade_instituicao= '"+cidade+"' AND p.id_bairroMaps ="+id+condicao;
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> filtroInstituicao(int id, String instituicao, String condicao){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p inner join e.instituicao i where e.status = 1 AND i.nome_instituicao LIKE '%"+instituicao+"%' AND p.id_bairroMaps ="+id+condicao;
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> filtroCompleto(int id, String instituicao, String cidade, String turno, String condicao){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p inner join e.instituicao i where e.status = 1 AND  i.nome_instituicao = '"+instituicao+"' AND i.cidade_instituicao = '"+cidade+"' "
					+ "AND e.turno = '"+turno+"' AND p.id_bairroMaps ="+id+condicao;
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> filtroOpcional(int id, String condicao, String opcional){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p inner join e.instituicao i where "+opcional+" AND p.id_bairroMaps ="+id+condicao;
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> listarAnuncioFiltro2(int id, String turno, String cidade, String condicao){
			String sql = "select distinct e from AnuncioEscolar e inner join e.bairroEscolar p inner join e.instituicao i where e.turno = '"+turno+"' and i.cidade_instituicao = '"+cidade+"'"
					+ " AND p.id_bairroMaps ="+id+condicao;
			return em.createQuery(sql).getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> listarTodos(){
			String sql = "from AnuncioEscolar";
			return em.createQuery(sql).getResultList();
		}
		
		
		@SuppressWarnings("unchecked")
		public List<BairroEscolar> listarLatLon(){
			return em.createQuery("FROM BairroEscolar").getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<BairroEscolar> listarLatLon2(int id, String condicao){
			
			String sql = "FROM BairroEscolar where id_bairroMaps = "+id+condicao;
				
			
			return em.createQuery(sql).getResultList();
		}
		
		/*Listar todos meus anuncios*/
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> listarMyAnEscolar(int id){
			return em.createQuery("select distinct escolar from AnuncioEscolar escolar inner join escolar.veiculo veiculo where veiculo.usuario="+id+" ORDER BY data_cadastro DESC").getResultList();
		}
		/*Listar anuncio id*/
		@SuppressWarnings("unchecked")
		public List<AnuncioEscolar> listarEsId(int id, String email){
			String sql = "SELECT distinct escolar FROM AnuncioEscolar escolar inner join escolar.veiculo veiculo where escolar.id_anuncio ="+id
					+" AND veiculo.usuario.email = '"+email+"'";
			return em.createQuery(sql).getResultList();
		}
		
		/*Listar anúncio por id*/
           public AnuncioEscolar listarEscolarId(int id){
			
			return em.find(AnuncioEscolar.class, id);
		}
           
       	/*Listar bairro por id*/
           public BairroEscolar listarBairroId(int id){
			
			return em.find(BairroEscolar.class, id);
		}

		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}
		
		

}
