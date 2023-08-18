package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "views/find_fail.jsp";
		
		MemberVO vo = new MemberService().findByIdMember(id);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			path = "views/find_ok.jsp";
		}
		return new ModelAndView(path);
	}

}
