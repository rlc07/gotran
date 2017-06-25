package command;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioExcursaoBO;
import dao.AnuncioDAO;
import modelo.AnuncioExcursao;
import modelo.Veiculo;

public class CadastrarAnExcursaoCMD implements Command, Serializable {

	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioExcursaoBO anExcursaoBO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "privado/anunciante/anunciar_excursao.jsp";
		anExcursaoBO = new AnuncioExcursaoBO();
		
		/*Reupera valor*/
		String veiculo = request.getParameter("veiculo");
		String titulo = request.getParameter("titulo");
		String rua = request.getParameter("rua");
		String destino = request.getParameter("destino_excursao");
		String bairro = request.getParameter("bairro");
		String dt_partida = request.getParameter("dt_partida");
		String cidade = request.getParameter("cidade");
		String n = request.getParameter("n");
		String dt_retorno = request.getParameter("dt_retorno");
		String desc_an = request.getParameter("desc_anuncio");
		String valor = request.getParameter("valor");
		String status = request.getParameter("status");
		String idAnuncio = request.getParameter("id_anuncio");
		
		if(idAnuncio == null || idAnuncio == ""){
			/*Setar valores*/
			
			AnuncioExcursao anExcursao = new AnuncioExcursao();
			anExcursao.setNome_empresa(titulo);
			anExcursao.setRua(rua);
			anExcursao.setDestino(destino);
			anExcursao.setBairro(bairro);
			anExcursao.setData_excursao(dt_partida);
			anExcursao.setCidade(cidade);
			
			if(n == null || n == ""){
				n = "0";
				anExcursao.setNumero(Integer.parseInt(n));
			}else{
				anExcursao.setNumero(Integer.parseInt(n));
			}
			anExcursao.setData_retorno(dt_retorno);
			anExcursao.setDesc_anuncio(desc_an);
			
			if(valor == null || valor == ""){
				valor = "0.0";
				anExcursao.setValor(Double.parseDouble(valor));
			}else{
				anExcursao.setValor(Double.parseDouble(valor));
			}
			
			/*Recupera veiculo*/
			AnuncioDAO anuncioDAO = new AnuncioDAO();
			Veiculo vec = new Veiculo();
			
			if(anuncioDAO.consultarPorId(Integer.parseInt(veiculo))!=null){
				vec = anuncioDAO.consultarPorId(Integer.parseInt(veiculo));
				anExcursao.setVeiculo(vec);
			}
			
			/*data atual*/
			Date d = new Date();
	  	   Calendar calendarAtual = Calendar.getInstance();
	  	   calendarAtual .setTime(d);

	  	   calendarAtual.set(Calendar.DAY_OF_MONTH, calendarAtual.get(Calendar.DAY_OF_MONTH));
	  	   calendarAtual.set(Calendar.MONTH, calendarAtual .get(Calendar.MONTH));
	  	   calendarAtual.set(Calendar.YEAR, calendarAtual .get(Calendar.YEAR));
	        anExcursao.setData_cadastro(new SimpleDateFormat("dd/MM/yyyy").format(calendarAtual.getTime()));
	  	   
	        /*data atual + 30 dias*/

	  	   Calendar calendarExpira  = Calendar.getInstance();
	  	   calendarExpira.setTime(d);

	  	   calendarExpira.set(Calendar.DAY_OF_MONTH, calendarExpira.get(Calendar.DAY_OF_MONTH)+30);
	  	   calendarExpira.set(Calendar.MONTH, calendarExpira.get(Calendar.MONTH));
	  	   calendarExpira.set(Calendar.YEAR, calendarExpira.get(Calendar.YEAR));
	  	 anExcursao.setData_expira(new SimpleDateFormat("dd/MM/yyyy").format(calendarExpira.getTime()));
			
			anExcursao.setStatus(true);
			anExcursaoBO.cadastrarAnuncio(anExcursao);
			
		}else if(idAnuncio != null){
			
			AnuncioExcursao anExcursao = null;
			anExcursao = anExcursaoBO.listarMyExcursaoId(Integer.parseInt(idAnuncio));
			
			anExcursao.setNome_empresa(titulo);
			anExcursao.setRua(rua);
			anExcursao.setDestino(destino);
			anExcursao.setBairro(bairro);
			anExcursao.setCidade(cidade);
			
			if(n == null || n == ""){
				n = "0";
				anExcursao.setNumero(Integer.parseInt(n));
			}else{
				anExcursao.setNumero(Integer.parseInt(n));
			}
			
			
				anExcursao.setData_retorno(dt_retorno);
			   anExcursao.setData_excursao(dt_partida);
			
			anExcursao.setDesc_anuncio(desc_an);
			
			if(valor == null || valor == ""){
				valor = "0.0";
				anExcursao.setValor(Double.parseDouble(valor));
			}else{
				anExcursao.setValor(Double.parseDouble(valor));
			}
			
			/*Recupera veiculo*/
			AnuncioDAO anuncioDAO = new AnuncioDAO();
			Veiculo vec = new Veiculo();
			
			if(anuncioDAO.consultarPorId(Integer.parseInt(veiculo))!=null){
				vec = anuncioDAO.consultarPorId(Integer.parseInt(veiculo));
				anExcursao.setVeiculo(vec);
			}
			
			if(status == null){
				anExcursao.setStatus(false);
			}else if (status.equals("on")){
				anExcursao.setStatus(true);
			}
			
			anExcursao.setData_cadastro(anExcursao.getData_cadastro());
			anExcursao.setData_expira(anExcursao.getData_expira());
			
			anExcursaoBO.update(anExcursao);
		}
		
		
		
		return proximo;
	}

	
}
