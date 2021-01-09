package com.udacity.nd035.c3.EntityEx.ex2.service;

import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName (String name) {
        return new Plant();
    }
}
