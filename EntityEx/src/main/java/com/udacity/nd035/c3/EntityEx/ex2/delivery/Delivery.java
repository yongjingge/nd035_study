package com.udacity.nd035.c3.EntityEx.ex2.delivery;

import com.udacity.nd035.c3.EntityEx.ex2.inventory.Flower;
import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;
import com.udacity.nd035.c3.EntityEx.ex2.inventory.Shrub;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(
        name = "Delivery.findByName",
        query = "select d from Delivery d where d.recipientName = :recipientName"
)
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Nationalized
    @Getter @Setter
    private String recipientName;

    @Column(name = "address_ful", length = 500)
    @Getter @Setter
    private String address;

    @Getter @Setter
    private LocalDateTime deliveryTime;

    @Type(type = "yes_no")
    @Getter @Setter
    private boolean deliveryCompleted = false;

    // CascadeType.REMOVE -- Repository delete method (for EntityManager.remove)
    // CascadeType.ALL -- to make it easier for us to persist everything at once for testing.
    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Plant> plants;

    // constructor for testing

    public Delivery() {
    }

    public Delivery(String recipientName, String address, LocalDateTime deliveryTime) {
        this.recipientName = recipientName;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }
}
