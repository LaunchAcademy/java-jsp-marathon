import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EMFListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent event) {
    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.launchacademy.bakery");

    event.getServletContext().setAttribute("emf", emf);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    EntityManagerFactory emf = (EntityManagerFactory)event.getServletContext().getAttribute("emf");
    if(emf != null) {
      emf.close();
    }
  }
}
