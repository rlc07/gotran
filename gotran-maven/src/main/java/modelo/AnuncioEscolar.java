package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="escolar")
@PrimaryKeyJoinColumn(name="id_anuncio")
public class AnuncioEscolar extends Anuncio{
	
	private String turno;
    private int vaga_disp;
	
    @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name="ESCOLAR_INSTITUICAO",
	             joinColumns={@JoinColumn(name="ID_ANUNCIO")},
	             inverseJoinColumns={@JoinColumn(name="ID_INSTITUICAO")}) 
    private List<Instituicao> instituicao;
    
    @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name="ESCOLAR_BAIRRO",
	             joinColumns={@JoinColumn(name="ID_ANUNCIO")},
	             inverseJoinColumns={@JoinColumn(name="ID_BAIRRO")}) 
  private List<BairroEscolar> bairroEscolar;
    
    public AnuncioEscolar(){}

    
    
	public List<BairroEscolar> getBairroEscolar() {
		return bairroEscolar;
	}



	public void setBairroEscolar(List<BairroEscolar> bairroEscolar) {
		this.bairroEscolar = bairroEscolar;
	}



	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getVaga_disp() {
		return vaga_disp;
	}

	public void setVaga_disp(int vaga_disp) {
		this.vaga_disp = vaga_disp;
	}

	public List<Instituicao> getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(List<Instituicao> instituicao) {
		this.instituicao = instituicao;
	}



	@Override
	public String toString() {
		return "AnuncioEscolar [turno=" + turno + ", vaga_disp=" + vaga_disp + ", instituicao=" + instituicao
				+ ", bairroEscolar=" + bairroEscolar + "]";
	}
    
    
	

}
