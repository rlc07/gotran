package modelo;


import org.json.JSONException;
import org.json.JSONObject;

public class UsuarioFacebook {

	private Long id; 
	private String email; 	
	private String first_name;	
	private String last_name;
	private String picture;
	
	public UsuarioFacebook(JSONObject jsonUsuario) throws JSONException{
		
		String[] fields = JSONObject.getNames(jsonUsuario);
		
		for (String field : fields) {
			if (field.equals("id")) {
				id = jsonUsuario.getLong("id");
				continue;
			}
			if (field.equals("picture")) {
				picture = jsonUsuario.getString("picture");
				continue;
			}
			
			if (field.equals("email")) {
				email = jsonUsuario.getString("email");
				continue;
			}
			if (field.equals("first_name")) {
				first_name = jsonUsuario.getString("first_name");
				continue;
			}
			if (field.equals("last_name")) {
				last_name = jsonUsuario.getString("last_name");
				continue;
			}
			
			
		}
	}

	
	
	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	
}
