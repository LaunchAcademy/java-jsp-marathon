package com.launchacademy.orders.controllers;

import com.launchacademy.orders.services.Service;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.launchacademy.orders.models.Order;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/orders/new", "/orders"})
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    if (req.getServletPath().equals("/orders/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/form.jsp");
      dispatcher.forward(req, resp);
    } else if (req.getServletPath().equals("/orders")){
      EntityManager em = getEmf().createEntityManager();
    try {
      Service service = new Service(em);
      List<Order> orders = service.findAll();
      req.setAttribute("orderList", orders);
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
      dispatcher.forward(req, resp);
    } finally {
      em.close();
    }
    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletPath().equals("/orders")) {
      Order order = new Order();
      try {
        BeanUtils.populate(order, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }

      EntityManager em = getEmf().createEntityManager();

      Service service = new Service(em);
      if (!service.save(order)) {
        System.out.println("Order did not save");
      }

      resp.sendRedirect("/orders/new");
      em.close();
    }
      else {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
      }
    }

  private EntityManagerFactory getEmf(){
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }
}
