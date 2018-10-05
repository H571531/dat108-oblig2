package no.hvl.dat108.objekter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;



public class Handleliste {
	
	static List<Vare> varer;
	
	public Handleliste() {
		varer = Collections.synchronizedList(new ArrayList<Vare>());
	}
	
	public void leggTil(Vare vare) {
		synchronized(varer) {
			varer.add(vare);
		}
		
	}
	
	public void fjernVare(String vareNavn) {
		synchronized(varer) {
				//Har sjekket for om varen som forsøkes fjernet er null 
				//Hvis en bruker forsøker å fjerne en vare som allerede er fjernet av en annen bruker, forblir listen uendret ifølge API for ArrayList
				varer.remove(new Vare(vareNavn));
			
			
		}
		
	}

	public static List<Vare> getVarer() {
		return varer;
	}
	
	

}
