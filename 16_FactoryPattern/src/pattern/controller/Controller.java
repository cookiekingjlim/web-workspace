package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {	//Action에 해당함, 틀이니까 interface
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception;	//실행하는 메소드 하나만 있으면 됨
}
