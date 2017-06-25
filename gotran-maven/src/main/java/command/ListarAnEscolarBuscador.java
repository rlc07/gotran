package command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AnuncioEscolarBO;
import bo.RelatorioBO;
import modelo.AnuncioEscolar;
import modelo.BairroEscolar;
import modelo.Relatorio;
import servlet.BsServlet;
import util.GeoUtils;

public class ListarAnEscolarBuscador implements Command, Serializable{

	
	private static final long serialVersionUID = 1L;

	private String proximo = "";
	private AnuncioEscolarBO anEscolarBO;
	private GeoUtils calcularDistancia;
	private RelatorioBO relatorioBO;
	
	
	
	@SuppressWarnings({ "static-access", "unused", "null" })
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		proximo = "publico/buscador/buscar_escolar.jsp";
		anEscolarBO = new AnuncioEscolarBO();
		calcularDistancia = new GeoUtils();
		relatorioBO = new RelatorioBO();
		
		String msg = "Ops, não existe nenhum anuncio escolar disponivel no momento!";
		
		/*Campos do filtro*/
		String instituicao = request.getParameter("instituicao");
		String cidade = request.getParameter("cidade");

		String turno = request.getParameter("turno");
		String cid_escolar = request.getParameter("cidade_escolar");
		
		
		
		/*Id bairro 1*/
		int idBairro1 = 0;
		int idBairro = 0;

		String condicao = "";
		String latUsuario = request.getParameter("lat_usuario");
		String lonUsuario = request.getParameter("lon_usuario");
		
		request.setAttribute("lat", latUsuario);
		request.setAttribute("lon", lonUsuario);
		request.setAttribute("cid", cid_escolar);


		
		request.setAttribute("ins", instituicao);
		request.setAttribute("cidade_filtro", cidade);

		request.setAttribute("tur", turno);



		double kmMax = 3.0;
		
		BairroEscolar bEscolar = new BairroEscolar();
		AnuncioEscolar anEscolar = new AnuncioEscolar();
		
		List<BairroEscolar> listaTodos = anEscolarBO.listarLatLon();
		List<AnuncioEscolar> listar = null;
		List<AnuncioEscolar> listar2 = null;

		List<AnuncioEscolar> listAnEs = new ArrayList<>();
		List<BairroEscolar> listBrEs = new ArrayList<>();

		/*FILTRO*/
		
