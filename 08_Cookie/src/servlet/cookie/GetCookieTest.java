package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 클라이언트가 다시 요청할 때 브라우저에 저장된 쿠키들을 받아온다.
		 * 받아온 쿠키 중에서 쿠키의 값과 이름을 출력해준다.
		 * */
		PrintWriter out = response.getWriter();
		out.println("<h2>SetCookieTest에서 설정한 쿠키의 정보를 받아온다...</h2>");
		Cookie[] cs = request.getCookies();	// getCookies가 배열로 받아옴
		
		for(Cookie c : cs) {
			out.println(c.getName() + "----" + c.getValue() + "<br>");
		}
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
