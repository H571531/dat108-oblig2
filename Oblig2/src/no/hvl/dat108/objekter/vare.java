package no.hvl.dat108.objekter;

public class vare {
	
	private String varenavn;
	
	public vare(String navn) {
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
