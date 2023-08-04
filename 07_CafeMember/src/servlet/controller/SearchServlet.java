package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1. 폼 데이터 받아오기
		String name = request.getParameter("name");
		
//		int age = Integer.parseInt(request.getParameter("age"));
//		String addr = request.getParameter("addr");
		
		//2. DAO한테 넘기기-> DAO리턴 받아서
		MemberDAO dao = new MemberDAO();
		MemberVO vo =null;
		try {
			vo = dao.findByNameMember(name);
		} catch (SQLException e) {}
		
		//3. 멤버 정보 1개 바인딩
		request.setAttribute("vo", vo);
		
		//4. 네비게이션 -> view.jsp
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
