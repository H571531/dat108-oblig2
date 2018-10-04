package no.hvl.dat108.oblig2.kristoffer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtils {
	
	protected static String loginOverskrift(HttpServletRequest request) {
		String beOmPassord = "<p>Gi passord: </p>";
		
		String feilPassord = request.getParameter("feilPassord");
		
		if(feilPassord != null){
			//Hvis bruker ble redirected tilbake på grunn av feil passord
			beOmPassord = "<p style=\"color:red;\">Feil passord. Prøv igjen</p>";
		}
		
		String kreverLogin = request.getParameter("trengerLogin");
		if(kreverLogin != null) {
			//Hvis ble redirected tilbake på grunn av session timeout
			beOmPassord = "<p style=\"color:red;\">Denne handlingen krever at du logger inn</p>";
		}
		
		return beOmPassord;
	}
	
	protected static boolean brukerErInnlogget(HttpServletRequest request) {
		
		HttpSession sesjon = request.getSession(false);
		
		return !(sesjon == null || sesjon.getAttribute("loginOk") == null);
		
	}

}
