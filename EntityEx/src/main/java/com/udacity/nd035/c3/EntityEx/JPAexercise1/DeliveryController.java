package com.udacity.nd035.c3.EntityEx.JPAexercise1;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
