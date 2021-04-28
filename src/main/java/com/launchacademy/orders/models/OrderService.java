package com.launchacademy.orders.models;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OrderService {
  private EntityManager em;

  public OrderService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Order order) {
    try {
      em.getTransaction().begin();
      em.persist(order);
      em.getTransaction().commit();
      return true;
    } catch(Exception e) {
      em.getTransaction().rollback();
      System.out.println(e.getMessage());
      return false;
    }
  }

  public List<Order> findAll() {
    TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
    return query.getResultList();
  }

  public Order findOne(Long id) {
    TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE id = :id", Order.class);
    query.setParameter("id", id);
    return query.getSingleResult();

  }

}
