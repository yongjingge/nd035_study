package com.udacity.nd035.c3.EntityEx.JPAexercise;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    /**
     * Return the id of a scheduled delivery
     * @param delivery
     * @return
     */
    @PostMapping
    public Long scheduleDelivery (@RequestBody Delivery delivery) {
       return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPriceDTO getBill (@PathVariable("deliveryId") Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}
