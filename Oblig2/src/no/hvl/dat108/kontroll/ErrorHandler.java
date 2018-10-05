package no.hvl.dat108.kontroll;

public class ErrorHandler {
public static String errorCheck(String errorCode){
	String feilmelding="";
	int errorcode=0;
	if(errorCode != null) {
		try {
			//Kan oppstå exception hvis bruker manuelt forsøker å gå til f. eks. Logginn?error=ikkePlanlagtTekst
			errorcode=Integer.parseInt(errorCode);
		}catch(Exception e){
			errorcode=3;	
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
