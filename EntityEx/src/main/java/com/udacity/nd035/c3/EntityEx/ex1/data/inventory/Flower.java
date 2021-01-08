package com.udacity.nd035.c3.EntityEx.ex1.data.inventory;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plant")
public class Flower {

    @Id
    @GeneratedValue
    Long id;

    @Nationalized
    private String name;
    private String color;
    @Column(name = "price", precision = 12, scale = 4)
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
