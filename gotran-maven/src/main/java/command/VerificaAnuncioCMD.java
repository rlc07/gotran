package command;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioBO;
import bo.UsuarioBO;
import bo.VeiculoBO;
import modelo.Anuncio;
import modelo.Usuario;
import modelo.Veiculo;

public class VerificaAnuncioCMD implements Command, Serializable {

	private String proximo = "";
	private UsuarioBO usuarioBO;
	private VeiculoBO veiculoBO;
	private AnuncioBO anuncioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		usuarioBO = new UsuarioBO();
		anuncioBO = new AnuncioBO();
		veiculoBO = new VeiculoBO();
		Usuario usuario = null;
		int notificacao = 0;
		
		    Date dt = new Date();
		   DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		   String dt_atual = sdf.format(dt);
		   
		usuario = usuarioBO.localizarUserporEmail(email);
		
		List<Veiculo> lista = veiculoBO.listarVeiculoIdUsuario(usuario.getId_usuario());
		
		for(Veiculo v : lista){
			
			int idVeiculo = 0;
			idVeiculo = v.getId_veiculo();
			
			List<Anuncio> lsAnuncio = anuncioBO.listarAnunciodoUser(idVeiculo);
			
			for(Anuncio an : lsAnuncio){
				Date dtpass =null;
				String dt_expira = an.getData_expira();
				try {
					dtpass = sdf.parse(dt_expira);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(dt_expira.equals(dt_atual) || dtpass.before(new Date())){
                  an.setStatus(false);
				}
				
			}
			
		}
		
		
		return proximo;
	}
	
	

}
