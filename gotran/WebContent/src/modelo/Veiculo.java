package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable{

	
	private static final long serialVersionUID = -6065799193221338204L;
	
	@Id
	@SequenceGenerator(name="SEQ_VEICULO", sequenceName="SEQ_VEICULO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEICULO")
	private int id_veiculo;
	
	private String modelo;
	private String marca;
	private int ano;
	private int qtd_assento;
	private String combustivel;
	private String desc_veiculo;
	private String tipo_veiculo;
	private String data_atual;
	private String img_veiculo;


	@ManyToOne
	@JoinColumn(name="usuario" ,referencedColumnName="ID_USUARIO", nullable=false)
	private Usuario usuario;

	public int getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQtd_assento() {
		return qtd_assento;
	}

	public void setQtd_assento(int qtd_assento) {
		this.qtd_assento = qtd_assento;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

	public String getTipo_veiculo() {
		return tipo_veiculo;
	}

	public void setTipo_veiculo(String tipo_veiculo) {
		this.tipo_veiculo = tipo_veiculo;
	}

	public String getDesc_veiculo() {
		return desc_veiculo;
	}

	public void setDesc_veiculo(String desc_veiculo) {
		this.desc_veiculo = desc_veiculo;
	}
	
	

	public String getData_atual() {
		return data_atual;
	}

	public void setData_atual(String data_atual) {
		this.data_atual = data_atual;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Veiculo [modelo=" + modelo + "]";
	}
	

	public String getImg_veiculo() {
		return img_veiculo;
	}

	public void setImg_veiculo(String img_veiculo) {
		this.img_veiculo = img_veiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_veiculo;
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
		Veiculo other = (Veiculo) obj;
		if (id_veiculo != other.id_veiculo)
			return false;
		return true;
	}
	
	

}
