package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class AllMemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "views/allShow.jsp";
		List<MemberVO> list =new MemberService().showAllMember();
		request.setAttribute("list", list);
		
		return new ModelAndView(path);
	}

}
