package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리는 양방향 다 설정해줘야함! 여기서 양방향이란 request, response 
		 * */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String result1 = request.getParameter("userId");
		String result2 = request.getParameter("userPwd");
		
		String[] menuList = request.getParameterValues("menu");
		
		String gender = request.getParameter("gender");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>정보를 출력합니다...</h2>");
		out.println("<p>" + "ID: "+result1+" / "+"PASSWORD : "+result2+"</p>");
		
		// 당신의 성별은 => 성별 가져오기
		out.println("<p> 당신의 성별은 : "+ (gender.charAt(0) == 'M'? "남자" : "여자")+"</p>");
		
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		
		out.close();
	}

}
