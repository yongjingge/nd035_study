package com.udacity.nd035.c3.EntityEx.JPAexercise;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * projection class
 */
@Getter @Setter
public class RecipientAndPriceDTO {

    private String recipientName;
    private BigDecimal price;

}
