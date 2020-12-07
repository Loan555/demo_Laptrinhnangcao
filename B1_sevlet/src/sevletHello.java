

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sevletHello
 */
@WebServlet("/sevletHello")
public class sevletHello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sevletHello() {
        super();
        // TODO Auto-generated constructor stub
    }
    private long modTime;
    private int[] numbers = new int[10];
    public void init() throws ServletException {
        // Round to nearest second (i.e., 1000 milliseconds)
        modTime = System.currentTimeMillis()/1000*1000;
        for(int i=0; i<numbers.length; i++) {
          numbers[i] = randomNum();
        }
      }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    response.getWriter().append("Served at: ").append(request.getContextPath());
	    
		String docType =
			      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			      "Transitional//EN\">\n";
			    out.println(docType +
			                "<HTML>\n" +
			                "<HEAD><TITLE>Nguyen Thi Loan</TITLE></HEAD>\n" +
			                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
			                "<H1>Nguyen Thi Loan</H1>\n" +
			                //"<LI>get paramater = " + request.getParameter("param1") + " - "+ request.getParameter("param2")+ " - "+ request.getParameter("param3")+
			                "<H1 ALIGN=CENTER> Get all paramater </H1>\n" +
			                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
			                "<TR BGCOLOR=\"#FFAD00\">\n" +
			                "<TH>Parameter Name<TH>Parameter Value(s)");
			    Enumeration paramNames = request.getParameterNames();
			    while(paramNames.hasMoreElements()) {
			      String paramName = (String)paramNames.nextElement();
			      out.print("<TR><TD>" + paramName + "\n<TD>");
			      String[] paramValues =
			        request.getParameterValues(paramName);
								      
			      if (paramValues.length == 1) {
			        String paramValue = paramValues[0];
			        if (paramValue.length() == 0)
			          out.println("<I>No Value</I>");
			        else
			          out.println(paramValue);
			      } else {
			        out.println("<UL>");
			        for(int i=0; i<paramValues.length; i++) {
			          out.println("<LI>" + paramValues[i]);
			        }
			        out.println("</UL>");
			      }
			    }
			    out.println("</TABLE>\n</BODY></HTML>");
			  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public long getLastModified(HttpServletRequest request) {
	    return(modTime);
	  }

	  // A random int from 0 to 99.

	  private int randomNum() {
	    return((int)(Math.random() * 100));
	  }

}
