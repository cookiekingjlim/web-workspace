package pattern.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commnad = request.getParameter("command");	
		String path = "index.jsp";
		
		// Factory Pattern -> 공장을 만들고 실행에 해당하는 게 여기
		// 커맨드에 따라 컨트롤러에 담아
		Controller controller = ControllerFactory.getInstance().createController(commnad);
		try {
			path = controller.execute(request, response);
		} catch (Exception e) {}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
