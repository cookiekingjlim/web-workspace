package servlet.controller;

public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("idCheck.do")) {
			controller = new IdCheckController();
		}
		
		return controller;
	}
	
}


