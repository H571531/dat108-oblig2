package no.hvl.dat108.kontroll;

public class ErrorHandler {
public static String errorCheck(String errorCode){
	String feilmelding="";
	int errorcode=0;
	if(errorCode != null) {
		try {
			errorcode=Integer.parseInt(errorCode);
		}catch(Exception e){
			errorcode=3;	
		}finally {
			switch (errorcode) {
				case 0:
					break;
				case 1:
					feilmelding="Feil passord";
					break;
				case 2:
					feilmelding="Du må være logget inn for å se denne siden";
					break;
				case 3:
					feilmelding="Ukjent Feil";
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
