package no.hvl.dat108.oblig2.kristoffer;

public class Vare {
	
	String navn;
	//statisk id for å gjøre sletting lettere? 
	
	public Vare(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	@Override
	public String toString() {
		return navn;
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
		if (navn == null) {
			if (other.navn != null)
				return false;
		} else if (!navn.equals(other.navn))
			return false;
		return true;
	}
	
	

}
