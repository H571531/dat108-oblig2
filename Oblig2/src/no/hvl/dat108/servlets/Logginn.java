package no.hvl.dat108.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.kontroll.ErrorHandler;
import no.hvl.dat108.kontroll.HtmlUtils;

/**
 * Servlet implementation class logginn
 */
@WebServlet(name="Inlogging Servlet", urlPatterns="/logginn")
public class Logginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String passord;
    private int timeout;
 
	@Override
	public void init() throws ServletException {
		passord = getServletConfig().getInitParameter("passord");
		timeout = Integer.parseInt(getServletContext().getInitParameter("timeout"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String feilmelding=ErrorHandler.errorCheck(request.getParameter("error"));
    	
    	response.setContentType("text/html; charset=ISO-8859-1");
    	
	       PrintWriter out = response.getWriter();

	       
	       out.println(HtmlUtils.startHTML("Login", ""));
	       
	       out.println("<div class=\"main\">");
	       out.println("<div class=\"orange\">");
	       
	       out.println("	<h1>Velkommen til gruppe 15s fantastiske handleliste</h1>\r\n"); 
	       
	       out.println("	<div class=\"loginBoks\">");
	       
	        out.println("		<form action=\"" + "logginn" + "\" method=\"post\">");
	        out.println("  			<fieldset>");
	        out.println("   			<legend>Login</legend>");
	        out.println("				<p class=\"error\">"+feilmelding+"</p>");
	        out.println("   			<p>Passord: <input type=\"password\" name=\"passord\" /></p>");
	        out.println("    			<p><input type=\"submit\" value=\"Logg inn\" /></p>");
	        out.println("  			</fieldset>");
	        out.println("		</form>");
	       out.println("	</div>");
	        
	       out.println("</div>");
	       out.println("</div>");
	        
	        
	        
	        out.println(HtmlUtils.sluttHTML());
	       
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String gittPassord = request.getParameter("passord");
    	if(!gittPassord.equals(passord)) {
    		response.sendRedirect("logginn" + "?error=1");
    	}else {
    	HttpSession sesjon = request.getSession(false);
    		if(sesjon!=null) {
    			sesjon.invalidate();
    		}
    	sesjon = request.getSession(true);
    	sesjon.setMaxInactiveInterval(timeout);
    	sesjon.setAttribute("inlogget", "godkjent");
    	
        response.sendRedirect("HandlelisteServlet");
    	}

	}
}
