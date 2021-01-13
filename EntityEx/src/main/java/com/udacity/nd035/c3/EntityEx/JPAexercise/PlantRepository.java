package com.udacity.nd035.c3.EntityEx.JPAexercise;

import com.udacity.nd035.c3.EntityEx.ex2.inventory.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    // provide specific JPQL Queries
    @Query("select p.delivery.deliveryCompleted from Plant p where p.id = :plantId")
    Boolean isDelivered (Long plantId);

    // above can also be written in this way
    // in the plantService, it will be referenced like [return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);]
    // Boolean existsPlantByIdAndDeliveryCompleted (Long id, Boolean delivered);

    // referencing associations and attributes by chaining
    List<Plant> findPlantsByPriceLessThan (BigDecimal price);
}
