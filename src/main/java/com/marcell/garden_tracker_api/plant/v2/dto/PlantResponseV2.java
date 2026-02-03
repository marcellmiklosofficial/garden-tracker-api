package com.marcell.garden_tracker_api.plant.v2.dto;

import java.time.LocalDate;

public record PlantResponseV2(
        Long id,
        String name,
        String variety,
        LocalDate plantedDate,
        Integer daysSincePlanted,
        String location
) {}
