package com.udacity.nd035.c3.EntityEx.ex1.data.inventory;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plant")
public class FlowerEntityEx1 {

    @Id
    @GeneratedValue
    Long id;

    @Nationalized
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String color;
    @Column(name = "price", precision = 12, scale = 4)
    @Getter @Setter
    private BigDecimal price;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
}
