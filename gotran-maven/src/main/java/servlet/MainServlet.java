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
import command.ListarAnEscolarBuscador;
import command.ListarMeusAnunciosCMD;
import command.ListarVeiculoEscolar;
import command.ListarVeiculoExcursaoCMD;
import command.ListarVeiculoFrete;
import command.ListarMyVeiculoCMD;
import command.ListarVeiculoAluguelCMD;
import command.UsuarioCMD;
import command.VerificaAnuncioCMD;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	Map<String, Command> comandos = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		comandos.put("cadastrarUsuario", new UsuarioCMD());
		comandos.put("minha-conta/", new AtualizarUsuarioCMD());
		comandos.put("anuncio-escolar/", new ListarVeiculoEscolar());
		comandos.put("meus-veiculos", new ListarMyVeiculoCMD());
		comandos.put("cadastrar-veiculo", new CadastroVeiculoCMD());
		comandos.put("cadastrarEscolar", new CadastrarAnEscolarCMD());
		comandos.put("editar-veiculo", new EditarVeiculoCMD());
		comandos.put("remover-veiculo", new DeletarVeiculoCMD());
		comandos.put("meus-anuncios", new ListarMeusAnunciosCMD());
		comandos.put("meu-perfil", new ListarMeusAnunciosCMD());
		comandos.put("verificar-anuncio", new VerificaAnuncioCMD());

		

		
		comandos.put("editar_anuncio_escolar", new EditarAnuncioEscolarCMD());
		comandos.put("editar_anuncio_frete", new EditarAnFreteCMD());
		comandos.put("editar_anuncio_excursao", new EditarAnExcursaoCMD());
		comandos.put("editar_anuncio_aluguel", new EditarAnAluguelCMD());

		comandos.put("remover-anuncio-escolar", new DeletarAnEscolarCMD());
		comandos.put("remover-anuncio-frete", new DeletarAnFreteCMD());
		comandos.put("remover-anuncio-excursao", new DeletarAnExcursaoCMD());
		comandos.put("remover-anuncio-aluguel", new DeletarAnAluguelCMD());







		


		
		/*FRETE E CARRETO*/
		comandos.put("anuncio-frete_carreto/", new ListarVeiculoFrete());
		comandos.put("cadastrarAnFrete", new CadastrarAnFreteCMD());
		
		/*EXCURSAO*/
		comandos.put("anuncio-excursao/", new ListarVeiculoExcursaoCMD());
		comandos.put("cadastrarAnExcursao", new CadastrarAnExcursaoCMD());

		/*ALUGUEL VEICULO*/
		comandos.put("anuncio-aluguel_veiculo/", new ListarVeiculoAluguelCMD());
		comandos.put("cadastrarAnAluguel", new CadastrarAnAluguelCMD());
		
		/*BUSCADOR*/

		/*Anuncio Escolar*/
		comandos.put("buscar-anuncio-escolar", new ListarAnEscolarBuscador());






	}
	
	private String proximo = "";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Command comando = null;
		String acao = request.getParameter("action");
		
		comando = verificaComando(acao);
		proximo = comando.execute(request, response);
		
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
