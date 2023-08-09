package client;

import pattern.action.Action;
import pattern.factory.ActionFactory;

public class DispatcherMainTest {
	/*
	 * Factory Method Pattern
	 * 	: 추상화된 클래스(Action)의 객체(실체 클래스)를 생성하고 반환하는 방법
	 * 
	 * 1) 구상 객체를 실질적으로 생성하는 곳은 싱글톤 패턴으로 작성된 Factory에서 진행된다.
	 * 	  이때 인자값으로 넘겨져오는 command값에 따라서 서로 각각 다른 구상 객체가 만들어진다.
	 * 	  하지만 정작 사용자에게는 구상객체명이 hiding 돼서 넘겨진다.
	 * 	   		--> 추상화된 클래스(Action)으로 날라간다.
	 * 			--> 결국 클라이언트는 Factory로 하여금 구상 객체르 만들도록 요청하는 것이고, 
	 * 				Factory는 요청에 해당하는 제품을 만들고 인터페이스로 전달한다.
	 * 2) 인터페이스의 메소드를 호출하면 실질적으로 생성된 구상객체가 드디어 핵심적인 일(비지니스 로직 호출)을 진행
	 * 	  최종적으로 뷰의 화면의 경로를 리턴 받는다.
	 * 
	 * 	  리턴 받는 방식: forward or sendRedirect로 응답
	 * */
	public static void main(String[] args) {
		String command = "INSERT";
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.createAction(command);
		
		action.execute();
	}

}
