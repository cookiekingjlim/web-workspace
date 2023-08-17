package controller.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller{
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int itemId = Integer.parseInt(request.getParameter("id"));	//1-1. 아이디 받아오는 걸 확인했으니 여기서 지정
		
		//조회수 카운트
		ItemDAO.getInstance().updateRecordCount(itemId);
		
		Item item = ItemDAO.getInstance().getItem(itemId);	// 사진 가져오기 위해
		
		request.setAttribute("item", item);
		
		//  한 번이라도 클릭했을 시 -> 쿠키는 여기 넣어야 함
		// 오늘 본 상품 정보를 저장하는 쿠키 로직
		
		//1. 쿠키 생성, 쿠키 보여질 때 사진이 보여짐
		Cookie cookie = new Cookie("fruit-" + itemId, item.getPictureUrl());	// 키: 구분지을 수 있는 것, 여기서는 id로 받음 -> 아이디가 숫자이므로 
		cookie.setMaxAge(24*60*60); //하룻동안 지정
	
		//2. 생성한 쿠키를 웹브라우저로 보내는 역할
		response.addCookie(cookie); 	// 응답할 때 방금 만든 쿠키 저장
		return new ModelAndView("itemView.jsp");
	}

}
