package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context; 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context = getServletContext();
		HttpSession session = request.getSession();
		
		// context, session 값 출력해서 비교 -> 로그아웃이 된 상태
		PrintWriter out = response.getWriter();
		out.println("CONTEXT :: " +  context.getAttribute("context") + "<br>");
		out.println("VO :: " +  session.getAttribute("vo"));
		out.println("<hr>");
		out.println("<a href=index.html>로그인 페이지로 이동</a>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
