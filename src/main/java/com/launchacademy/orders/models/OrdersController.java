package com.launchacademy.orders.models;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/", "/orders/new", "/orders"})
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/orders/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
      dispatcher.forward(req, resp);
    } else if (req.getParameter("orderId") != null && req.getParameter("orderId") != "") {
      EntityManager em = getEmf().createEntityManager();
      OrderService orderService = new OrderService(em);
      Order thisOrder = orderService.findOne(Long.parseLong(req.getParameter("orderId")));
      req.setAttribute("order",thisOrder);
      RequestDispatcher dispatcher  =req.getRequestDispatcher("/views/orders/show.jsp");
      dispatcher.forward(req, resp);
      em.close();

    } else if (req.getServletPath().equals("/orders")) {
      EntityManager em = getEmf().createEntityManager();
      OrderService orderService = new OrderService(em);
      List<Order> toCall = orderService.findAll();
      req.setAttribute("orders", toCall);
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
      dispatcher.forward(req, resp);
      em.close();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/orders")) {
      Order order = new Order();

      try {
        BeanUtils.populate(order, req.getParameterMap());
      } catch (IllegalAccessException | InvocationTargetException e) {
        System.out.println(e);
      }

      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();

      OrderService service = new OrderService(em);

      if (!service.save(order)) {
        System.out.println("Not saved buddy");
      }

      resp.sendRedirect("/orders");
      em.close();
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory) this.getServletContext().getAttribute("emf");
  }

}
