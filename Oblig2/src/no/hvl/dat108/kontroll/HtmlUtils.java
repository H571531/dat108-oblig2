package no.hvl.dat108.kontroll;

import java.util.Iterator;
import java.util.List;

import no.hvl.dat108.objekter.Handleliste;
import no.hvl.dat108.objekter.Vare;
/**
 * Hjelpeklasse for � skrive ut HTML til responder i servlettene. 
 * 
 * 
 * @author Gruppe22
 *
 */
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
/**
 * Visning av handleliste 	
 * 
 * @param liste, liste av varer som skal vises på siden
 * @return String med ferdig liste med slette-knapper
 */
	
	public static String lagSletteSkjema(Handleliste liste) {
		
		StringBuilder ut = new StringBuilder();
		
		ut.append("<form action=\"HandlelisteServlet\" method=\"post\">\n");
		
		List<Vare> varer = liste.getVarer();
		
		/*
		 * Ved iterering gjennom en synchronizedList er det ifølge javadoc for Collections imperativt at det brukes manuell synkronisering
		 * på listen ved bruk av Iterator, Spliterator eller Stream:
		 * https://docs.oracle.com/javase/9/docs/api/java/util/Collections.html#synchronizedList-java.util.List-
		 */
		
		synchronized(varer) {
			Iterator<Vare> iterator = varer.iterator();
			while(iterator.hasNext()) {
				Vare vare = iterator.next();
				
				ut.append("\t\t<button type=\"submit\" name=\"skalSlette\" value=\"" + vare.getNavn() + "\"/>Slett</button>" +"  "+ vare.getNavn() + "<br />\n");	
			}
		}
		ut.append("	</form>\n");
		
		return ut.toString();
		
	}
	/**
	 * Metode for å vise skjema for å legge til vare. 
	 * @param liste
	 * @return String med HTML for legg-til-vare-skjema
	 */
	public static String lagLeggTilSkjema() {
		
		String ut = ("		<form action=\"HandlelisteServlet\" method=\"post\">\n"
				+ "			<p><input type=\"submit\" value=\"Legg til\" /><input type=\"text\" name=\"nyVare\" /> </p>\n"
				+ "		</form>\n");
		
		return ut;
				  
	}

}
