package no.hvl.dat108.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.kontroll.SessionKontroll;
import no.hvl.dat108.objekter.Samling;

/**
 * Servlet implementation class handleliste
 */
@WebServlet("/handleliste")
public class Handleliste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Samling handleliste;
	
	@Override
	public void init()throws ServletException {
		handleliste=new Samling();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon=request.getSession(false);
		if(SessionKontroll.autheticate(sesjon)) {
			response.sendRedirect("logginn" +"?error=2");
		}else {
			response.setContentType("text/html; charset=ISO-8859-1");
	    	
		       PrintWriter out = response.getWriter();

		       out.println("<!DOCTYPE html>");
		       out.println("<html>");
		       out.println("<head>");
		       	out.println("<meta charset=\"ISO-8859-1\">");
		       	out.println("<title>Handleliste</title>");
		       	out.println("<link rel=\"stylesheet\" href=\"style.css\">\r\n");
		       out.println("</head>");
		       out.println("<body>");
		       
		       out.println("<div class=\"main\">");
		       out.println("<div class=\"orange\">");

		       out.println("<h1>Handleliste</h1>\r\n");
		       out.println("<div class=\"leggtil\"");
		        out.println("<form action=\"" + "handleliste" + "\" method=\"post\">");
		        out.println("  <fieldset>");
		        out.println("    <legend>Legg til</legend>");
		        out.println("    <p>Vare: <input type=\"text\" name=\"vare\" /></p>");
		        out.println("    <p><input type=\"submit\" value=\"Legg til\" /></p>");
		        out.println("  </fieldset>");
		        out.println("</form>");
		        out.println("</div>");
		        
		        out.println("<div class=\"liste\">");
		        out.println("<fieldset >");
		        out.println("    <legend>Legg til</legend>");
		        out.println("    <p>Vare: <input type=\"text\" name=\"vare\" /></p>");
		        out.println("    <p><input type=\"submit\" value=\"Legg til\" /></p>");
		        out.println("</fieldset>");
		        
		        
		        
		        out.println("</div>");
	        
		       out.println("</div>");
		       out.println("</div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
