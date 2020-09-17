package com.launchacademy.orders.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.launchacademy.orders.models.Order;
import javax.persistence.TypedQuery;

public class Service {
  private EntityManager em;

  public Service(EntityManager em ){
    this.em = em;
  }

  public boolean save(Order order) {
    try {
      System.out.println(order);
      em.getTransaction().begin();
      em.persist(order);

      em.getTransaction().commit();
      return true;
    } catch (Exception exception){
      em.getTransaction().rollback();
      return false;
    }
  }

  public List<Order> findAll() {
    TypedQuery<Order> query = em.createQuery("Select o from Order o", Order.class);
    return query.getResultList();
  }

}
