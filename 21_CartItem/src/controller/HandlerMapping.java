package controller;

import controller.component.ItemListController;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("")) {
			controller = new ItemListController();
		}
		
		return controller;
	}
}
