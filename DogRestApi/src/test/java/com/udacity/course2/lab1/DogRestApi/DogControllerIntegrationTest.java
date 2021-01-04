package com.udacity.course2.lab1.DogRestApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseUrl = "http://localhost:";

    @Test
    public void testGetAllDogs () {
        ResponseEntity<List> res =
            this.testRestTemplate.withBasicAuth("admin", "password").getForEntity(baseUrl + port + "/dogs", List.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAllBreeds () {
        ResponseEntity<List> res =
                this.testRestTemplate.withBasicAuth("admin", "password").getForEntity(baseUrl + port + "/dogs/breed", List.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAllNames () {
        ResponseEntity<List> res =
                this.testRestTemplate.withBasicAuth("admin", "password").getForEntity(baseUrl + port + "/dogs/names", List.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetBreedById () {
        ResponseEntity<String> res =
                this.testRestTemplate.withBasicAuth("admin", "password").getForEntity(baseUrl + port + "/dogs/2/breed", String.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

}
