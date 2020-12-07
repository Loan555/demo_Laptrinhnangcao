

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class sevlet_cookies
 */
@WebServlet("/sevlet_cookies")
public class sevlet_cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sevlet_cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean newbie = true;
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	      for(int i=0; i<cookies.length; i++) {
	        Cookie c = cookies[i];
	        if ((c.getName().equals("repeatVisitor")) &&
	            // Could omit test and treat cookie name as a flag
	            (c.getValue().equals("yes"))) {
	          newbie = false;
	          break;
	        }
	      }
	    }
	    String title;
	    if (newbie) {
	      Cookie returnVisitorCookie =
	        new Cookie("repeatVisitor", "yes");
	      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
	      response.addCookie(returnVisitorCookie);
	      title = "Welcome Aboard";
	    } else {
	      title = "Welcome Back";
	    }
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    out.println(docType +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	                "</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
