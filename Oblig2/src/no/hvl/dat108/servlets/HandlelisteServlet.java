package no.hvl.dat108.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

import no.hvl.dat108.kontroll.HtmlUtils;
import no.hvl.dat108.objekter.Handleliste;
import no.hvl.dat108.objekter.Vare;
import no.hvl.dat108.kontroll.SessionKontroll;


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
			response.sendRedirect("Logginn?error=2");
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
		
		//Hvis sesjon er utgått eller kommet til handleliste uten å logge inn, send tilbake til LoginServlet 
		if(SessionKontroll.brukerErIkkeInnlogget(request)) {
			response.sendRedirect("logginn?error=2");
		} else {
			
			//Alt ok - legg til eller fjern og send tilbake til samme side
			String nyVare = request.getParameter("nyVare");
			String sletteVare = request.getParameter("skalSlette");
			
			//Gitt i oppgave at man ikke skal legge til hvis bruker gir tom input
			if(nyVare != null && !nyVare.equals("")) {
				//Ufarliggjøring av brukerinput ved hjelp av commons-text
				nyVare = StringEscapeUtils.escapeHtml(nyVare);
				handleliste.leggTil(new Vare(nyVare));
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
