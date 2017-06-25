package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="relatorio")
public class Relatorio implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_RELATORIO", sequenceName="SEQ_RELATORIO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RELATORIO")
	private int id_relatorio;
	
	private String latitude;
	private String longitude;
	private String tipo_transporte;
	private int quantidade;
	private String descricao;
	
	public Relatorio(){}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId_relatorio() {
		return id_relatorio;
	}
	public void setId_relatorio(int id_relatorio) {
		this.id_relatorio = id_relatorio;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public String getTipo_transporte() {
		return tipo_transporte;
	}
	public void setTipo_transporte(String tipo_transporte) {
		this.tipo_transporte = tipo_transporte;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_relatorio;
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
		Relatorio other = (Relatorio) obj;
		if (id_relatorio != other.id_relatorio)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Relatorio [quantidade=" + quantidade + "]";
	}
	
	
	
	

}
