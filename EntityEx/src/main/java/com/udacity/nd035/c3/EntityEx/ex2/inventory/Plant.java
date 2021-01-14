package com.udacity.nd035.c3.EntityEx.ex2.inventory;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.nd035.c3.EntityEx.ex2.controller.Views;
import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// use InheritanceType.JOINED to stored shared fields in parent class Plant and unique ones in subclasses (Flower & Shrub)
public class Plant {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Nationalized
    @JsonView(Views.class)
    private String name;

    @Getter @Setter
    @Column(precision = 12, scale = 4)
    @JsonView(Views.class)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    @Getter @Setter
    private Delivery delivery;

    // constructor for testing
    public Plant(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Plant() {
    }

    public Plant(String name, BigDecimal price, Delivery delivery) {
        this.name = name;
        this.price = price;
        this.delivery = delivery;
    }
}
