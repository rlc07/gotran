package command;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioAluguelBO;
import bo.AnuncioBO;
import dao.AnuncioDAO;
import modelo.AnuncioAluguel;
import modelo.Veiculo;

public class CadastrarAnAluguelCMD implements Command, Serializable{


	private static final long serialVersionUID = 1L;

	private String proximo ="";
	private AnuncioAluguelBO anAluguelBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		anAluguelBO = new AnuncioAluguelBO();
		proximo = "privado/anunciante/anunciar_aluguel.jsp";
		
		/*Recuperar valores*/
		String veiculo = request.getParameter("veiculo");
		String titulo = request.getParameter("titulo");
		String valor = request.getParameter("valor");
		String rua = request.getParameter("rua");
		String n = request.getParameter("n");
		String cidade = request.getParameter("cidade");
		String desc = request.getParameter("desc_anuncio");
		String status = request.getParameter("status");
		String bairro = request.getParameter("bairro");
		String idAnuncio = request.getParameter("id_anuncio");
		
		if(idAnuncio == null || idAnuncio == ""){
			
			/*Seta valores*/
			AnuncioAluguel anAluguel = new AnuncioAluguel();
			anAluguel.setNome_empresa(titulo);
			
			if(valor == null || valor == ""){
				valor = "0.00";
				anAluguel.setValor(Double.parseDouble(valor));
			}else{
				anAluguel.setValor(Double.parseDouble(valor));
			}
			
			if(n == null || n == ""){
				n = "0";
				anAluguel.setNumero(Integer.parseInt(n));
			}else{
				anAluguel.setNumero(Integer.parseInt(n));
			}
			
			anAluguel.setRua(rua);
			anAluguel.setCidade(cidade);
			anAluguel.setDesc_anuncio(desc);
			
			 /*data atual*/
			
			Date d = new Date();
	  	   Calendar calendarAtual = Calendar.getInstance();
	  	   calendarAtual.setTime(d);

	  	   calendarAtual.set(Calendar.DAY_OF_MONTH, calendarAtual.get(Calendar.DAY_OF_MONTH));
	  	   calendarAtual.set(Calendar.MONTH, calendarAtual .get(Calendar.MONTH));
	  	   calendarAtual.set(Calendar.YEAR, calendarAtual .get(Calendar.YEAR));
	        anAluguel.setData_cadastro(new SimpleDateFormat("dd/MM/yyyy").format(calendarAtual.getTime()));
	  	   
	        /*data atual + 30 dias*/

	  	   Calendar calendarExpira  = Calendar.getInstance();
	  	   calendarExpira.setTime(d);

	  	   calendarExpira.set(Calendar.DAY_OF_MONTH, calendarExpira.get(Calendar.DAY_OF_MONTH)+30);
	  	   calendarExpira.set(Calendar.MONTH, calendarExpira.get(Calendar.MONTH));
	  	   calendarExpira.set(Calendar.YEAR, calendarExpira.get(Calendar.YEAR));
	  	   anAluguel.setData_expira(new SimpleDateFormat("dd/MM/yyyy").format(calendarExpira.getTime()));
	         
			
			/*Recupera veiculo id*/
			Veiculo vec = new Veiculo();
			AnuncioDAO anuncioDAO = new AnuncioDAO();
			
			if(anuncioDAO.consultarPorId(Integer.parseInt(veiculo))!=null){
				vec = anuncioDAO.consultarPorId(Integer.parseInt(veiculo));
				anAluguel.setVeiculo(vec);
			}
			
			anAluguel.setStatus(true);
			
			anAluguelBO.cadastrarAnuncio(anAluguel);
			
		}if(idAnuncio != null){
			
			AnuncioAluguel anAluguel = null;
			
			anAluguel = anAluguelBO.listarMyAluguelId(Integer.parseInt(idAnuncio));
            anAluguel.setNome_empresa(titulo);
			
			if(valor == null || valor == ""){
				valor = "0.00";
				anAluguel.setValor(Double.parseDouble(valor));
			}else{
				anAluguel.setValor(Double.parseDouble(valor));
			}
			
			if(n == null || n == ""){
				n = "0";
				anAluguel.setNumero(Integer.parseInt(n));
			}else{
				anAluguel.setNumero(Integer.parseInt(n));
			}
			
			anAluguel.setRua(rua);
			anAluguel.setCidade(cidade);
			anAluguel.setDesc_anuncio(desc);
			anAluguel.setBairro(bairro);

			/*Recupera veiculo id*/
			Veiculo vec = new Veiculo();
			AnuncioDAO anuncioDAO = new AnuncioDAO();
			
			if(anuncioDAO.consultarPorId(Integer.parseInt(veiculo))!=null){
				vec = anuncioDAO.consultarPorId(Integer.parseInt(veiculo));
				anAluguel.setVeiculo(vec);
			}
			
			if(status == null){
				anAluguel.setStatus(false);
			}else if(status.equals("on")){
				anAluguel.setStatus(true);
			}
			
			anAluguel.setData_cadastro(anAluguel.getData_cadastro());
			anAluguel.setData_expira(anAluguel.getData_expira());
			
			anAluguelBO.update(anAluguel);
			
		}
		
		
		
		return proximo;
	}

}
