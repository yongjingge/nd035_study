package com.udacity.nd035.c3.EntityEx.JPAexercise1;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;

public interface DeliveryRepositoryInterface {

    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);

}
