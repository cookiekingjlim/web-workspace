package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 양방향 한글처리 => 필터로 보냄
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 로직은 여기서 작성
		
		//2. 폼값 받아서
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		
		//3+ vo 객체 생성
		MemberVO vo = new MemberVO(name,age,addr);
		
		//4+ 객체바인딩..ServletContext에
		context = getServletContext();
		context.setAttribute("vo", vo); // => vo객체를 ServletContext에 넣은 것
		
		//3->5. ViewServlet (경로 view)한테 결과(이름, 나이, 주소) 출력
		PrintWriter out = response.getWriter();
		
		// a링크로 ViewServlet 결과 확인하러 가기 => model로 보냄
//		out.println("<a href=view?name="+name+"&age="+age+"&addr="+addr+">ViewServlet 결과 확인하러 가기</a>");
//		out.println("<a href='view'>ViewServlet 결과 확인하러 가기");		=> jsp로 보내
		out.println("<a href='result.jsp'>결과 확인하러 가기");
		
		out.close();
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
