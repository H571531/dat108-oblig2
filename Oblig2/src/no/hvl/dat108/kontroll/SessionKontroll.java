package no.hvl.dat108.kontroll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionKontroll {

	public static boolean brukerErIkkeInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		
		return sesjon==null || sesjon.getAttribute("inlogget")==null;
	}
	
	
}
