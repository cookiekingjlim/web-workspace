package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 컨텍스트에 담아놓은 값 가져오기
		context = getServletContext();
		String data = (String) context.getAttribute("context");
		out.println("CONTEXT :: " + data + "<br>");
		
		//1. 기존의 세션을 받아온다.
		HttpSession session = request.getSession();
		
		//2. 세션에 바인딩된 값이 있다면 그 값을 찾아온다.
		MemberVO vo = (MemberVO) session.getAttribute("vo");	// 이 값이 없다면 로그인 안된 것, 값이 있으면 로그인 됨
		if(vo!=null) {	// 로그인된 상태
			out.println("VO :: "+ vo);
			out.println("<hr>");
			
			session.setAttribute("PRODUCT", "NOTEBOOK");
			out.println("<a href=CartServlet>CartServlet..</a>");
		} else { // 로그인 실패한 상태
			out.println("session에 바인딩된 객체가 없음..로그인 실패!<br>");
			out.println("<a href=index.html>로그인 페이지로 이동</a>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
