package modelo;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Frete")
@PrimaryKeyJoinColumn(name="id_anuncio")
public class AnuncioFrete  extends Anuncio implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private String tipo_carga;
	private double carga;
	private boolean disp_viagem;
	private String rua;
	private String cidade;
	private int numero;
	private String bairro;
	
	
	public AnuncioFrete(){
		
	}
	
	


	public String getRua() {
		return rua;
	}




	public void setRua(String rua) {
		this.rua = rua;
	}




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public int getNumero() {
		return numero;
	}




	public void setNumero(int numero) {
		this.numero = numero;
	}




	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public String getTipo_carga() {
		return tipo_carga;
	}


	public void setTipo_carga(String tipo_carga) {
		this.tipo_carga = tipo_carga;
	}


	public double getCarga() {
		return carga;
	}


	public void setCarga(double carga) {
		this.carga = carga;
	}


	public boolean isDisp_viagem() {
		return disp_viagem;
	}


	public void setDisp_viagem(boolean disp_viagem) {
		this.disp_viagem = disp_viagem;
	}


}