		if(instituicao != null && !instituicao.equals("") || cidade != null && !cidade.equals("") ||
				turno != null && !turno.equals("") ){
			
			for(BairroEscolar bs : listaTodos){
				
				String latitude =  bs.getLatitude();
				String longitude = bs.getLongitude();
				
				double distancia = calcularDistancia.geoDistanceInKm(Double.parseDouble(latUsuario), Double.parseDouble(lonUsuario), 
						Double.parseDouble(latitude),Double.parseDouble(longitude));
				
				//Inicio do filtro completo
				if(!instituicao.equals("") && !cidade.equals("") && !turno.equals("")){
				
				if(distancia <= kmMax){
					
					
					if(idBairro == 0){
						
						idBairro = bs.getId_bairroMaps();
						listar = anEscolarBO.FiltroCompleto(idBairro, instituicao, cidade, turno, condicao);
												
						if(listar.isEmpty()){
							idBairro = 0;
						}
						
                   	}else{
                   		
                   		int idBairro2 = 0;
                   		String condicao2 = "";
                   		idBairro2 = 0;
						idBairro2 = bs.getId_bairroMaps();
						listar2 = null;						
						listar2 = anEscolarBO.FiltroCompleto(idBairro2, instituicao, cidade, turno, condicao2);

                    	
						if(!listar2.isEmpty()){
							
							if(condicao == "" || condicao == null){
		                    	condicao = " or p.id_bairroMaps = ";
		                    	condicao += idBairro2;
								listar = anEscolarBO.FiltroCompleto(idBairro, instituicao, cidade, turno, condicao);
		                		
		                    }else{
		                    	String condicao1 = " or p.id_bairroMaps = ";
		                    	condicao += condicao1 +=idBairro2;
								listar = anEscolarBO.FiltroCompleto(idBairro, instituicao, cidade, turno, condicao);
		                	}
							
						}
                              	
					      
					}
                   }
			}
			//FIM do filtro completo
				//Inicio do filtro instituicao
				else if(!instituicao.equals("") && cidade.equals("") && turno.equals("")){
				
				if(distancia <= kmMax){
					
					
					if(idBairro == 0){
						
						idBairro = bs.getId_bairroMaps();
						listar = anEscolarBO.FiltroInstituicao(idBairro, instituicao, condicao);
												
						if(listar.isEmpty()){
							idBairro = 0;
						}
						
                   	}else{
                   		
                   		int idBairro2 = 0;
                   		String condicao2 = "";
                   		idBairro2 = 0;
						idBairro2 = bs.getId_bairroMaps();
						listar2 = null;						
						listar2 = anEscolarBO.FiltroInstituicao(idBairro2, instituicao, condicao2);

                        if(!listar2.isEmpty()){
							
							if(condicao == "" || condicao == null){
		                    	condicao = " or p.id_bairroMaps = ";
		                    	condicao += idBairro2;
								listar = anEscolarBO.FiltroInstituicao(idBairro, instituicao, condicao);

		                		
		                    }else{
		                    	String condicao1 = " or p.id_bairroMaps = ";
		                    	condicao += condicao1 +=idBairro2;
								listar = anEscolarBO.FiltroInstituicao(idBairro, instituicao, condicao);

		                	}
							
						}
                              	
					      
					}
                   }
			}
			//FIM do filtro instituicao
			
			
				
				
				//Inicio do filtro cidade
				else if(instituicao.equals("") && !cidade.equals("") && turno.equals("")){
				
				if(distancia <= kmMax){
					
					
					if(idBairro == 0){
						
						idBairro = bs.getId_bairroMaps();
						listar = anEscolarBO.FiltroCidade(idBairro, cidade, condicao);
												
						if(listar.isEmpty()){
							idBairro = 0;
						}
						
                   	}else{
                   		
                   		int idBairro2 = 0;
                   		String condicao2 = "";
                   		idBairro2 = 0;
						idBairro2 = bs.getId_bairroMaps();
						listar2 = null;						
						listar2 = anEscolarBO.FiltroCidade(idBairro2, cidade, condicao2);

                        if(!listar2.isEmpty()){
							
							if(condicao == "" || condicao == null){
		                    	condicao = " or p.id_bairroMaps = ";
		                    	condicao += idBairro2;
								listar = anEscolarBO.FiltroCidade(idBairro, cidade, condicao);

		                		
		                    }else{
		                    	String condicao1 = " or p.id_bairroMaps = ";
		                    	condicao += condicao1 +=idBairro2;
								listar = anEscolarBO.FiltroCidade(idBairro, cidade, condicao);

		                	}
							
						}
                              	
					      
					}
                   }
			}
			//FIM do filtro cidade
					//Inicio do filtro turno
				else if(instituicao.equals("") && cidade.equals("") && !turno.equals("")){
				String condicaoFiltro = "";
				
				if(distancia <= kmMax){
					
					
					if(idBairro == 0){
						
							idBairro = bs.getId_bairroMaps();
							listar = anEscolarBO.FiltroTurno(idBairro, turno, condicao);
						
						
												
						if(listar.isEmpty()){
							idBairro = 0;
						}
						
                   	}else{
                   		
                   		int idBairro2 = 0;
                   		String condicao2 = "";
                   		idBairro2 = 0;
						idBairro2 = bs.getId_bairroMaps();
						listar2 = null;						
						listar2 = anEscolarBO.FiltroTurno(idBairro2, turno, condicao2);

                        if(!listar2.isEmpty()){
							
							if(condicao == "" || condicao == null){
		                    	condicao = " or p.id_bairroMaps = ";
		                    	condicao += idBairro2;
								listar = anEscolarBO.FiltroInstituicao(idBairro, turno, condicao);

		                		
		                    }else{
		                    	String condicao1 = " or p.id_bairroMaps = ";
		                    	condicao += condicao1 +=idBairro2;
								listar = anEscolarBO.FiltroTurno(idBairro, turno, condicao);

		                	}
							
						}
                              	
					      
					}
                   }
			}
			
			//FIM do filtro turno
				else{
					if(distancia <= kmMax){
						
						String opcional = "";
						
						if(!turno.equals("") && !cidade.equals("") && instituicao.equals("")){
							opcional = " e.turno= '"+turno+ "' AND i.cidade_instituicao = '"+cidade+"'";
						}
						else if(!turno.equals("") && cidade.equals("") && !instituicao.equals("")){
							opcional = " e.turno= '"+turno+ "' AND i.nome_instituicao LIKE '%"+instituicao+"%'";
						}
						else if(turno.equals("") && !cidade.equals("") && !instituicao.equals("")){
							opcional = " i.cidade_instituicao= '"+cidade+ "' AND i.nome_instituicao LIKE '%"+instituicao+"%'";
						}
						
						if(idBairro == 0){
							
							idBairro = bs.getId_bairroMaps();
							listar = anEscolarBO.FiltroOpcional(idBairro,condicao, opcional);
													
							if(listar.isEmpty()){
								idBairro = 0;
							}
							
	                   	}else{
	                   		
	                   		int idBairro2 = 0;
	                   		String condicao2 = "";
	                   		idBairro2 = 0;
							idBairro2 = bs.getId_bairroMaps();
							listar2 = null;						
							listar2 = anEscolarBO.FiltroOpcional(idBairro2,condicao2,opcional);

	                    	
							if(!listar2.isEmpty()){
								
								if(condicao == "" || condicao == null){
			                    	condicao = " or p.id_bairroMaps = ";
			                    	condicao += idBairro2;
									listar = anEscolarBO.FiltroOpcional(idBairro,condicao,opcional);
			                		
			                    }else{
			                    	String condicao1 = " or p.id_bairroMaps = ";
			                    	condicao += condicao1 +=idBairro2;
									listar = anEscolarBO.FiltroOpcional(idBairro,condicao,opcional);
			                	}
								
							}
	                              	
						      
						}
	                   }				
					  }
		}
			/*FIM DO FOR*/
			request.setAttribute("listarAnEscolar", listar);
      }
		else if(instituicao == null || instituicao.equals("") && cidade == null || cidade.equals("") && 
				turno == null || turno.equals("") ){
			for(BairroEscolar be : listaTodos){
				
				String latitude =  be.getLatitude();
				String longitude = be.getLongitude();
				
				/*Calcula a distancia entre os ponto*/
				double distancia = calcularDistancia.geoDistanceInKm(Double.parseDouble(latUsuario), Double.parseDouble(lonUsuario), 
						Double.parseDouble(latitude),Double.parseDouble(longitude));
				
				
				if(distancia <= kmMax){

			        if(idBairro1 == 0 ){
			        	idBairro1 = be.getId_bairroMaps();
                    	listar = anEscolarBO.listarAnuncio(idBairro1, condicao);
                       
                    	
	            		request.setAttribute("listarAnEscolar", listar);
	                }else{
	            		int id2 = be.getId_bairroMaps();
	                    
	                    if(condicao == "" || condicao == null){
	                    	condicao = "AND e.status = 1 or p.id_bairroMaps = ";
	                    	condicao += id2;
	                    	listar = anEscolarBO.listarAnuncio(idBairro1, condicao);;
	                		if(listar == null || listar.isEmpty()){
	                			request.setAttribute("msgListaVazia", msg);
	                		}else{
	                			request.setAttribute("listarAnEscolar", listar);
	                		}
	                    }else{
	                    	String condicao1 = " AND e.status = 1 or p.id_bairroMaps = ";
	                    	condicao += condicao1 +=id2;
	                    	listar = anEscolarBO.listarAnuncio(idBairro1, condicao);;
	                        System.out.println(listar);		
	                		if(listar == null || listar.isEmpty()){
	                			request.setAttribute("msgListaVazia", msg);
	                		}else{
	                			request.setAttribute("listarAnEscolar", listar);
	                		}
	                		
	                	
	                    }
				
			        }
				}	
			}
			
			if(listar == null){
				Relatorio  relatorio = new Relatorio();
				String latRelatorio = null;
				String lonRelatorio = null;
				int qtd = 0;
				double kmMx = 4;
				int idRelatorio = 0;
				List<Relatorio> lsRelatorio = relatorioBO.relatorioEscolar();
				
				if(!lsRelatorio.isEmpty()){
				for(Relatorio rlt : lsRelatorio){
					latRelatorio = rlt.getLatitude();
					lonRelatorio = rlt.getLongitude();
					qtd = rlt.getQuantidade();
					idRelatorio = rlt.getId_relatorio();
					
				}
				
				double dist = calcularDistancia.calculaDistancia(Double.parseDouble(latUsuario), Double.parseDouble(lonUsuario), 
						Double.parseDouble(latRelatorio), Double.parseDouble(lonRelatorio));
				
				if(dist <= kmMx){
					Relatorio relat = null;
					relat = relatorioBO.recuperaId(idRelatorio);
					relat.setTipo_transporte("escolar");
					relat.setQuantidade(qtd +=1);
					String la = String.valueOf(latUsuario);
					String lo = String.valueOf(lonUsuario);
					String qt = String.valueOf(qtd);
					relat.setDescricao("Latitude: " +la + " Longitude: "+lo+ " Quantidade: "+qt);
					relatorioBO.atualizar(relat);
					
				}else{
					qtd=0;
					relatorio.setLatitude(latUsuario);
					relatorio.setLongitude(lonUsuario);
					relatorio.setTipo_transporte("escolar");
					relatorio.setQuantidade(qtd +=1);
					String la = String.valueOf(latUsuario);
					String lo = String.valueOf(lonUsuario);
					String qt = String.valueOf(qtd);
					relatorio.setDescricao("Latitude: " +la + " Longitude: "+lo+ " Quantidade: "+qt);
					relatorioBO.gravar(relatorio);
				}
				}else{
					qtd=0;
					
					relatorio.setLatitude(latUsuario);
					relatorio.setLongitude(lonUsuario);
					relatorio.setTipo_transporte("escolar");
					relatorio.setQuantidade(qtd +=1);
					String la = String.valueOf(latUsuario);
					String lo = String.valueOf(lonUsuario);
					String qt = String.valueOf(qtd);
					relatorio.setDescricao("Latitude: " +la + " Longitude: "+lo+ " Quantidade: "+qt);
					relatorioBO.gravar(relatorio);
				}
				
				
			}
		}



		
		
		return proximo;
	}

}
