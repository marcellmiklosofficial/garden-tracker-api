package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;
import org.junit.jupiter.api.Test;

import static com.marcell.garden_tracker_api.plant.common.CommonVariables.PLANT_CREATE_REQUEST_V1_TEST_01;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PlantServiceTest {
    @Test
    void create_shouldSavePlantAndReturnResponse() {
        // Arrange
        PlantRepository repository = mock(PlantRepository.class);
        PlantService service = new PlantService(repository);
        PlantCreateRequest request = PLANT_CREATE_REQUEST_V1_TEST_01;

        Plant saved = new Plant(request.name(), request.variety(), request.plantedOn(), request.location());

        when(repository.save(any(Plant.class))).thenReturn(saved);

        // Act
        var response = service.create(request);

        // Assert
        assertEquals(request.name(), response.name());
        verify(repository, times(1)).save(any(Plant.class));
    }
}
