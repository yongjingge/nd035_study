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

@Entity
public class Delivery {

    @Id
    @GeneratedValue
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
    private boolean deliveryCompleted;

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY)
    @Getter @Setter
    private List<Plant> plants;
}
