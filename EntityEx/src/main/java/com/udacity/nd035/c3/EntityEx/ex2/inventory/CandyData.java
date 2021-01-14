package com.udacity.nd035.c3.EntityEx.ex2.inventory;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * maps directly to the 'candy' table in 'schema.sql'
 */
@Getter @Setter
public class CandyData {

    private Long id;
    private String name;
    private BigDecimal price;

}
