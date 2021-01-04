package com.udacity.course2.lab1.DogRestApi;

import com.udacity.course2.lab1.DogRestApi.service.DogService;
import com.udacity.course2.lab1.DogRestApi.web.DogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.mockito.Mockito.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * this.mockMvc
     *   .perform(
     *       post("/api/tasks")
     *         .contentType(MediaType.APPLICATION_JSON)
     *         .content("{\"taskTitle\": \"Learn MockMvc\"}")
     *         .with(csrf())
     *         .with(SecurityMockMvcRequestPostProcessors.user("duke"))
     *     )
     *   .andExpect(status().isCreated());
     */

    @MockBean
    DogService dogService;

    // adding test to a controller that requires authentication
    @Test
    public void testGetDogs () throws Exception {
        mockMvc.perform(get("/dogs")
            .with(csrf())
            .with(SecurityMockMvcRequestPostProcessors.user("admin")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).getDogs();
    }

    @Test
    public void testGetAllBreeds () throws Exception {
        mockMvc.perform(get("/dogs/breed")
            .with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("admin"))
        )
                .andExpect(status().isOk());
        verify(dogService, times(1)).getAllBreeds();
    }

    @Test
    public void testGetAllNames () throws Exception {
        mockMvc.perform(get("/dogs/names")
            .with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("admin"))
        )
                .andExpect(status().isOk());
        verify(dogService, times(1)).getAllNames();
    }

    @Test
    public void testGetBreedById () throws Exception {
        mockMvc.perform(get("/dogs/2/breed")
            .with(csrf()).with(SecurityMockMvcRequestPostProcessors.user("admin"))
        )
                .andExpect(status().isOk());
        verify(dogService, times(1)).getDogBreedById(2L);
    }
}
