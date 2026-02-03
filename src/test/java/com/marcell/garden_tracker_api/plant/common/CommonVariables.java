package com.marcell.garden_tracker_api.plant.common;

import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;

import java.time.LocalDate;

public class CommonVariables {
    public static final PlantCreateRequest PLANT_CREATE_REQUEST_V1_TEST_01 = new PlantCreateRequest(
            "Tomato",
            "Roma",
            LocalDate.of(2026, 2, 1),
            "Balcony Box 1"
    );

    public static final PlantCreateRequest PLANT_CREATE_REQUEST_V2_TEST_01 = new PlantCreateRequest(
            "Tomato",
            "Roma",
            LocalDate.now().minusDays(3),
            "Balcony Box 1"
    );
}
