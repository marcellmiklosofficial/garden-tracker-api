package com.marcell.garden_tracker_api.plant.common;

import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;

import java.time.Instant;
import java.time.LocalDate;

public class CommonVariables {
    public static final PlantCreateRequest PLANT_CREATE_REQUEST_TEST_01 = new PlantCreateRequest(
            "Tomato",
            "Roma",
            LocalDate.of(2026, 2, 1),
            "Balcony Box 1"
    );
}
