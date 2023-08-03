package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	// jsp로 보내면서 ViewServlet은 아예 필요없음!

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet 방식으로 받아도 동일
		
//		 =>1.쪼개기 공통적인 것 필터로 보냄
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
		
//		=>2.쪼개기 모델 만들면서 이제 필요없음
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String addr = request.getParameter("addr");

		
		/*
		 * 1. Attribute에 바인딩된 데이터를 받아와서
		 * 2. 웹브라우저로 출력하는 로직을 작성
		 * */
		
		//1. Attribute에 바인딩된 데이터를 받아와서
//		context = getServletContext();
//		MemberVO vo = (MemberVO) context.getAttribute("vo"); // => RegisterServlet에서 객체에 담았으니까 // 리턴값 객체Object이므로 context 앞 (MemberVO)는 형변환임
		
		//2. 웹브라우저로 출력하는 로직을 작성 => jsp로 출력하므로 PrintWriter랑 작별
//		PrintWriter out = response.getWriter();
//		
//		out.println("<h2>회원님의 정보를 출력합니다..</h2>");
//		out.println("<p> 이름 : "+vo.getName() +" / 나이 : "+ vo.getAge() +" / 주소 : "+ vo.getAddr() +"</p>");
//		
		
	}

}


 