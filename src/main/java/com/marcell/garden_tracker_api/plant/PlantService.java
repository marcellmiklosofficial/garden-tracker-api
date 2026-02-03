package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.common.NotFoundException;
import com.marcell.garden_tracker_api.plant.Plant;
import com.marcell.garden_tracker_api.plant.PlantRepository;
import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;
import com.marcell.garden_tracker_api.plant.dto.PlantResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PlantService {
    private final PlantRepository repo;

    public PlantService(PlantRepository repo) {
        this.repo = repo;
    }

    public PlantResponse create(PlantCreateRequest request) {
        Plant plant = new Plant(request.name(), request.variety(), request.plantedOn(), request.location());
        Plant saved = repo.save(plant);
        return toResponse(saved);
    }

    public PlantResponse getById(Long id) {
        Plant plant = repo.findById(id).orElseThrow(() -> new NotFoundException("Plant not found: " + id));

        return toResponse(plant);
    }

    public List<PlantResponse> list() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    private PlantResponse toResponse(Plant plant) {
        return new PlantResponse(plant.getId(), plant.getName(), plant.getVariety(), plant.getPlantedOn(), plant.getLocation());
    }
}
