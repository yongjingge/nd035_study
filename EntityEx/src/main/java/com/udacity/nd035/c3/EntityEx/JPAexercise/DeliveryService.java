package com.udacity.nd035.c3.EntityEx.JPAexercise;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save (Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPriceDTO getBill (Long deliveryId) {
        return deliveryRepository.findRecipientNameAndPrice(deliveryId);
    }
}
