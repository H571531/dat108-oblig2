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

/**
 * Servlet implementation class logginn
 */
@WebServlet(name="Inlogging Servlet", urlPatterns="/logginn")
public class logginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String Passord;
 
	@Override
	public void init() throws ServletException {
		Passord = getServletConfig().getInitParameter("passord");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String feilmelding=ErrorHandler.errorCheck(request.getParameter("error"));
    	
    	response.setContentType("text/html; charset=ISO-8859-1");
    	
	       PrintWriter out = response.getWriter();

	       out.println("<!DOCTYPE html>");
	       out.println("<html>");
	       out.println("<head>");
	       	out.println("<meta charset=\"ISO-8859-1\">");
	       	out.println("<title>Login</title>");
	       	out.println("<link rel=\"stylesheet\" href=\"style.css\">\r\n");
	       out.println("</head>");
	       out.println("<body>");
	       
	       out.println("<div class=\"main\">");
	       out.println("<div class=\"orange\">");
	       
	       out.println("<h1>Velkommen til gruppe 15s fantastiske handleliste</h1>\r\n"); 
	       out.println("<img src=\"BIl.png\">");
	       
	       out.println("<div class=\"loginBoks\">");
	       
	        out.println("<form action=\"" + "logginn" + "\" method=\"post\">");
	        out.println("  <fieldset>");
	        out.println("    <legend>Login</legend>");
	        out.println("<p class=\"error\">"+feilmelding+"</p>");
	        out.println("    <p>Passord: <input type=\"text\" name=\"passord\" /></p>");
	        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
	        out.println("  </fieldset>");
	        out.println("</form>");
	       out.println("</div>");
	        
	       out.println("</div>");
	       out.println("</div>");
	        
	        
	        
	        
	        
	        
	        out.println("</body>");
	        out.println("</html>");
	       
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String gittPassord = request.getParameter("passord");
    	if(!gittPassord.equals(Passord)) {
    		response.sendRedirect("logginn" + "?error=1");
    	}else {
    	HttpSession sesjon = request.getSession(true);
    		if(sesjon!=null) {
    			sesjon.invalidate();
    		}
    	sesjon = request.getSession(true);
    	sesjon.setMaxInactiveInterval(30);
    	
    	sesjon.setAttribute("inlogget", "godkjent");
        // Inn noe kode her i forbindelse med oppretting av sesjonsdata?
    	//sesjon.setAttribute("cart",new Cart());
    	
        response.sendRedirect("handleliste");
    	}

	}
}
