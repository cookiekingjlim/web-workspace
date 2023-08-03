package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/*
 * 회원가입하면 정보를 바탕으로
 * MemberVO를 생성, ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩 -> 한 번만 하면 되니까 init!
 * 출력 결과는 viewMember.jsp 페이지에서
 * */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());

	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();	// 여기서는 가지고 있기때문에 config 명시해야함
//		context.setAttribute("list", list);
//		여기 가지고 있으면 누구나 볼 수 있으므로 38행으로
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", list);
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("name");
		int age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		String addr = request.getParameter("addr");
		System.out.println("1. 폼값을 받아옵니다..");
		
		if(name!=null) {
			MemberVO vo = new MemberVO(name, age, addr);
			list.add(vo);
		}
			System.out.println("2. MemxberVO 생성합니다..");
			System.out.println("3. MemberVO를 List에 저장합니다..");
		
//		PrintWriter out = response.getWriter();
//		=> 다른 페이지로 이동하는 걸 Navigation
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");	//설정
		rdp.forward(request, response); // 위에 설정한 페이지로 이동
		
//		out.println("<a href='viewMember.jsp'>결과 확인하러 가기");
//		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
