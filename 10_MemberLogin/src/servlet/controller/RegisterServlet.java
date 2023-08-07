package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//1. 폼값 가져오기
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	
	//2. 객체 생성 -> 폼값 담기 // dto 이므로 set으로 받아와
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	dto.setPassword(password);
	dto.setName(name);
	dto.setAddress(address);
	
	try {
		
		//3. DAO와 연결
		MemberDAO dao = new MemberDAO();
	
		dao.registerMember(dto);
		
		//4. 데이터 바인딩
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		
		//5. 네비게이션
		response.sendRedirect("AllMemberServlet");
	} catch (SQLException e) {
		System.out.println("회원가입 실패!");
		response.sendRedirect("../index.jsp");
	}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
