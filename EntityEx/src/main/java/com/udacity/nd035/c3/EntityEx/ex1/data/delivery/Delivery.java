package com.udacity.nd035.c3.EntityEx.ex1.data.delivery;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Delivery {

    @Id
    @GeneratedValue
    Long id;

    @Nationalized
    @Getter @Setter
    private String recipientName;
    @Column(name = "address_full", length = 500)
    @Getter @Setter
    private String address;
    // private LocalDate deliveryDate;
    @Getter @Setter
    private LocalDateTime deliveryTime; // include both Date and Time, no need to add a separated Date field
    @Type(type = "yes_no")
    @Getter @Setter
    private boolean deliveryCompleted;

//    public String getRecipientName() {
//        return recipientName;
//    }
//
//    public void setRecipientName(String recipientName) {
//        this.recipientName = recipientName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public LocalDateTime getDeliveryTime() {
//        return deliveryTime;
//    }
//
//    public void setDeliveryTime(LocalDateTime deliveryTime) {
//        this.deliveryTime = deliveryTime;
//    }
//
//    public boolean isDeliveryCompleted() {
//        return deliveryCompleted;
//    }
//
//    public void setDeliveryCompleted(boolean deliveryCompleted) {
//        this.deliveryCompleted = deliveryCompleted;
//    }
}
