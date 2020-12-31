package com.udacity.course2.lab2.DogGraphQL.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.course2.lab2.DogGraphQL.entity.Dog;
import com.udacity.course2.lab2.DogGraphQL.exception.BreedNotFoundException;
import com.udacity.course2.lab2.DogGraphQL.exception.DogNotFoundException;
import com.udacity.course2.lab2.DogGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed (String breed) {
        Iterable<Dog> allDogs = dogRepository.findAll();
        boolean isDeleted = false;
        for (Dog targetDog : allDogs) {
            if (targetDog.getBreed().equals(breed)) {
                dogRepository.deleteById(targetDog.getId());
                isDeleted = true;
            }
        }
        if (! isDeleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return isDeleted;
    }

    public Dog updateDogName (String newname, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog targetDog = optionalDog.get();
            targetDog.setName(newname);
            dogRepository.save(targetDog);
            return targetDog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
