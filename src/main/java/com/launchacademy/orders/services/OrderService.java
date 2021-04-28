package com.launchacademy.orders.services;

import com.launchacademy.orders.models.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OrderService {
private EntityManager em;

public OrderService(EntityManager em) { this.em=em;}

public boolean save(Order order){
  try {
    em.getTransaction().begin();
    em.persist(order);
    em.getTransaction().commit();
    return true;
  }catch(Exception exc){
    em.getTransaction().rollback();
    return false;
  }
}

public List<Order> findAll() {
  TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
  return query.getResultList();
}

public Order findOne(String orderId) {
  String queryString = "SELECT o from Order o where id = :orderId";
  TypedQuery<Order> query = em.createQuery(queryString, Order.class);
  Order order = null;
  try {
    query.setParameter("orderId" ,Long.parseLong(orderId));
    order = query.getSingleResult();
  } catch (Exception exception) {
    System.out.println("There is no matching record");
  }
  return order;
}

}
