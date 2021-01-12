package com.udacity.nd035.c3.EntityEx.ex2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;
import com.udacity.nd035.c3.EntityEx.ex2.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // returns a PlantDTO that includes only price and name
    public PlantDTO getPlantDTO (String name) {
        return convertEntityToPlantDTO(plantService.getPlantByName(name));
//        Plant plant = plantService.getPlantByName(name);
//        return null;
    }

    // returns a Plant Entity instance
    @JsonView(Views.class)
    public Plant getFilterPlant (String name) {
        return plantService.getPlantByName(name);
    }

    // conversion methods
    private static PlantDTO convertEntityToPlantDTO (Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    private static Plant convertPlantDTOToEntity (PlantDTO plantDTO) {
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDTO, plant);
        return plant;
    }

    @GetMapping("/delivered/{plantId}")
    public Boolean isDelivered (@PathVariable("plantId") Long plantId) {
        return plantService.isDelivered(plantId);
    }

    @GetMapping("/lessthan/{price}")
    @JsonView(Views.class)
    public List<Plant> getPlantsPriceLessThan (@PathVariable("price") BigDecimal price) {
        return plantService.plantCheaperThan(price);
    }
}
