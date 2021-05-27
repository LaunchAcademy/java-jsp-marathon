import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OrdersService {
  private EntityManager em;

  public OrdersService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Order order) {
    try {
      em.getTransaction().begin();
      em.persist(order);
      em.getTransaction().commit();
      return true;
    } catch(Exception exception) {
      em.getTransaction().rollback();
      return false;
    } finally {
      em.close();
    }
  }

  public List<Order> findAll(){
    TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
    List<Order> orders = query.getResultList();
    em.close();
    return orders;
  }

  public Order findById(Long id) {
    TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE id = :id", Order.class);
    query.setParameter("id", id);
    List<Order> result = query.getResultList();
    if (result.size() > 0) {
      return result.get(0);
    } else {
      return null;
    }
  }
}
