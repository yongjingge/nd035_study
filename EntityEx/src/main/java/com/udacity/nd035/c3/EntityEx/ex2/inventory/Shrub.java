package com.udacity.nd035.c3.EntityEx.ex2.inventory;

import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
public class Shrub extends Plant {

    private Integer height;
    private Integer weight;

}
