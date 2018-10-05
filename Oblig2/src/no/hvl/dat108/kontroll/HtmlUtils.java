package no.hvl.dat108.kontroll;

import java.util.Iterator;
import java.util.List;

import no.hvl.dat108.objekter.Handleliste;
import no.hvl.dat108.objekter.Vare;

public class HtmlUtils {
	
	/**
	 * Gir start-tags for en HTML-side 
	 * @param title Title-attribute i head
	 * @param overskrift Starter siden med overskrift i h1
	 * @return String med html start-tags
	 */
	public static String startHTML(String title, String overskrift) {
		String start = 
				"<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"		<meta charset=\"ISO-8859-1\">\n" + 
				"		<title>" + title + "</title>\n" + 
				"		<link rel=\"stylesheet\" href=\"style.css\">\n"+
				"	</head>\n" + 
				"	<body>\n" +
				"		<h1>" + overskrift + "</h1>"; 
				
		
		return start;
	}
	
	
	/**
	 * Avslutter en HTML-side
	 * @return String med slutt-tags for body og html
	 */
	public static String sluttHTML() {
		String slutt = 
				"	</body>\n" + 
				"</html>";
		
		return slutt;
	}
	
	public static String lagSletteSkjema(Handleliste liste) {
		
		StringBuilder ut = new StringBuilder();
		
		ut.append("<form action=\"HandlelisteServlet\" method=\"post\">\n");
		
		List<Vare> varer = liste.getVarer();
		synchronized(varer) {
			Iterator<Vare> iterator = varer.iterator();
			while(iterator.hasNext()) {
				Vare vare = iterator.next();
				
				ut.append("\t\t<button type=\"submit\" name=\"skalSlette\" value=\"" + vare.getNavn() + "\"/>Slett</button>\"" + vare.getNavn() + "\"<br />\n\"");	
			}
		}
		ut.append("	</form>\n");
		
		return ut.toString();
		
	}
	
	public static String lagLeggTilSkjema(Handleliste liste) {
		
		String ut = ("		<form action=\"HandlelisteServlet\" method=\"post\">\n"
				+ "			<p><input type=\"submit\" value=\"Legg til\" /><input type=\"text\" name=\"nyVare\" /> </p>\n"
				+ "		</form>\n");
		
		return ut;
				  
	}

}
