package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bairromaps")
public class BairroEscolar {

	@Id
	@SequenceGenerator(name="SEQ_BAIRRO", sequenceName="SEQ_BAIRRO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BAIRRO")
	private int id_bairroMaps;
	
	private String latitude;
	private String longitude;
	private int km;
	private int metro;
	
	public BairroEscolar(){}

	public int getId_bairroMaps() {
		return id_bairroMaps;
	}
	public void setId_bairroMaps(int id_bairroMaps) {
		this.id_bairroMaps = id_bairroMaps;
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
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getMetro() {
		return metro;
	}
	public void setMetro(int metro) {
		this.metro = metro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_bairroMaps;
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
		BairroEscolar other = (BairroEscolar) obj;
		if (id_bairroMaps != other.id_bairroMaps)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BairroEscolar [id_bairroMaps=" + id_bairroMaps + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", km=" + km + ", metro=" + metro + "]";
	}
	
	
	
	
	
}
