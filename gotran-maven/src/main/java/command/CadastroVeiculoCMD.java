package command;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.UsuarioBO;
import bo.VeiculoBO;
import dao.VeiculoDAO;
import modelo.Usuario;
import modelo.Veiculo;


public class CadastroVeiculoCMD implements Command {
	
	private Usuario usuario;
	private UsuarioBO usuarioBO;
	private VeiculoBO veiculoBO;
	private Veiculo veiculo;
	private String proximo = "";

  	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
        proximo = "privado/anunciante/meus_veiculos.jsp";

	
			try {
				upload(request);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
   return proximo;
	}

	public void upload(HttpServletRequest request) throws ServletException, IOException {
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		if (isMultiPart) {
	        FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        String formulario = "";
	        System.out.println(formulario);
	        try {
	        	File file = null;
	        	String nome_img = null;
	        	String id_usuario = null;
	        	String marca = null;
	        	String modelo = null;
	        	String ano = null;
	        	String qtd_assento = null;
	        	String desc_veiculo = null;
	            String tipo_veiculo = null;
	            String combustivel_veiculo = null;
	            String id_veiculo = null;
	            
	            List items = upload.parseRequest(request);
	            Iterator iter = items.iterator();
	            while (iter.hasNext()) {
	                FileItem item = (FileItem) iter.next();
	                if (item.isFormField()) {  
	                	
	                	if(id_usuario == null){
	                     id_usuario = item.getString();
	                	}else if(marca == null){
	                     marca = item.getString();
	                	}else if(modelo == null){
	                		modelo = item.getString();
	                	}else if(ano == null){
	                		ano = item.getString();
	                	}else if(qtd_assento == null){
	                		qtd_assento = item.getString();
	                	}else if(combustivel_veiculo == null){
	                		combustivel_veiculo = item.getString();
	                	}else if(tipo_veiculo == null){
	                		tipo_veiculo = item.getString();
	                	}else if(desc_veiculo == null){
	                		desc_veiculo = item.getString();
	                	}else if (id_veiculo == null){
	                		id_veiculo = item.getString();
	                	}
	                    
	                }
	                if (!item.isFormField()) {
	                    if (item.getName().length() > 0) {
	 		                   file = inserirImagemDiretorioVeiculo(item);
                               
	                    	}
		                   nome_img = item.getName();
		                   

	                    }
	                }

	            
	            
	            usuarioBO = new UsuarioBO();
                
                	
            

                	  VeiculoDAO dao = new VeiculoDAO();
                	  VeiculoBO veiculoBO = new VeiculoBO();
                	  
                	  if(usuarioBO.localizarIdUsuario(Integer.parseInt(id_usuario)) != null 
                			  && id_veiculo == null){
                	    	
                		  veiculo = new Veiculo();
                            usuario = new Usuario();
                            
                            usuario = usuarioBO.localizarIdUsuario(Integer.parseInt(id_usuario));
                            veiculo.setMarca(marca);
                            veiculo.setModelo(modelo);
                            veiculo.setAno(Integer.parseInt(ano));
                            veiculo.setQtd_assento(Integer.parseInt(qtd_assento));
                            veiculo.setDesc_veiculo(desc_veiculo);
                            veiculo.setTipo_veiculo(tipo_veiculo);
                            
                            if(nome_img == "" || nome_img == null){
                            	veiculo.setImg_veiculo("veiculosemfoto.jpg");
                            }else{
                                veiculo.setImg_veiculo(nome_img);

                            }
                            veiculo.setCombustivel(combustivel_veiculo);
                            
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        	Date date = new Date();
                        	String data = dateFormat.format(date);
                        	
                        	veiculo.setData_atual(data);
                    	    veiculo.setUsuario(usuario);
                  	        dao.persist(veiculo);
                	  }else{
                		  Veiculo veiculo = null;
                		  
                		  veiculo = veiculoBO.listarVeiculoID(Integer.parseInt(id_veiculo));
                		  veiculo.setMarca(marca);
                          veiculo.setModelo(modelo);
                          veiculo.setAno(Integer.parseInt(ano));
                          veiculo.setQtd_assento(Integer.parseInt(qtd_assento));
                          veiculo.setDesc_veiculo(desc_veiculo);
                          veiculo.setTipo_veiculo(tipo_veiculo);
                          
                          if(nome_img == "" || nome_img == null){
                          	veiculo.setImg_veiculo(veiculo.getImg_veiculo());
                          }else{
                            veiculo.setImg_veiculo(nome_img);
                          }
                          
                          veiculo.setCombustivel(combustivel_veiculo);
                          
                          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                      	Date date = new Date();
                      	String data = dateFormat.format(date);
                      	
                      	veiculo.setData_atual(data);

                      	dao.update(veiculo);
                		  
                	  }
                  
                    
                	
                
	        } catch (FileUploadException ex) {
	        	ex.printStackTrace();
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
	    }
	}

	private File inserirImagemDiretorioPerfil(FileItem item) throws IOException {
		String caminho = "C:/img_gotran/img_perfil";

		File diretorio = new File(caminho);
		System.out.println("diretorio: " + diretorio.getAbsolutePath());
		if (!diretorio.exists()) diretorio.mkdir();

		String nome = item.getName();
		String id = item.getFieldName();
		String arg[] = nome.split("\\\\");
		for (int i = 0; i < arg.length; i++) nome = arg[i];
	

		File file = new File(diretorio, nome);
	    FileOutputStream output = new FileOutputStream(file);
	    InputStream is = item.getInputStream();
	    byte[] buffer = new byte[2048];
	    int nLidos;
	    while ((nLidos = is.read(buffer)) >= 0) {
	        output.write(buffer, 0, nLidos);
	    }
		output.flush();
		output.close();
		return file;
		
		
	
	}
	
	private File inserirImagemDiretorioVeiculo(FileItem item) throws IOException {
		String caminho = "C:/img_gotran/img_veiculo";

		File diretorio = new File(caminho);
		System.out.println("diretorio: " + diretorio.getAbsolutePath());
		if (!diretorio.exists()) diretorio.mkdir();

		String nome = item.getName();
		String id = item.getFieldName();
		String arg[] = nome.split("\\\\");
		for (int i = 0; i < arg.length; i++) nome = arg[i];
	

		File file = new File(diretorio, nome);
	    FileOutputStream output = new FileOutputStream(file);
	    InputStream is = item.getInputStream();
	    byte[] buffer = new byte[2048];
	    int nLidos;
	    while ((nLidos = is.read(buffer)) >= 0) {
	        output.write(buffer, 0, nLidos);
	    }
		output.flush();
		output.close();
		return file;
		
		
	
	}


}
