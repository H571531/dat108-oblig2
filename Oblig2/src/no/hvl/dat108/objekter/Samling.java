package no.hvl.dat108.objekter;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat108.kontroll.VareKontroll;

public class Samling {
private List<vare> Samling;

public Samling() {
	Samling = new ArrayList<vare>();
}

public void leggTil(vare v) {
	if(VareKontroll.lovligVare(v.getVarenavn())) {
	Samling.add(v);
	}//
}



}
