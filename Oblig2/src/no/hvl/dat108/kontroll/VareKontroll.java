package no.hvl.dat108.kontroll;


/**
 * Klasse for å sjekke navn på gitt vare. 
 * 
 * @author Gruppe22
 *
 */
public class VareKontroll {

	/**
	 * Metode for sjekk av navn på lagt til vare er lovlig. 
	 * 
	 * @param vare
	 * @return boolen om gitt varenavn er lovlig eller ikke
	 */
	public static boolean lovligVare(String vare) {
		//Gitt i oppgave at man ikke skal lagre noe hvis det gis en tom streng
		 return !vare.equals("") && !vare.startsWith(" ");
	}
}
