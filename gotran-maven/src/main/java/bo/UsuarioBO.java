package bo;

import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioBO {
	
	private UsuarioDAO<Usuario> usuarioDAO;
	
	public UsuarioBO(){
		usuarioDAO = new UsuarioDAO<Usuario>();
	}
	
	/*Metodo responsavel por persistir os dados do usuario no banco*/
	public boolean inserirUsuario(Usuario usuario){
			return usuarioDAO.persist(usuario);
		
	}
	
	/*Metodo responsavel por persistiratualizar os dados do usuario no banco*/
	public boolean atualizarUsuario(Usuario usuario){
			return usuarioDAO.update(usuario);
		
	}
	
	/*Metodo responsavel por efetuar o login*/
	public boolean login(String email, String senha){
		return usuarioDAO.login(email, senha);
	}
	
	/*Metodo responsavel por localizar um email no banco*/
	public boolean localizarPorEmail(String email){
		boolean isValido = false;
		
		try{
			if(usuarioDAO.localizarPorEmail(email)!=null){
				isValido = true;
			}
		}catch(Exception e){
			e.getMessage();
		}
		
		return isValido;
	}
	
	/*Metodo responsavel por localizar id no banco*/
	public Usuario localizarIdUsuario(int id){
		return usuarioDAO.consultarPorId(id);
	}
	
	/*Metodo responsavel por localizar uma senha no banco*/
	public boolean localizarSenha(String senha){
		boolean isValido = false;
		
		try{
			if(usuarioDAO.localizarSenha(senha)!=null){
				isValido = true;
			}
		}catch(Exception e){
			e.getMessage();
		}
		
		return isValido;
	}
	
	/*Verifica usuario sessao*/
	public List<Usuario> verificarUsuarioSessao(int id, String email){
		
		List<Usuario> listar = null;
		
		try{
			listar = usuarioDAO.verificaUsuarioSessao(id, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica usuario facebook*/
	public List<Usuario> verificarUsuarioFace(long idUsuario){
		
		List<Usuario> listar = null;
		
		try{
			listar = usuarioDAO.verificarUsuarioFace(idUsuario);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica usuario google*/
	public List<Usuario> verificarUsuarioGoogle(String idUsuario, String email){
		
		List<Usuario> listar = null;
		
		try{
			listar = usuarioDAO.verificarUsuarioGoogle(idUsuario, email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	/*Verifica se existe email*/
	public List<Usuario> verificaEmail(String email){
		
		List<Usuario> listar = null;
		
		try{
			listar = usuarioDAO.verificarEmail(email);
		}catch(Exception e){
			e.getMessage();
		}
		return listar;
	}
	
	public Usuario localizarUserporEmail(String email){
		return usuarioDAO.localizarPorEmail(email);
	}
	
	/*verifica senha e email*/
	
	public List<Usuario> verificarEmaileCodigo(String email, String codigo){
		return usuarioDAO.verificarEmaileCodigo(email, codigo);
	}
	

}
