package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
         try {
        	 Class.forName("org.mariadb.jdbc.Driver");
 			System.out.println("org.mariadb.jdbc.Driver로딩 성공! <-- DBDriverListener.contextInitialized()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
}
