package no.hvl.dat108.kontroll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Hjelpeklasse for å sjekke "sessjoner"
 * 
 * @author Gruppe22
 *
 */
public class SessionKontroll {

	
	/**
	 * Metode som sjekker om sesjonen finnes og har attributten "inlogget"
	 * 
	 * 
	 * @param request
	 * @return Boolsk verdi om sessjonen er godkjent eller ikke
	 */
	public static boolean brukerErIkkeInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		
		return sesjon==null || sesjon.getAttribute("inlogget")==null;
	}
	
	
}
