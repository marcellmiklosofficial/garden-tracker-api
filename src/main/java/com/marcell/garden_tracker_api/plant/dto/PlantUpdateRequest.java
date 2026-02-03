package com.marcell.garden_tracker_api.plant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PlantUpdateRequest (
        @NotBlank @Size(max = 100) String name,
        @Size(max = 100) String variety,
        LocalDate plantedOn,
        @Size(max = 100) String location
) {}
