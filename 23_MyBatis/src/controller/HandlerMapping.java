package controller;

import controller.component.FindController;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;

		if(command.equals("find.do")) {
			controller = new FindController();
		}
		
		return controller;
	}
}
