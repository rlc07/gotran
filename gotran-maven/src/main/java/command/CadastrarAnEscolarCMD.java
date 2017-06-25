package command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.DATA_CONVERSION;

import bo.AnuncioBO;
import bo.AnuncioEscolarBO;
import bo.RelatorioBO;
import dao.AnuncioEscolarDAO;
import modelo.AnuncioEscolar;
import modelo.BairroEscolar;
import modelo.Instituicao;
import modelo.Relatorio;
import modelo.Veiculo;
import util.GeoUtils;

public class CadastrarAnEscolarCMD implements Command{

	private AnuncioEscolarBO anEscolarBO;
	private String proximo = "";
	private AnuncioEscolar anuncioEscolar;
	private RelatorioBO relatorioBO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
        proximo = "privado/anunciante/anunciar_escolar.jsp";
        anuncioEscolar = new AnuncioEscolar();
        anEscolarBO = new AnuncioEscolarBO();
        GeoUtils calcular = new GeoUtils();
        relatorioBO = new RelatorioBO();
        
        String condicao = "";
        List<Relatorio> lsRelatorio = relatorioBO.relatorioEscolar();
        
        String idAnuncio = request.getParameter("id_anuncio");
        
        /*Recupera valores anuncio*/
        
        String veiculo = request.getParameter("veiculo");
        String titulo = request.getParameter("titulo");
        String valor = request.getParameter("valor");
        String descricao = request.getParameter("desc_anuncio");
        String status = request.getParameter("status");

        
        /*Recupera anuncio escolar*/
        String turno = request.getParameter("turno_escolar");
        String vaga = request.getParameter("vaga_escolar");
        
        /*Recupera Instituição*/
        
        
        String instituicao1 = request.getParameter("instituicao1");
        String instituicao2 = request.getParameter("instituicao2");
        String instituicao3 = request.getParameter("instituicao3");
        String cidade1 = request.getParameter("cidade1");
        String cidade2 = request.getParameter("cidade2");
        String cidade3 = request.getParameter("cidade3");
        
        /*Recupera bairro*/
        String lat1 = request.getParameter("lat1");
        String long1 = request.getParameter("long1");
        String raio1 = request.getParameter("raio1");
        String mt1 = request.getParameter("mt1");


        String lat2 = request.getParameter("lat2");
        String long2 = request.getParameter("long2");
        String raio2 = request.getParameter("raio2");
        String mt2 = request.getParameter("mt2");

        
        String lat3 = request.getParameter("lat3");
        String long3 = request.getParameter("long3");
        String raio3 = request.getParameter("raio3");
        String mt3 = request.getParameter("mt3");
        
        String lat4 = request.getParameter("lat4");
        String long4 = request.getParameter("long4");
        String raio4 = request.getParameter("raio4");
        String mt4 = request.getParameter("mt4");
        
        String lat5 = request.getParameter("lat5");
        String long5 = request.getParameter("long5");
        String raio5 = request.getParameter("raio5");
        String mt5 = request.getParameter("mt5");
        
        String lat6 = request.getParameter("lat6");
        String long6 = request.getParameter("long6");
        String raio6 = request.getParameter("raio6");
        String mt6 = request.getParameter("mt6");
        
