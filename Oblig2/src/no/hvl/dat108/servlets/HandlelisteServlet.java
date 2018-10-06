package no.hvl.dat108.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;

import no.hvl.dat108.kontroll.HtmlUtils;
import no.hvl.dat108.kontroll.SessionKontroll;
import no.hvl.dat108.objekter.Handleliste;


/**
 * Servlet implementation class HandlelisteServlet
 */
@WebServlet("/HandlelisteServlet")
public class HandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Handleliste handleliste;

	@Override
	public void init() throws ServletException {
		handleliste = new Handleliste();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=ISO-8859-1");
		
		if(SessionKontroll.brukerErIkkeInnlogget(request)) {
			response.sendRedirect("logginn?error=2");
		} else {
			PrintWriter ut = response.getWriter();
			
			ut.println(HtmlUtils.startHTML("Handleliste", "Min handleliste"));
			
			ut.println(HtmlUtils.lagLeggTilSkjema(handleliste));
			
			ut.println(HtmlUtils.lagSletteSkjema(handleliste));
					
			ut.println(HtmlUtils.sluttHTML()); 
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		
		//Hvis sesjon er utgått og bruker forsøker å legge til eller fjerne, send tilbake til LoginServlet 
		if(SessionKontroll.brukerErIkkeInnlogget(request)) {
			response.sendRedirect("logginn?error=4");
		} else {
			
			//Alt ok - legg til eller fjern og send tilbake til samme side
			String nyVare = request.getParameter("nyVare");
			String sletteVare = request.getParameter("skalSlette");
			
			//Gitt i oppgave at man ikke skal legge til hvis bruker gir tom input
			if(nyVare != null) {
				//Ufarliggjøring av brukerinput ved hjelp av commons-text
				nyVare = StringEscapeUtils.escapeHtml4(nyVare);
				handleliste.leggTil(nyVare);
			} 
			
			
			//Hente navn på vare som skal slettes
			if(sletteVare != null) {
				//Hvis noe skal slettes, send til handleliste for sletting
				handleliste.fjernVare(sletteVare);
			}
			
			response.sendRedirect("HandlelisteServlet");
			
		}
		
	}
	
}
