package member.controller;

import member.controller.component.AllMemberController;
import member.controller.component.FindController;
import member.controller.component.LoginController;
import member.controller.component.LogoutController;
import member.controller.component.RegisterController;
import member.controller.component.UpdateController;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
//		System.out.println("adsads");
		if(command.equals("find.do")) {
			controller = new FindController();
		} else if(command.equals("register.do")) {
//			System.out.println("adsads");
			controller = new RegisterController();
		} else if(command.equals("login.do")) {
			System.out.println("adsads");
			controller = new LoginController();
		} else if(command.equals("update.do")) {
			controller = new UpdateController();
		} else if(command.equals("allMember.do")) {
			controller = new AllMemberController();
		} else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}
		
		return controller;
	}
}
