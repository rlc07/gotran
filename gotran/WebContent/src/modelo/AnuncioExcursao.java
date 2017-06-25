package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="excursao")
@PrimaryKeyJoinColumn(name="id_anuncio")
public class AnuncioExcursao extends Anuncio{
	
	private String rua;
	private String bairro;
	private String cidade;
	
	private String destino;
	private String data_excursao;
	
	private String data_retorno;
	private int numero;
	
	public AnuncioExcursao(){
		
	}

	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getData_excursao() {
		return data_excursao;
	}

	public void setData_excursao(String data_excursao) {
		this.data_excursao = data_excursao;
	}



	public String getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(String data_retorno) {
		this.data_retorno = data_retorno;
	}

	
	
	
	

}
