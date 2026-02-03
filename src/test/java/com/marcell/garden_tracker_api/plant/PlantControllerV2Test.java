package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.common.PostgresContainerTestBase;
import com.marcell.garden_tracker_api.plant.common.CommonVariables;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("integration")
class PlantControllerV2Test extends PostgresContainerTestBase {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void v2List_shouldUsePlantedDateAndDaysSincePlanted() throws Exception {
        mockMvc.perform(
                post("/api/v1/plants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CommonVariables.PLANT_CREATE_REQUEST_V2_TEST_01))
        ).andExpect(status().isCreated());

        mockMvc.perform(
                get("/api/v2/plants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].plantedDate").exists())
                .andExpect(jsonPath("$[0].daysSincePlanted").value(3))
                .andExpect(jsonPath("$[0].plantedOn").doesNotExist());
    }
}
