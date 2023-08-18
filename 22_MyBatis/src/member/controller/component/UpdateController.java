package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "index.jsp";
		
		MemberVO vo = new MemberVO(id,password,name,address);
		new MemberService().updateMember(vo);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
		session.setAttribute("vo", vo);
		path = "views/update_result.jsp";
		}
		return new ModelAndView(path);
	}

}
