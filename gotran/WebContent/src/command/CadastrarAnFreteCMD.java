package command;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioFreteBO;
import dao.AnuncioDAO;
import modelo.Anuncio;
import modelo.AnuncioFrete;
import modelo.Veiculo;

public class CadastrarAnFreteCMD implements Serializable, Command{

	
	private static final long serialVersionUID = 1L;
	private String proximo ="";
	private AnuncioFreteBO anFreteBO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "privado/anunciante/anunciar_carreto.jsp";
		anFreteBO = new AnuncioFreteBO();
		
		/*Recuperar valores*/
		String veiculo = request.getParameter("veiculo");
		String titulo = request.getParameter("titulo_frete");
		String tipo_carga = request.getParameter("tipo");
		String carga = request.getParameter("carga");
		String valor = request.getParameter("valor");
		String disp_vg = request.getParameter("disp_vg_frete");
		String desc_anuncio = request.getParameter("desc_anuncio");
		String rua = request.getParameter("rua");
		String cidade = request.getParameter("cidade");
		String n = request.getParameter("n");
		String bairro = request.getParameter("bairro");
		String idAnuncio = request.getParameter("id_anuncio");
		String status = request.getParameter("status");
		
		
		if(idAnuncio == null || idAnuncio == ""){
			/*Seta valores*/
			AnuncioFrete anFrete = new AnuncioFrete();
			anFrete.setNome_empresa(titulo);
			anFrete.setTipo_carga(tipo_carga);
			anFrete.setRua(rua);
			anFrete.setCidade(cidade);
			anFrete.setBairro(bairro);
			
			if(n == null || n == ""){
				n = "0";
				anFrete.setNumero(Integer.parseInt(n));
			}else{
				anFrete.setNumero(Integer.parseInt(n));
			}
			
			if(carga == null || carga == ""){
				String cargat = request.getParameter("cargat");
				anFrete.setCarga(Double.parseDouble(cargat));
			}else{
				anFrete.setCarga(Double.parseDouble(carga));

			}
			anFrete.setDisp_viagem(Boolean.parseBoolean(disp_vg));
			anFrete.setDesc_anuncio(desc_anuncio);
			
			if(valor == "" || valor == null){
				valor = "0.00";
			anFrete.setValor(Double.parseDouble(valor));
			}else{
				anFrete.setValor(Double.parseDouble(valor));
			}
			
			 /*data atual*/
			Date d = new Date();
	  	   Calendar calendarAtual = Calendar.getInstance();
	  	   calendarAtual .setTime(d);

	  	   calendarAtual .set(Calendar.DAY_OF_MONTH, calendarAtual.get(Calendar.DAY_OF_MONTH));
	  	   calendarAtual .set(Calendar.MONTH, calendarAtual .get(Calendar.MONTH));
	  	   calendarAtual .set(Calendar.YEAR, calendarAtual .get(Calendar.YEAR));
	        anFrete.setData_cadastro(new SimpleDateFormat("dd/MM/yyyy").format(calendarAtual.getTime()));
	  	   
	        /*data atual + 30 dias*/

	  	   Calendar calendarExpira  = Calendar.getInstance();
	  	   calendarExpira.setTime(d);

	  	   calendarExpira.set(Calendar.DAY_OF_MONTH, calendarExpira.get(Calendar.DAY_OF_MONTH)+30);
	  	   calendarExpira.set(Calendar.MONTH, calendarExpira.get(Calendar.MONTH));
	  	   calendarExpira.set(Calendar.YEAR, calendarExpira.get(Calendar.YEAR));
	  	   anFrete.setData_expira(new SimpleDateFormat("dd/MM/yyyy").format(calendarExpira.getTime()));
	         
			
			/*Pega veiculo*/
			AnuncioDAO anuncioDAO = new AnuncioDAO();
			if(anuncioDAO.consultarPorId(Integer.parseInt(veiculo)) !=null){
				Veiculo vec = new Veiculo();
				vec = anuncioDAO.consultarPorId(Integer.parseInt(veiculo));
				anFrete.setVeiculo(vec);
			}
			
			anFrete.setStatus(true);
			
			
			try{
				anFreteBO.cadastrarAnuncio(anFrete);
			}catch(Exception e){
				e.getMessage();
			}
			
		}else if(idAnuncio!=null){
			
			AnuncioFrete anFrete = null;
			
			anFrete = anFreteBO.listarAnFreteID(Integer.parseInt(idAnuncio));
			
			anFrete.setNome_empresa(titulo);
			anFrete.setTipo_carga(tipo_carga);
			anFrete.setRua(rua);
			anFrete.setCidade(cidade);
			anFrete.setBairro(bairro);
			
			if(n == null || n == ""){
				n = "0";
				anFrete.setNumero(Integer.parseInt(n));
			}else{
				anFrete.setNumero(Integer.parseInt(n));
			}
			
			if(carga == null || carga == ""){
				String cargat = request.getParameter("cargat");
				anFrete.setCarga(Double.parseDouble(cargat));
			}else{
				anFrete.setCarga(Double.parseDouble(carga));

			}
			anFrete.setDisp_viagem(Boolean.parseBoolean(disp_vg));
			anFrete.setDesc_anuncio(desc_anuncio);
			
			if(valor == "" || valor == null){
				valor = "0.00";
			anFrete.setValor(Double.parseDouble(valor));
			}else{
				anFrete.setValor(Double.parseDouble(valor));
			}
		
	        anFrete.setData_cadastro(anFrete.getData_cadastro());
	  	   
	  	   anFrete.setData_expira(anFrete.getData_expira());
	         
			
			/*Pega veiculo*/
			AnuncioDAO anuncioDAO = new AnuncioDAO();
			if(anuncioDAO.consultarPorId(Integer.parseInt(veiculo)) !=null){
				Veiculo vec = new Veiculo();
				vec = anuncioDAO.consultarPorId(Integer.parseInt(veiculo));
				anFrete.setVeiculo(vec);
			}
			
			if(status == null){
				anFrete.setStatus(false);
			}else if (status.equals("on")){
				anFrete.setStatus(true);

			}
			
			
			try{
				anFreteBO.alterarAnuncio(anFrete);
			}catch(Exception e){
				e.getMessage();
			}
			
			
			
		}
		
		
		
		return proximo;
	}

}