        /*Cadastra*/
        if(idAnuncio == "" || idAnuncio == null ){
        	

            /*Seta os valores instituicao*/

            List<Instituicao> listar = new ArrayList<Instituicao>();

            if(instituicao1 != null && instituicao1 != ""){
            	Instituicao escola = new Instituicao();
                escola.setNome_instituicao(instituicao1);
                escola.setCidade_instituicao(cidade1);
                listar.add(escola);

            }
            if(instituicao2 != null && instituicao2 != ""){
            	Instituicao escola2 = new Instituicao();
                escola2.setNome_instituicao(instituicao2);
                escola2.setCidade_instituicao(cidade2);
                listar.add(escola2);

            }
            if(instituicao3 != null && instituicao3 != ""){
            	Instituicao escola3 = new Instituicao();
                escola3.setNome_instituicao(instituicao3);
                escola3.setCidade_instituicao(cidade3);
                
                listar.add(escola3);
            }
            
           
            List<BairroEscolar> listaBairro = new ArrayList<>();
           
            if(lat1 != null && lat1 != ""){
            	BairroEscolar bairro1 = new BairroEscolar();
                bairro1.setLatitude(lat1);
                bairro1.setLongitude(long1);
                bairro1.setKm(Integer.parseInt(raio1));
                bairro1.setMetro(Integer.parseInt(mt1));
                
                String latitudeRelatorio="";
                String longitudeRelatorio="";
                int idRelatorio = 0;
                
                if(!lsRelatorio.isEmpty()){
                	
                	for(Relatorio rl : lsRelatorio){
                		latitudeRelatorio = rl.getLatitude();
                		longitudeRelatorio = rl.getLongitude();
                		idRelatorio = rl.getId_relatorio(); 
                		
                		double dist = calcular.calculaDistancia(Double.parseDouble(lat1), Double.parseDouble(long1),
                				Double.parseDouble(latitudeRelatorio), Double.parseDouble(longitudeRelatorio));
                		
                		if(dist < 4){
                			Relatorio relatorio = null;
                			
                			relatorio = relatorioBO.recuperaId(idRelatorio);
                			relatorioBO.remover(relatorio);
                		}
                		
                	}
                }
                
                
                listaBairro.add(bairro1);
            }if(lat2 !=null && lat2 != ""){
            	BairroEscolar bairro2 = new BairroEscolar();
                bairro2.setLatitude(lat2);
                bairro2.setLongitude(long2);
                bairro2.setKm(Integer.parseInt(raio2));
                bairro2.setMetro(Integer.parseInt(mt2));
                
                String latitudeRelatorio="";
                String longitudeRelatorio="";
                int idRelatorio = 0;
                
                if(!lsRelatorio.isEmpty()){
                	
                	for(Relatorio rl : lsRelatorio){
                		latitudeRelatorio = rl.getLatitude();
                		longitudeRelatorio = rl.getLongitude();
                		idRelatorio = rl.getId_relatorio(); 
                		
                		double dist = calcular.calculaDistancia(Double.parseDouble(lat1), Double.parseDouble(long1),
                				Double.parseDouble(latitudeRelatorio), Double.parseDouble(longitudeRelatorio));
                		
                		if(dist < 4){
                			Relatorio relatorio = null;
                			
                			relatorio = relatorioBO.recuperaId(idRelatorio);
                			relatorioBO.remover(relatorio);
                		}
                		
                	}
                }
                
                listaBairro.add(bairro2);

            }if(lat3 != null && lat3 != ""){
            	BairroEscolar bairro3 = new BairroEscolar();
                bairro3.setLatitude(lat3);
                bairro3.setLongitude(long3);
                bairro3.setKm(Integer.parseInt(raio3));
                bairro3.setMetro(Integer.parseInt(mt3));
                
                String latitudeRelatorio="";
                String longitudeRelatorio="";
                int idRelatorio = 0;
                
                if(!lsRelatorio.isEmpty()){
                	
                	for(Relatorio rl : lsRelatorio){
                		latitudeRelatorio = rl.getLatitude();
                		longitudeRelatorio = rl.getLongitude();
                		idRelatorio = rl.getId_relatorio(); 
                		
                		double dist = calcular.calculaDistancia(Double.parseDouble(lat1), Double.parseDouble(long1),
                				Double.parseDouble(latitudeRelatorio), Double.parseDouble(longitudeRelatorio));
                		
                		if(dist < 4){
                			Relatorio relatorio = null;
                			
                			relatorio = relatorioBO.recuperaId(idRelatorio);
                			relatorioBO.remover(relatorio);
                		}
                		
                	}
                }
                
                listaBairro.add(bairro3);
            }if(lat4 != null && lat4 != ""){
            	BairroEscolar bairro4 = new BairroEscolar();
                bairro4.setLatitude(lat4);
                bairro4.setLongitude(long4);
                bairro4.setKm(Integer.parseInt(raio4));
                bairro4.setMetro(Integer.parseInt(mt4));
                
                String latitudeRelatorio="";
                String longitudeRelatorio="";
                int idRelatorio = 0;
                
                if(!lsRelatorio.isEmpty()){
                	
                	for(Relatorio rl : lsRelatorio){
                		latitudeRelatorio = rl.getLatitude();
                		longitudeRelatorio = rl.getLongitude();
                		idRelatorio = rl.getId_relatorio(); 
                		
                		double dist = calcular.calculaDistancia(Double.parseDouble(lat1), Double.parseDouble(long1),
                				Double.parseDouble(latitudeRelatorio), Double.parseDouble(longitudeRelatorio));
                		
                		if(dist < 4){
                			Relatorio relatorio = null;
                			
                			relatorio = relatorioBO.recuperaId(idRelatorio);
                			relatorioBO.remover(relatorio);
                		}
                		
                	}
                }
                
                listaBairro.add(bairro4);
            }if(lat5 != null && lat5 != ""){
            	BairroEscolar bairro5 = new BairroEscolar();
                bairro5.setLatitude(lat5);
                bairro5.setLongitude(long5);
                bairro5.setKm(Integer.parseInt(raio5));
                bairro5.setMetro(Integer.parseInt(mt5));
                
                String latitudeRelatorio="";
                String longitudeRelatorio="";
                int idRelatorio = 0;
                
                if(!lsRelatorio.isEmpty()){
                	
                	for(Relatorio rl : lsRelatorio){
                		latitudeRelatorio = rl.getLatitude();
                		longitudeRelatorio = rl.getLongitude();
                		idRelatorio = rl.getId_relatorio(); 
                		
                		double dist = calcular.calculaDistancia(Double.parseDouble(lat1), Double.parseDouble(long1),
                				Double.parseDouble(latitudeRelatorio), Double.parseDouble(longitudeRelatorio));
                		
                		if(dist < 4){
                			Relatorio relatorio = null;
                			
                			relatorio = relatorioBO.recuperaId(idRelatorio);
                			relatorioBO.remover(relatorio);
                		}
                		
                	}
                }
                
                listaBairro.add(bairro5);
            }if(lat6 != null && lat6 != ""){
            	BairroEscolar bairro6 = new BairroEscolar();
                bairro6.setLatitude(lat6);
                bairro6.setLongitude(long6);
                bairro6.setKm(Integer.parseInt(raio6));
                bairro6.setMetro(Integer.parseInt(mt6));
                
                String latitudeRelatorio="";
                String longitudeRelatorio="";
                int idRelatorio = 0;
                
                if(!lsRelatorio.isEmpty()){
                	
                	for(Relatorio rl : lsRelatorio){
                		latitudeRelatorio = rl.getLatitude();
                		longitudeRelatorio = rl.getLongitude();
                		idRelatorio = rl.getId_relatorio(); 
                		
                		double dist = calcular.calculaDistancia(Double.parseDouble(lat1), Double.parseDouble(long1),
                				Double.parseDouble(latitudeRelatorio), Double.parseDouble(longitudeRelatorio));
                		
                		if(dist < 4){
                			Relatorio relatorio = null;
                			
                			relatorio = relatorioBO.recuperaId(idRelatorio);
                			relatorioBO.remover(relatorio);
                		}
                		
                	}
                }
                
                listaBairro.add(bairro6);
            }
            /*Seta valores anuncio*/
            
            anuncioEscolar.setNome_empresa(titulo);
            
            if(valor == null || valor == ""){
            	valor = "0.00";
                anuncioEscolar.setValor(Double.parseDouble(valor));
            }else{
                anuncioEscolar.setValor(Double.parseDouble(valor));
            }
            
            anuncioEscolar.setTurno(turno);
            anuncioEscolar.setVaga_disp(Integer.parseInt(vaga));
            
            Date d = new Date();

            /*data atual*/
     	   Calendar calendarAtual = Calendar.getInstance();
     	   calendarAtual .setTime(d);

     	   calendarAtual .set(Calendar.DAY_OF_MONTH, calendarAtual.get(Calendar.DAY_OF_MONTH));
     	   calendarAtual .set(Calendar.MONTH, calendarAtual .get(Calendar.MONTH));
     	   calendarAtual .set(Calendar.YEAR, calendarAtual .get(Calendar.YEAR));
           anuncioEscolar.setData_cadastro(new SimpleDateFormat("dd/MM/yyyy").format(calendarAtual.getTime()));
     	   
           /*data atual + 30 dias*/

     	   Calendar calendarExpira  = Calendar.getInstance();
     	   calendarExpira.setTime(d);

     	   calendarExpira.set(Calendar.DAY_OF_MONTH, calendarExpira.get(Calendar.DAY_OF_MONTH)+30);
     	   calendarExpira.set(Calendar.MONTH, calendarExpira.get(Calendar.MONTH));
     	   calendarExpira.set(Calendar.YEAR, calendarExpira.get(Calendar.YEAR));
     	   anuncioEscolar.setData_expira(new SimpleDateFormat("dd/MM/yyyy").format(calendarExpira.getTime()));
            
            /*Pega o id do veiculo*/
            AnuncioBO anuncioBO = new AnuncioBO();
            Veiculo vec = new Veiculo();

            if(anuncioBO.localizarVeiculoId(Integer.parseInt(veiculo)) !=null){
                vec = anuncioBO.localizarVeiculoId(Integer.parseInt(veiculo));
                vec.setId_veiculo(Integer.parseInt(veiculo));

            }
            
            anuncioEscolar.setVeiculo(vec);
            anuncioEscolar.setInstituicao(listar);
            anuncioEscolar.setBairroEscolar(listaBairro);
            anuncioEscolar.setStatus(true);
            anuncioEscolar.setDesc_anuncio(descricao);

            
            anEscolarBO.salvarAnuncioEscolar(anuncioEscolar);
        }
        /*Atualiza*/
        else if(idAnuncio != null || idAnuncio != ""){
        	
        	AnuncioEscolar anEscolar = null;
        	
        	anEscolar = anEscolarBO.listarEscolarId(Integer.parseInt(idAnuncio));
        	
        	anEscolar.setNome_empresa(titulo);
        	anEscolar.setVaga_disp(Integer.parseInt(vaga));
        	anEscolar.setDesc_anuncio(descricao);
        	
        	/*Pega o id do veiculo*/
            AnuncioBO anuncioBO = new AnuncioBO();
            Veiculo vec = new Veiculo();

            if(anuncioBO.localizarVeiculoId(Integer.parseInt(veiculo)) !=null){
                vec = anuncioBO.localizarVeiculoId(Integer.parseInt(veiculo));
                vec.setId_veiculo(Integer.parseInt(veiculo));
               }
        	anEscolar.setVeiculo(vec);
        	
        	if(valor == null || valor == ""){
            	valor = "0.00";
                anEscolar.setValor(Double.parseDouble(valor));
            }else{
                anEscolar.setValor(Double.parseDouble(valor));
            }
            
            anEscolar.setTurno(turno);
            
            /*Seta os valores instituicao*/

            List<Instituicao> listar = new ArrayList<Instituicao>();

            if(instituicao1 != null && instituicao1 != ""){
            	Instituicao escola = new Instituicao();
                escola.setNome_instituicao(instituicao1);
                escola.setCidade_instituicao(cidade1);
                listar.add(escola);

            }
            if(instituicao2 != null && instituicao2 != ""){
            	Instituicao escola2 = new Instituicao();
                escola2.setNome_instituicao(instituicao2);
                escola2.setCidade_instituicao(cidade2);
                listar.add(escola2);

            }
            if(instituicao3 != null && instituicao3 != ""){
            	Instituicao escola3 = new Instituicao();
                escola3.setNome_instituicao(instituicao3);
                escola3.setCidade_instituicao(cidade3);
                
                listar.add(escola3);
            }
            
            anEscolar.setInstituicao(listar);
            
            List<BairroEscolar> listaBairro = new ArrayList<>();
            
            if(lat1 != null && lat1 != ""){
            	BairroEscolar bairro1 = new BairroEscolar();
                bairro1.setLatitude(lat1);
                bairro1.setLongitude(long1);
                bairro1.setKm(Integer.parseInt(raio1));
                bairro1.setMetro(Integer.parseInt(mt1));
                listaBairro.add(bairro1);
            }if(lat2 !=null && lat2 != ""){
            	BairroEscolar bairro2 = new BairroEscolar();
                bairro2.setLatitude(lat2);
                bairro2.setLongitude(long2);
                bairro2.setKm(Integer.parseInt(raio2));
                bairro2.setMetro(Integer.parseInt(mt2));
                listaBairro.add(bairro2);

            }if(lat3 != null && lat3 != ""){
            	BairroEscolar bairro3 = new BairroEscolar();
                bairro3.setLatitude(lat3);
                bairro3.setLongitude(long3);
                bairro3.setKm(Integer.parseInt(raio3));
                bairro3.setMetro(Integer.parseInt(mt3));
                
                listaBairro.add(bairro3);
            }if(lat4 != null && lat4 != ""){
            	BairroEscolar bairro4 = new BairroEscolar();
                bairro4.setLatitude(lat4);
                bairro4.setLongitude(long4);
                bairro4.setKm(Integer.parseInt(raio4));
                bairro4.setMetro(Integer.parseInt(mt4));
                
                listaBairro.add(bairro4);
            }if(lat5 != null && lat5 != ""){
            	BairroEscolar bairro5 = new BairroEscolar();
                bairro5.setLatitude(lat5);
                bairro5.setLongitude(long5);
                bairro5.setKm(Integer.parseInt(raio5));
                bairro5.setMetro(Integer.parseInt(mt5));
                
                listaBairro.add(bairro5);
            }if(lat6 != null && lat6 != ""){
            	BairroEscolar bairro6 = new BairroEscolar();
                bairro6.setLatitude(lat6);
                bairro6.setLongitude(long6);
                bairro6.setKm(Integer.parseInt(raio6));
                bairro6.setMetro(Integer.parseInt(mt6));
                
                listaBairro.add(bairro6);
            }
            
            anEscolar.setBairroEscolar(listaBairro);
            
            if(status == null || status == ""){
                anEscolar.setStatus(false);
            }else if(status.equals("on")){
                anEscolar.setStatus(true);
            }
            anEscolar.setData_cadastro(anEscolar.getData_cadastro());
            anEscolar.setData_expira(anEscolar.getData_expira());
            

            anEscolarBO.atualizaAnuncio(anEscolar);
        	
        }
       

		return proximo;
	}

}
