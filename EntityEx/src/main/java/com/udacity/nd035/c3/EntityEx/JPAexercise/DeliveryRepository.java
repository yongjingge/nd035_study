package com.udacity.nd035.c3.EntityEx.JPAexercise;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    // use CriteriaBuilder for query
    public RecipientAndPriceDTO findRecipientNameAndPrice (Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // creating a CriteriaQuery for returning a RecipientAndPriceDTO object
        CriteriaQuery<RecipientAndPriceDTO> criteria = criteriaBuilder.createQuery(RecipientAndPriceDTO.class);
        // get price and delivery_id from Plant.class, setting root as from Plant
        Root<Plant> root = criteria.from(Plant.class);

        criteria.select(
                criteriaBuilder.construct(
                        RecipientAndPriceDTO.class,
                        // get Plant.getDelivery().getId()
                        root.get("delivery").get("recipientName"),
                        criteriaBuilder.sum(root.get("price"))
                )
        ).where(criteriaBuilder.equal(root.get("delivery").get("id"), id));

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
