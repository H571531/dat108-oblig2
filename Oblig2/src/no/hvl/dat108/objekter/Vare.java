package no.hvl.dat108.objekter;


public class Vare {
	
	private String varenavn;
	
	public Vare(String navn) {
		varenavn=navn;
	}

	public String getNavn() {
		return varenavn;
	}

	public void setVarenavn(String varenavn) {
		this.varenavn = varenavn;
	}
	
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
