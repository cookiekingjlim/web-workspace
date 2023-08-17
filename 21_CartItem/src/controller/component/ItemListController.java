package controller.component;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemListController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Item> list = ItemDAO.getInstance().getAllItem();
		request.setAttribute("list", list);	// 리스트 받아서 전달한 것
		
		// '오늘 본 상품들' -> 저장된 쿠키 받아오기
		// 쿠키 정보 받아오는 로직
		
		ArrayList<String> fruits = new ArrayList<>(); // 이미지 담을 배열
		
		Cookie[] cs = request.getCookies();
		
		if(cs != null) {
			for(Cookie c : cs) {
				if(c.getName().startsWith("fruit-")) {
					fruits.add(c.getValue());	// c.getValue() = 이미지값
				}
			}
		}
		request.setAttribute("fruits", fruits); // JSP에서 fruits 사용하기 위해 바인딩
	
		return new ModelAndView("itemList.jsp");
	}

}
