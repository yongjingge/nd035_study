package com.udacity.nd035.c3.EntityEx.JPAexercise1;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class RecipientAndPriceDTO {

    private String recipientName;
    private BigDecimal price;

}
