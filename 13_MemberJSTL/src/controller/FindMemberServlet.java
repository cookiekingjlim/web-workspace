package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값 가져오기
		String id = request.getParameter("id");
		
		//2. 아이디만 가져오니까 객체 생성 필요없음
		
		//3. DAO와 연결 
//		MemberDAO dao = new MemberDAO();
		try {
			MemberDTO dto = MemberDAO.getInstance()./*dao.*/findByIdMember(id);
			if(dto!=null) {
				request.setAttribute("dto", dto);	//안에서만 처리할 것이기때문에 리퀘스트에만 정보 바인딩
				request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
			} else {
			System.out.println("검색 실패!");
			response.sendRedirect("views/find_fail.jsp");
			}
		} catch (SQLException e) {
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
