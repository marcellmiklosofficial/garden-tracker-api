package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static com.marcell.garden_tracker_api.plant.common.CommonVariables.PLANT_CREATE_REQUEST_TEST_01;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PlantControllerV1Test {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createPlant_shouldReturn201() throws Exception {
        mockMvc.perform(
                post("/api/v1/plants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PLANT_CREATE_REQUEST_TEST_01))
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Tomato"));
    }
}
