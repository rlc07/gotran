package bo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import modelo.Usuario;
import modelo.Veiculo;

public class ImgUpload {
	
	private UsuarioBO bo;
	private Usuario usuario;
	
	public void upload(HttpServletRequest request, String nome_img ) throws ServletException, IOException {
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		if (isMultiPart) {
			System.out.println("upload");
	        FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        String formulario = "";
	        System.out.println(formulario);
	        try {
	        	File file = null;
	        	String id_usuario = null;
	        	String email = null;
	            List items = upload.parseRequest(request);
	            Iterator iter = items.iterator();
	            while (iter.hasNext()) {
	                FileItem item = (FileItem) iter.next();
	                if (item.isFormField()) {  
	                	
	                	if(id_usuario == null){
	                     id_usuario = item.getString();
	                	}else if(email == null){
	                     email = item.getString();
	                	}
	                    
	                }
	                if (!item.isFormField()) {
	                    if (item.getName().length() > 0) {
	                    	System.out.println("chama método");
	                    	if(id_usuario !=null && email ==null){
	 		                   file = inserirImagemDiretorioVeiculo(item);
                               
	                    	}else if(id_usuario != null && email != null){
	 		                   file = inserirImagemDiretorioPerfil(item);

	                    	}
		                   nome_img = item.getName();
		                    System.out.println(file);
		                    System.out.println(nome_img);

	                    }
	                }

	            }
	            
	            bo = new UsuarioBO();
                
                if(bo.localizarIdUsuario(Integer.parseInt(id_usuario)) != null && file != null
                		&& email !=null){
                	
                    
                    usuario = new Usuario();
                    
                    usuario = bo.localizarIdUsuario(Integer.parseInt(id_usuario));
                    usuario.setImg_perfil(nome_img);
                    bo.atualizarUsuario(usuario);
                }else if(bo.localizarIdUsuario(Integer.parseInt(id_usuario)) != null && file != null
                		&& email ==null){
                	
                	Veiculo veiculo = new Veiculo();
                    usuario = new Usuario();
                    
                    usuario = bo.localizarIdUsuario(Integer.parseInt(id_usuario));
                    veiculo.setImg_veiculo(nome_img);
                    

                	
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
