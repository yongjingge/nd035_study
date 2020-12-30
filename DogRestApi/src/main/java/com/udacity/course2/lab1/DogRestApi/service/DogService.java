package com.udacity.course2.lab1.DogRestApi.service;

import com.udacity.course2.lab1.DogRestApi.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> getDogs();
    List<String> getAllBreeds();
    String getDogBreedById(Long id);
    List<String> getAllNames();

}
