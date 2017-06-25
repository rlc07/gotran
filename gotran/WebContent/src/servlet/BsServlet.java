package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import command.AtualizarUsuarioCMD;
import command.CadastrarAnAluguelCMD;
import command.CadastrarAnEscolarCMD;
import command.CadastrarAnExcursaoCMD;
import command.CadastrarAnFreteCMD;
import command.CadastroVeiculoCMD;
import command.Command;
import command.DeletarAnAluguelCMD;
import command.DeletarAnEscolarCMD;
import command.DeletarAnExcursaoCMD;
import command.DeletarAnFreteCMD;
import command.DeletarVeiculoCMD;
import command.EditarAnAluguelCMD;
import command.EditarAnExcursaoCMD;
import command.EditarAnFreteCMD;
import command.EditarAnuncioEscolarCMD;
import command.EditarVeiculoCMD;
import command.ListarAnAluguelBuscadorCMD;
import command.ListarAnEscolarBuscador;
import command.ListarAnExcursaoBuscador;
import command.ListarAnFreteBuscador;
import command.ListarMeusAnunciosCMD;
import command.ListarVeiculoEscolar;
import command.ListarVeiculoExcursaoCMD;
import command.ListarVeiculoFrete;
import command.LoginGoogleCMD;
import command.NovaSenhaCDM;
import command.RecuperarContaCMD;
import command.ListarMyVeiculoCMD;
import command.ListarVeiculoAluguelCMD;
import command.UsuarioCMD;
import command.UsuarioFacebookCMD;
import command.VizualizarAnAluguelCMD;
import command.VizualizarAnEscolarCMD;
import command.VizualizarAnExcursaoCMD;
import command.VizualizarAnFreteCMD;

@WebServlet("/buscar")
public class BsServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	Map<String, Command> comandos = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		
		/*Cadastrar usuario*/
		comandos.put("cadastrar-usuario", new UsuarioCMD());
		comandos.put("efetuarLoginFacebook", new UsuarioFacebookCMD());
		comandos.put("recuperar-senha", new RecuperarContaCMD());
		comandos.put("nova-senha", new NovaSenhaCDM());




		/*Anuncio Escolar*/
		comandos.put("buscar-anuncio-escolar", new ListarAnEscolarBuscador());
		comandos.put("buscar-anuncio-frete", new ListarAnFreteBuscador());
		comandos.put("buscar-anuncio-excursao", new ListarAnExcursaoBuscador());
		comandos.put("buscar-anuncio-aluguel", new ListarAnAluguelBuscadorCMD());



		comandos.put("vizualizar-anuncio-escolar", new VizualizarAnEscolarCMD());
		comandos.put("vizualizar-anuncio-frete", new VizualizarAnFreteCMD());
		comandos.put("vizualizar-anuncio-excursao", new VizualizarAnExcursaoCMD());
		comandos.put("vizualizar-anuncio-aluguel", new VizualizarAnAluguelCMD());
		
		/*Login Social*/
		comandos.put("login-google", new LoginGoogleCMD());










	}
	
	private String proximo = "";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Command comando = null;
		String acao = request.getParameter("action");
		
		comando = verificaComando(acao);
		proximo = comando.execute(request,response);
		
		request.getRequestDispatcher(proximo).forward(request, response);
	}
	
	
	
	public Command verificaComando(String acao){
		Command comando = null;
		
		for(String key : comandos.keySet()){
			if(key.equalsIgnoreCase(acao)){
				comando = comandos.get(key);
			}
		}
		return comando;
		
	}
	
	
	

}
