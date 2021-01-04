package com.udacity.course2.casestudy1.bootstrap.webtest;

import com.udacity.course2.casestudy1.bootstrap.entity.Location;
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
public class LocationControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseUrl = "http://localhost:";

    @Test
    public void testGetAllLocations () {
        ResponseEntity<List> res = this.testRestTemplate.getForEntity(baseUrl + port + "/location/", List.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetLocation () {
        ResponseEntity<Location> res = this.testRestTemplate.getForEntity(baseUrl + port + "/location/2", Location.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }
}
