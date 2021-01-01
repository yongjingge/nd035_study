package com.udacity.course2.DogMicroservice.DogMicroservice.repository;

import com.udacity.course2.DogMicroservice.DogMicroservice.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
