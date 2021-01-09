package com.udacity.nd035.c3.EntityEx.ex2.inventory;

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
    private Long id;

    @Getter @Setter
    @Nationalized
    private String name;

    @Getter @Setter
    @Column(precision = 12, scale = 4)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @Getter @Setter
    private Delivery delivery;

}
