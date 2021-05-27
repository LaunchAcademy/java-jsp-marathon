import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OrderService {
  private EntityManager em;

  public OrderService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Order newOrder){
    try {
      em.getTransaction().begin();
      em.persist(newOrder);
      em.getTransaction().commit();
      return true;
    } catch (Exception err) {
      System.out.println(err.getStackTrace());
      em.getTransaction().rollback();
      return false;
    }
  }

  public List<Order> findAll() {
    TypedQuery<Order> query = em.createQuery("FROM Order", Order.class);
//    TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
    return query.getResultList();
  }

}
