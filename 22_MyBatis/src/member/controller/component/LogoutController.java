package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			path = "views/Logout.jsp";
		}
		
		return new ModelAndView(path);
	}

}
