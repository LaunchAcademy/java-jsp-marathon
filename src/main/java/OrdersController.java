import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/orders/new", "/orders"} )
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if(req.getServletPath().equals("/orders/new")) {
      // show the form
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
      dispatcher.forward(req, resp);
    } else if(req.getServletPath().equals("/orders")) {
      // show the index page
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");

      // hand the view a list of all orders (using OrderService)
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      OrderService service = new OrderService(em);

      List<Order> orders = service.findAll();
      req.setAttribute("orders", orders);

      em.close();
      dispatcher.forward(req, resp);
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/orders")) {
//      EntityManagerFactory emf = getEmf();
//      EntityManager em = emf.createEntityManager();
      EntityManager em = getEmf().createEntityManager();
      OrderService orderService = new OrderService(em);

      Order newOrder = new Order();
      try {
        System.out.println(req.getParameterMap());
        BeanUtils.populate(newOrder, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
//      if (!orderService.save(newOrder)) {
//        System.out.println("Error in Save!!!");
////        resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
//        dispatcher.forward(req, resp);
//      } else {
//        resp.sendRedirect("/orders");
//      }
      if (!orderService.save(newOrder)) {
        System.out.println("Error in Save!!!");
      } else {
        System.out.println("Saved successfully!");
      }
      em.close();
      resp.sendRedirect("/orders");
    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }


  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }

}
