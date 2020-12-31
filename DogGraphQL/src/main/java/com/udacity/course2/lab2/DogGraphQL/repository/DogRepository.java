package com.udacity.course2.lab2.DogGraphQL.repository;

import com.udacity.course2.lab2.DogGraphQL.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

//    @Query("select d.breed from Dog d")
//    List<String> getAllBreeds();
//
//    @Query("select d.id, d.breed from Dog d where d.id = :id")
//    String getDogBreedById(Long id);
//
//    @Query("select d.name from Dog d")
//    List<String> getAllNames();

}
