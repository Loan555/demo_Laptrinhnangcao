

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionchecking
 */
@WebServlet("/sessionchecking")
public class sessionchecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionchecking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//	    HttpSession session = request.getSession();
//	    String heading;
//	    Integer accessCount =
//	      (Integer)session.getAttribute("accessCount");
//	    if (accessCount == null) {
//	      accessCount = new Integer(0);
//	      heading = "Welcome, Newcomer";
//	    } else {
//	      heading = "Welcome Back";
//	      accessCount = new Integer(accessCount.intValue() + 1);
//	    }
//	    // Integer is an immutable data structure. So, you
//	    // cannot modify the old one in-place. Instead, you
//	    // have to allocate a new one and redo setAttribute.
//	    session.setAttribute("accessCount", accessCount);
//	    PrintWriter out = response.getWriter();
//	    String title = "Session Tracking Example";
//	    String docType =
//	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
//	      "Transitional//EN\">\n";
//	    out.println(docType +
//	                "<HTML>\n" +
//	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
//	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
//	                "<CENTER>\n" +
//	                "<H1>" + heading + "</H1>\n" +
//	                "<H2>Information on Your Session:</H2>\n" +
//	                "<TABLE BORDER=1>\n" +
//	                "<TR BGCOLOR=\"#FFAD00\">\n" +
//	                "  <TH>Info Type<TH>Value\n" +
//	                "<TR>\n" +
//	                "  <TD>ID\n" +
//	                "  <TD>" + session.getId() + "\n" +
//	                "<TR>\n" +
//	                "  <TD>Creation Time\n" +
//	                "  <TD>" +
//	                new Date(session.getCreationTime()) + "\n" +
//	                "<TR>\n" +
//	                "  <TD>Time of Last Access\n" +
//	                "  <TD>" +
//	                new Date(session.getLastAccessedTime()) + "\n" +
//	                "<TR>\n" +
//	                "  <TD>Number of Previous Accesses\n" +
//	                "  <TD>" + accessCount + "\n" +
//	                "</TABLE>\n" +
//	                "</CENTER></BODY></HTML>");
//	}
    
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList previousItems = (ArrayList)session.getAttribute("previousItems");
		if (previousItems == null) {
			previousItems = new ArrayList();
			session.setAttribute("previousItems", previousItems);
			}
		String newItem = request.getParameter("newItem");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Items Purchased";
		String docType =
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		"Transitional//EN\">\n";
		out.println(docType +
		        "<HTML>\n" +
		        "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		        "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		        "<H1>" + title + "</H1>");
		synchronized(previousItems) {
		if (newItem != null) {
		previousItems.add(newItem);
		}
		if (previousItems.size() == 0) {
		out.println("<I>No items</I>");
		} else {
		out.println("<UL>");
		for(int i=0; i<previousItems.size(); i++) {
		  out.println("<LI>" + (String)previousItems.get(i));
		}
		out.println("</UL>");
		}
		}
		out.println("</BODY></HTML>");
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
