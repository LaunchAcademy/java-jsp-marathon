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

@WebServlet(urlPatterns = {"/orders/new", "/orders"})
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher;
    if (req.getServletPath().equals("/orders/new")) {
      dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
      dispatcher.forward(req, resp);
    } else if (req.getServletPath().equals("/orders")) {
      EntityManager em = getEmf().createEntityManager();
      OrdersService ordersService = new OrdersService(em);

      String id = req.getParameter("orderId");
      if (id != null && id != "") {
        Order orderByID = ordersService.findById(Long.parseLong(id));
        req.setAttribute("order", orderByID);
        dispatcher = req.getRequestDispatcher("/views/orders/show.jsp");
        dispatcher.forward(req, resp);
        System.out.println(orderByID);
      } else {
        List<Order> orders = ordersService.findAll();
        System.out.println(orders);
        req.setAttribute("orders", orders);
        dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
        dispatcher.forward(req, resp);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/orders")) {
      Order order = new Order();
      try {
        BeanUtils.populate(order, req.getParameterMap());
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      System.out.println("is gluten free: " + order.getGlutenFree());
      System.out.println("item name: " + order.getItemName());
      System.out.println("item quantity: " + order.getItemQuantity());
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      OrdersService ordersService = new OrdersService(em);
      if (!ordersService.save(order)) {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
      } else {
        resp.sendRedirect("/orders");
      }
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory) this.getServletContext().getAttribute("emf");
  }
}
