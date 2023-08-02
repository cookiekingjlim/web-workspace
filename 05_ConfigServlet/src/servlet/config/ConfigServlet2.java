package servlet.config;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigServlet2
 */
public class ConfigServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 1. ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다.
		// 2. BufferedReader, FileReader를 사용해서 파일을 읽어들인다.
		// 3. count값으로 필드 초기화
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 4. PrintWriter, FileWriter를 사용해서 count값 저장
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 5. 폼에 입력된 값을 받아서
		//   ~~아무개 님은 ~ 몇번째 입장하신 고객입니다...
		// 를 브라우저로 출력 (이때 출력은 config2.jsp에서)
	}

}
