package com.udacity.nd035.c3.EntityEx;

import com.udacity.nd035.c3.EntityEx.JPAexercise.PlantRepository;
import com.udacity.nd035.c3.EntityEx.ex2.delivery.Delivery;
import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UnitTestPlantRepository {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PlantRepository plantRepository;

    @Test
    public void testPriceLessThan () {
        Plant plantTestOne = new Plant("Plant a", new BigDecimal("4.99"));
        plantTestOne = testEntityManager.persist(plantTestOne);
        Plant plantTestTwo = new Plant("Plant b", new BigDecimal("5.12"));
        plantTestTwo = testEntityManager.persist(plantTestTwo);
        Plant plantTestThree = new Plant("Plant b", new BigDecimal("3.21"));
        plantTestThree = testEntityManager.persist(plantTestThree);

        List<Plant> cheapPlants = plantRepository.findPlantsByPriceLessThan(BigDecimal.valueOf(5));
        assertEquals(2, cheapPlants.size());
        assertEquals(plantTestOne.getId(), cheapPlants.get(0).getId());
        assertEquals(plantTestThree.getId(), cheapPlants.get(1).getId());
    }

    @Test
    public void testDeliveryCompleted () {
        Plant plant = new Plant("Plant a", BigDecimal.valueOf(4.99));
        Delivery delivery = new Delivery("Custom a", "1 Road", LocalDateTime.now());
        plant = testEntityManager.persist(plant);
        delivery = testEntityManager.persist(delivery);

        plant.setDelivery(delivery);
        delivery.setPlants(Lists.newArrayList(plant));

        assertFalse(plantRepository.isDelivered(plant.getId()));
        delivery.setDeliveryCompleted(true);
        assertTrue(plantRepository.isDelivered(plant.getId()));

    }
}
