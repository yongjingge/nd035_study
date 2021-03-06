package com.udacity.nd035.c3.EntityEx.ex2.service;

import com.udacity.nd035.c3.EntityEx.ex2.inventory.CandyData;

import java.util.List;

public interface CandyDAO {

    // get a list of all the available candy
    List<CandyData> getListCandy ();

    // add a candy item to a delivery by id, updated data is added into the candy_delivery table
    void addCandyToDelivery (Long candyId, Long deliveryId);

    // get a list of candy for a specific delivery
    List<CandyData> findCandyByDelivery (Long deliveryId);
}
