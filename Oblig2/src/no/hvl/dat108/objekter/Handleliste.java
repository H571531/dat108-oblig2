package no.hvl.dat108.objekter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import no.hvl.dat108.kontroll.VareKontroll;


/**
 * Klasse for Handleliste objekter. 
 * Brukes til � lagre varene. 
 * 
 * @author Gruppe22
 *
 */
public class Handleliste {
	
	static List<Vare> varer;
	
	/**
	 * Konstrukt�r
	 */
	public Handleliste() {
		//Oppretter varer som en synchronized list
		varer = Collections.synchronizedList(new ArrayList<Vare>());
	}
	
	/**
	 * Metode for � legge til vare i listen
	 * @param varenavn
	 */
	public void leggTil(String varenavn) {
		if(VareKontroll.lovligVare(varenavn)){
			synchronized(varer) {
				varer.add(new Vare(varenavn));
			}
		}
		
		
	}
	/**
	 * Metode for � fjerne vare fra listen
	 * 
	 * @param vareNavn
	 */
	public void fjernVare(String vareNavn) {
		synchronized(varer) {
				//Har sjekket for om varen som forsøkes fjernet er null 
				//Hvis en bruker forsøker å fjerne en vare som allerede er fjernet av en annen bruker, forblir listen uendret ifølge API for ArrayList
				varer.remove(new Vare(vareNavn));
			
			
		}
		
	}

	/**
	 * For � hente hele vare listen. 
	 * @return hele listen med varer
	 */
	public List<Vare> getVarer() {
		return varer;
	}
	
	

}
