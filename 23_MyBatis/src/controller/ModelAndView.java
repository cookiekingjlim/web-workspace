package controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView() {}
	public ModelAndView(String path) {	// forward 방식!
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) {	// true 같이 넘겨서 sendRedirect 방식
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
	
	
	
}
