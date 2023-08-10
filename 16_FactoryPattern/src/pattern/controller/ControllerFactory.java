package pattern.controller;

import pattern.controller.component.FindController;

public class ControllerFactory {

	// 하나만 필요하니까 -> 싱글톤 패턴
	
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {}	// 다른 곳에서 생성 못 하게 private으로 생성하고
	public static ControllerFactory getInstance() {	//다른 곳에서 호출할 수 있게끔 getInstance 받음
		return factory;
	}
	
	// createController : 컨트롤러 생성하는 기능
	public Controller createController(String command) {	// 어떤 컨트롤러를 만들거냐
		Controller controller = null;
		
		if(command.equals("findModel")) {	// find_notebook에서 호출한 command
			controller = new FindController();
		}
		return controller;
		
	}
	
}
