package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;
import servlet.model.vo.MemberVO;


// 13프로젝트의 컨트롤러 변경
@WebServlet(urlPatterns="/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지.. command 값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		try {
			if(command.equals("register")) {
			path = register(request,response);  // register메소드 호출
			} else if(command.equals("allMember")) {
			path = allMember(request,response);
			} else if(command.equals("search")) {
			path = search(request,response);
			} else if(command.equals("Login")) {
			path = Login(request,response);
			} else if(command.equals("update")) {
			path = Update(request,response);
			} else if(command.equals("Logout")) {
				path = Logout(request,response);
			}
		} catch (SQLException e) {}	
			
		// 네비게이션은 앞으로 forward만 사용함
		request.getRequestDispatcher(path).forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//1. 폼값 가져오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//2. 객체 생성 -> 폼값 담기 
		MemberVO vo = new MemberVO(id,password,name,address);
		
			
		//3. DAO와 연결
		MemberDAO.getInstance().registerMember(vo);
			
		//4. 데이터 바인딩->생략 회원가입 후 바로 메인페이지로 넘기기 위해
//		HttpSession session = request.getSession();
//		session.setAttribute("vo", vo);
			
		//5. 네비게이션
	
		return "index.jsp";	// index.jsp로 이동하겠다
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
			ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
			request.setAttribute("list", list);  	// AllMember서블릿만 불러오면 되니까 request에 바인딩, 세션이 너무 많은 것도 안 좋아 
			
			return "views/allShow.jsp";
	}
	protected String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//1. 폼값 가져오기
		String id = request.getParameter("id");
		
		//2. 아이디만 가져오니까 객체 생성 필요없음
		
		//3. DAO와 연결 
//		MemberDAO dao = new MemberDAO();
			MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);	//안에서만 처리할 것이기때문에 리퀘스트에만 정보 바인딩
				return "views/find_ok.jsp";
			} else {
				System.out.println("검색에 실패했습니다.");
			}
		
		return "views/find_fail.jsp";
	}
	
	protected String Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//1. 폼 값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. 객체 담을 필요없음=>생략
		
			//3. DAO 연결
			MemberVO vo = MemberDAO.getInstance().login(id, password);
			
			//4. 데이터 바인딩 -> session
			HttpSession session = request.getSession();
			
			if(vo!=null) {
			session.setAttribute("vo", vo);
			}
		// 5. 네비게이션
		return "views/login_result.jsp";
	}
	
	protected String Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		MemberVO vo = new MemberVO(id,password,name,address);
		MemberDAO.getInstance().updateMember(vo);
			
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
		session.setAttribute("vo", vo);
		return "views/update_result.jsp";
		}
			
		return "index.jsp";
	}
	
	protected String Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "views/Logout.jsp";
		}
		return "index.jsp";
	}		
}


















