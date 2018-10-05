package no.hvl.dat108.kontroll;

import javax.servlet.http.HttpSession;

public class SessionKontroll {

	public static boolean authenticate(HttpSession sesjon) {
		return sesjon==null || sesjon.getAttribute("inlogget")==null;
	}
	
	
}
