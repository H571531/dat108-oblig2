package no.hvl.dat108.objekter;

/**
 * Klasse for vare objekter. 
 * 
 * @author Gruppe22
 *
 */
public class Vare {
	
	private String varenavn;
	
	/**
	 * Konstruktør
	 * 
	 * @param navn på varen
	 */
	public Vare(String navn) {
		varenavn=navn;
	}
	
	/**
	 * Gir navn
	 * 
	 * @return navnet på varen
	 */
	public String getNavn() {
		return varenavn;
	}

	/**
	 * Metode for å endre varenavn
	 * @param varenavn
	 */
	public void setVarenavn(String varenavn) {
		this.varenavn = varenavn;
	}
	/**
	 * Sjekker om en vare er lik noe. 
	 * @param et objekt for å teste om det er likt varen
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
