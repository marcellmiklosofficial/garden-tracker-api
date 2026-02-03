package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.common.PostgresContainerTestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import javax.sql.DataSource;

import static com.marcell.garden_tracker_api.plant.common.CommonVariables.PLANT_CREATE_REQUEST_V1_TEST_01;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("integration")
@ActiveProfiles("integration")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class PlantControllerV1Test extends PostgresContainerTestBase {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    DataSource dataSource;

    @Test
    void printDatasourceUrl() throws Exception {
        System.out.println("DATASOURCE_URL=" + dataSource.getConnection().getMetaData().getURL());
    }

    @Test
    void createPlant_shouldReturn201() throws Exception {
        mockMvc.perform(
                post("/api/v1/plants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PLANT_CREATE_REQUEST_V1_TEST_01))
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Tomato"));
    }
}
