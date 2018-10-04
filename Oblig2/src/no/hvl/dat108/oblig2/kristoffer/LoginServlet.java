package no.hvl.dat108.oblig2.kristoffer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/LoginServlet") 
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String korrektPassord;
	int timeout;

	@Override
	public void init() throws ServletException {
		korrektPassord = getServletContext().getInitParameter("korrektPassord");
		timeout = Integer.parseInt(getServletContext().getInitParameter("timeout"));
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter ut = response.getWriter();
		
		String beOmPassord = LoginUtils.loginOverskrift(request);
			
			
		ut.println(HtmlUtils.startHTML("Logg inn", ""));
		
		ut.println(
				"<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"		<meta charset=\"ISO-8859-1\">\n" + 
				"			<title>Logg inn</title>\n" + 
				"	</head>\n" + 
				"	<body>\n" +
						beOmPassord 
				+ "		<form action=\"LoginServlet\" method=\"post\">"
				+ "			<p><input type=\"password\" name=\"passord\" /> </p>"
				+ "			<p><input type=\"submit\" value=\"Logg inn\" /></p>"
				+ "		</form>"
				); 
		
		ut.println(HtmlUtils.sluttHTML());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Hent brukerangitt passord fra request
		String passord = request.getParameter("passord");
		
		//sammenlign med null og "korrekt" passord fra web.xml
		
		if(passord == null || !passord.equals(korrektPassord)) {
			response.sendRedirect("LoginServlet?feilPassord");
		} else {
			
			//Forsøk å hente session - hvis den ikke finnes, ikke opprett ny
			HttpSession sesjon = request.getSession(false);
			if(sesjon != null) {
				//hvis session finnes, invalider session
				sesjon.invalidate();
			}
			
			//Opprett ny session
			sesjon = request.getSession(true);
			
			//"logg ut" etter antall sekunder gitt i web.xml
			sesjon.setMaxInactiveInterval(timeout);
			
			//Send videre at login er ok
			sesjon.setAttribute("loginOk", true);
			
			//Send videre til HandlelisteServlet
			response.sendRedirect("HandlelisteServlet");
		}
	}
	
	

}
