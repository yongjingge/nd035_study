package com.udacity.nd035.c3.EntityEx.ex2.inventory;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Flower extends Plant {

    @Getter @Setter
    private String color;

}
