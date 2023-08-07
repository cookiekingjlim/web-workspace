package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 쿠키는 문자열만 받을 수 있고, 세션은 객체를 받을 수 있음 + 보안도 높음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션을 하나 받아온다..request.getSession()
		HttpSession session = request.getSession();	// 클라이언트가 서버에 요청하는 순간 무조건 만들어짐 => 바로 get으로 가져옴
		
		//2. 폼에 입력된 값을 가지고 객체 생성..MemberVo(DAO 생략됨)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO vo = new MemberVO(id, password, "제이림","경기도 성남시");
		
		//3. 세션에 바인딩
		session.setAttribute("vo", vo);	// 쿠키와 달리 객체에 담길 수 있음
		
		//4. 네비게이션
		PrintWriter out = response.getWriter();
		out.println("<a href=ProductServlet>ProductServlet...</a>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
