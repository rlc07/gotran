package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Aluguel")
@PrimaryKeyJoinColumn(name="id_anuncio")
public class AnuncioAluguel extends Anuncio{
	
	private String rua;
	private String cidade;
	private String bairro;
	private int numero;
	
	
	
	public AnuncioAluguel(){}
	
	
	
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
	
	
	

}
