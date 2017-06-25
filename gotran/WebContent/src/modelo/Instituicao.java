package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Instituicao")
public class Instituicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_INSTITUICAO", sequenceName="SEQ_INSTITUICAO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSTITUICAO")
	private int id_instituicao;
	
	private String nome_instituicao;
	private String cidade_instituicao;
	
	 
	
	
	public Instituicao(){
		
	}
	
	
	public int getId_instituicao() {
		return id_instituicao;
	}
	public void setId_instituicao(int id_instituicao) {
		this.id_instituicao = id_instituicao;
	}
	public String getNome_instituicao() {
		return nome_instituicao;
	}
	public void setNome_instituicao(String nome_instituicao) {
		this.nome_instituicao = nome_instituicao;
	}
	public String getCidade_instituicao() {
		return cidade_instituicao;
	}
	public void setCidade_instituicao(String cidade_instituicao) {
		this.cidade_instituicao = cidade_instituicao;
	}

	@Override
	public String toString() {
		return nome_instituicao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_instituicao;
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
		Instituicao other = (Instituicao) obj;
		if (id_instituicao != other.id_instituicao)
			return false;
		return true;
	}
	
	
}
