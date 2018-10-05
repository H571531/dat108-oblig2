package no.hvl.dat108.oblig2.kristoffer;

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

}
