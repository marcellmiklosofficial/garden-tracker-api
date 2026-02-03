package com.marcell.garden_tracker_api.plant.v2;

import com.marcell.garden_tracker_api.common.ApiPaths;
import com.marcell.garden_tracker_api.plant.Plant;
import com.marcell.garden_tracker_api.plant.PlantRepository;
import com.marcell.garden_tracker_api.plant.v2.dto.PlantResponseV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.API_V2 + "/plants")
public class PlantControllerV2 {
    private final PlantRepository repository;

    public PlantControllerV2(PlantRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PlantResponseV2> listV2() {
        return repository.findAll().stream().map(this::toV2).toList();
    }

    private PlantResponseV2 toV2(Plant plant) {
        LocalDate plantedDate = plant.getPlantedOn();
        Integer days = null;

        if (plantedDate != null) {
            days = (int) ChronoUnit.DAYS.between(plantedDate, LocalDate.now());
        }

        return new PlantResponseV2(
                plant.getId(),
                plant.getName(),
                plant.getVariety(),
                plantedDate,
                days,
                plant.getLocation()
        );
    }
}
