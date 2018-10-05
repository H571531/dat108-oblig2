package no.hvl.dat108.objekter;

public class Vare {
	
	private String varenavn;
	
	public Vare(String navn) {
		varenavn=navn;
	}

	public String getVarenavn() {
		return varenavn;
	}

	public void setVarenavn(String varenavn) {
		this.varenavn = varenavn;
	}

	@Override
	public String toString() {
		return varenavn;
	}
	

}
