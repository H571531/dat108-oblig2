package no.hvl.dat108.objekter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Klasse for vare objekter. 
 * 
 * @author Gruppe22
 *
 */

@Entity
@Table(schema = "handleliste", name = "handleliste")
public class Vare {
	@Id
	private String varenavn;
	
	/**
	 * Konstruktør
	 * 
	 * @param navn p� varen
	 */
	public Vare(String navn) {
		varenavn=navn;
	}
	
	/**
	 * Gir navn
	 * 
	 * @return navnet p� varen
	 */
	public String getNavn() {
		return varenavn;
	}

	/**
	 * Metode for � endre varenavn
	 * @param varenavn
	 */
	public void setVarenavn(String varenavn) {
		this.varenavn = varenavn;
	}
	/**
	 * Sjekker om en vare er lik noe. 
	 * @param et objekt for � teste om det er likt varen
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vare other = (Vare) obj;
		if (varenavn == null) {
			if (other.varenavn != null)
				return false;
		} else if (!varenavn.equals(other.varenavn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return varenavn;
	}
	

}
