package com.launchacademy.orders.controllers;

import com.launchacademy.orders.models.Order;
import com.launchacademy.orders.services.OrderService;
import java.io.IOException;
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
    if (req.getServletPath().equals("/orders/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/new.jsp");
      dispatcher.forward(req, resp);
    } else if ( req.getServletPath().equals("/orders")) {
      EntityManager em = getEmf().createEntityManager();
      try {
        String orderId = req.getParameter("orderId");
        OrderService orderService = new OrderService(em);
        if ( orderId != null && orderId != "" ) {
          Order order = orderService.findOne(orderId);
          if (order != null) {
            req.setAttribute("order", order );
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/show.jsp");
            dispatcher.forward(req, resp);
          } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
          }
        } else {
          req.setAttribute("orders", orderService.findAll());
          RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
          dispatcher.forward(req, resp);
        }
      } finally {
        em.close();
      }
    }
  }


  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getServletPath().equals("/orders")) {
      Order order = new Order();
      try {
        BeanUtils.populate(order, req.getParameterMap());
      } catch (Exception ex) {
        System.out.println("Error: ");
        System.out.println(ex);
      }

      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();

      OrderService service = new OrderService(em);
      if (!service.save(order)) {
        System.out.println("Error saving order: ");
      } else {
        resp.sendRedirect("/orders");
        em.close();
      }
    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }
  private EntityManagerFactory getEmf(){
    return (EntityManagerFactory) this.getServletContext().getAttribute("emf");
  }
}
