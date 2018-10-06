package no.hvl.dat108.kontroll;

import no.hvl.dat108.objekter.Vare;

/**
 * Klasse for å sjekke navn på gitt vare. 
 * 
 * @author Gruppe22
 *
 */
public class VareKontroll {

	/**
	 * Metode for sjekk av lagt til vare navn er lovlig. 
	 * 
	 * @param vare
	 * @return boolen om lovlig eller ikke
	 */
	public static boolean lovligVare(String vare) {
		 return !vare.equals("") && !vare.startsWith(" ");
	}
}
