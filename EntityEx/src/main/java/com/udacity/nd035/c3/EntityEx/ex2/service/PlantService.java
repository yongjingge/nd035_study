package com.udacity.nd035.c3.EntityEx.ex2.service;

import com.udacity.nd035.c3.EntityEx.JPAexercise.PlantRepository;
import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    // inject an instance of PlantRepository
    @Autowired
    PlantRepository plantRepository;

    // save a new plant and return its id
    public Long save (Plant plant) {
        return plantRepository.save(plant).getId();
    }

    // check if a plant has been delivered
    public Boolean isDelivered (Long plantId) {
        return plantRepository.isDelivered(plantId);
    }

    // find a list of plants cheaper than a specific price
    public List<Plant> plantCheaperThan (BigDecimal price) {
        return plantRepository.findPlantsByPriceLessThan(price);
    }

    public Plant getPlantByName (String name) {
        return new Plant();
    }
}
