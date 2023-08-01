package servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletTest
 */
public class HttpServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter
		PrintWriter out = response.getWriter();
		out.println("<html><body bgColor='yellow'>");
		out.println("<h2>Good Morning ya~</h2>");
		out.println("</body></html>");
		
		out.close();
	}

}
