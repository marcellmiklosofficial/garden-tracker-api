package com.marcell.garden_tracker_api.plant.dto;

import java.time.LocalDate;

public record PlantResponse (
        Long id,
        String name,
        String variety,
        LocalDate plantedOn,
        String location
) {}
