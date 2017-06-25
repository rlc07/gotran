package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="anuncio")
@Inheritance(strategy = InheritanceType.JOINED)
public class Anuncio {
	
	@Id
	@SequenceGenerator(name="SEQ_ANUNCIO", sequenceName="SEQ_ANUNCIO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ANUNCIO")
	private int id_anuncio;
	
	private String nome_empresa;
	private String desc_anuncio;
	private double valor ;
	private String data_cadastro;
	private String data_expira;
	private boolean status;
	
	 @ManyToOne
	 @JoinColumn(name="VEICULO", referencedColumnName="id_veiculo",foreignKey = @ForeignKey(foreignKeyDefinition =
		        "FOREIGN KEY(VEICULO) REFERENCES Veiculo(id_veiculo) ON DELETE CASCADE",
		        value = ConstraintMode.CONSTRAINT))
     private Veiculo veiculo;
    
    public Anuncio(){}
    
    
    


	public Veiculo getVeiculo() {
		return veiculo;
	}





	public boolean getStatus() {
		return status;
	}





	public void setStatus(boolean status) {
		this.status = status;
	}





	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}





	public String getData_expira() {
		return data_expira;
	}





	public void setData_expira(String data_expira) {
		this.data_expira = data_expira;
	}





	public int getId_anuncio() {
		return id_anuncio;
	}
	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}
	public String getNome_empresa() {
		return nome_empresa;
	}
	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}
	public String getDesc_anuncio() {
		return desc_anuncio;
	}
	public void setDesc_anuncio(String desc_anuncio) {
		this.desc_anuncio = desc_anuncio;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_anuncio;
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
		Anuncio other = (Anuncio) obj;
		if (id_anuncio != other.id_anuncio)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Anuncio [nome_empresa=" + nome_empresa + "]";
	}
	
	

}
