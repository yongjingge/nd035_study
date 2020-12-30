package com.udacity.course2.lab1.DogRestApi.service;

import com.udacity.course2.lab1.DogRestApi.entity.Dog;
import com.udacity.course2.lab1.DogRestApi.exception.DogNotFoundException;
import com.udacity.course2.lab1.DogRestApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> getDogs () {
        return (List<Dog>)dogRepository.findAll();
    }

    public List<String> getAllBreeds () {
        return (List<String>)dogRepository.getAllBreeds();
    }

    public String getDogBreedById (Long id) {
//        return (String)dogRepository.getDogBreedById(id);

        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.getDogBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    public List<String> getAllNames () {
        return (List<String>)dogRepository.getAllNames();
    }


}
