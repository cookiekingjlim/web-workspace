package pattern.action;

public class DeleteAction implements Action {

	@Override
	public void execute() {
		/*
		 * 1. 폼값 받고
		 * 2. DAO 리턴 받고
		 * 3. path를 최종적으로 리턴(네비게이션)
		 * */
		System.out.println("DELETE OK!");
	}

}
