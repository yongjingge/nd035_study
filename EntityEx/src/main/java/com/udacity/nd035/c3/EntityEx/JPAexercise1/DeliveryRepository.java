package com.udacity.nd035.c3.EntityEx.JPAexercise1;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository implements DeliveryRepositoryInterface {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find (Long id) {
        Delivery target = entityManager.find(Delivery.class, id);
        return target;
    }

    public Delivery merge (Delivery delivery) {
        // the parameter 'delivery' is in its detached state
        Delivery target = entityManager.merge(delivery);
        return target;
    }

    public void delete (Long id) {
        Delivery target = entityManager.find(Delivery.class, id);
        entityManager.remove(target);
    }

    // using the NameQuery annotation for query
    public List<Delivery> getDeliveriesByName (String name) {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("recipientName", name);
        return query.getResultList();
    }

}
