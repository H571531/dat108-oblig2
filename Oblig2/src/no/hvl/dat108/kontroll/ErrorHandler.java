package no.hvl.dat108.kontroll;
/**
 * Hjelpeklasse for � sjekke feil i inlogging/utg�tt session.
 * 
 * @author Gruppe22
 * @version 1.0.1
 */

public class ErrorHandler {
		
	/**
	 * Metode for sjekk av feilkode. 
	 * 
	 * @param String errorCode ; String med tall hentet fra error parameter. 
	 * @return String feilmelding ; tekst som samh�rer med feilkoden
	 */
public static String errorCheck(String errorCodeString){
	String feilmelding="";
	int errorcode=0;
	if(errorCodeString != null) {
		try {
			//Kan oppstå exception hvis bruker manuelt forsøker å gå til f. eks. Logginn?error=ikkePlanlagtTekst
			errorcode=Integer.parseInt(errorCodeString);
		}catch(Exception e){
			errorcode=3;	//Om en ugyldig verdi er gitt i error parameteren vil brukeren f� en "Ukejnt feil" melding. 
		}finally {
			switch (errorcode) {
				case 1:
					feilmelding="Feil passord";
					break;
				case 2:
					feilmelding="Du m&aring; v&aelig;re logget inn for &aring; se denne siden";
					break;
				case 3:
					feilmelding="Ukjent Feil";
					break;
				case 4:
					feilmelding = "Du m&aring; logge inn p&aring; nytt for &aring; utf&oslash;re denne handlingen.";
					break;
				default:
					feilmelding="Ukjent Feil";
					break;
			}
		}
		
	}
	return feilmelding;
}
	
	
}
