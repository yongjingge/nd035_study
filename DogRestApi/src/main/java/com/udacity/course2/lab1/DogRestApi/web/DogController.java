package com.udacity.course2.lab1.DogRestApi.web;

import com.udacity.course2.lab1.DogRestApi.entity.Dog;
import com.udacity.course2.lab1.DogRestApi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(code = 500, message = "The server is down. Please make sure that the Location microservice is running.")
})
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService (DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs () {
        List<Dog> res = dogService.getDogs();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllBreeds () {
        List<String> res = dogService.getAllBreeds();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getAllNames () {
        List<String> res = dogService.getAllNames();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getDogBreedById (@PathVariable("id") Long id) {
        String res = dogService.getDogBreedById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
