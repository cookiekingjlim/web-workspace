package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class GenericServlet
 */
public class GenericServletTest extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 클라이언트가 요청을 하면 호출되는 메소드
	 * 이때 클라이언트의 요청 정보를 ServeletRequest 저장
	 * 요청을 수행한 후 응답할 정보를 ServleResponse 저장
	 * */
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Good Morning ya~</h2>");
		out.println("</body></html>");
		
		out.close();
	}

}