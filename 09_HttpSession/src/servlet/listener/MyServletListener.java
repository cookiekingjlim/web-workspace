package servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletListener implements ServletContextListener {
	
	private ServletContext context;

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("contexstDestroyed....");
    }
    
    // dd(web.xml) 읽고 -> SevletContext를 생성한다 -> SevletContextEvent 발생! -> 리스너 감지 -> 호출
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("contextInitialized...");
    	
    	// sce에서 ServletContext를 받아온다.
    	context = sce.getServletContext();
    	context.setAttribute("context", "contextData..01");
    }
	
}
