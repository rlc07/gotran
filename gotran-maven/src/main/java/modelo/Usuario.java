package modelo;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;





@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 2716505651985785410L;
	
	@Id
	@SequenceGenerator(name="SEQ_USUARIO", sequenceName="SEQ_USUARIO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	private int id_usuario;
	
	private String nome;
	private String sobre_nome;
	
	@Column(unique=true)
	private String email;
	private String senha;
	private String telefone_fixo;
	private String telefone_cel;

	private long id_facebook;
	private String  img_perfil;
	private String id_google;
	private String codigo;
	
	
	public Usuario(){
	
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getId_google() {
		return id_google;
	}


	public void setId_google(String id_google) {
		this.id_google = id_google;
	}


	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobre_nome() {
		return sobre_nome;
	}
	public void setSobre_nome(String sobre_nome) {
		this.sobre_nome = sobre_nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public long getId_facebook() {
		return id_facebook;
	}
	public void setId_facebook(long id_facebook) {
		this.id_facebook = id_facebook;
	}
	
	public String getImg_perfil() {
		return img_perfil;
	}
	public void setImg_perfil(String img_perfil) {
		this.img_perfil = img_perfil;
	}
	
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getTelefone_cel() {
		return telefone_cel;
	}
	public void setTelefone_cel(String telefone_cel) {
		this.telefone_cel = telefone_cel;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_usuario;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id_usuario != other.id_usuario)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return email;
	}
	
	
	

}
