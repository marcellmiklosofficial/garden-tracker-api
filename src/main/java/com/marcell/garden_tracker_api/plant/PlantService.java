package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.common.NotFoundException;
import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;
import com.marcell.garden_tracker_api.plant.dto.PlantResponse;
import com.marcell.garden_tracker_api.plant.dto.PlantUpdateRequest;
import org.springframework.stereotype.Service;

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

    public PlantResponse update(Long id, PlantUpdateRequest request) {
        Plant plant = repo.findById(id).orElseThrow(() -> new NotFoundException("Plant not found: " + id));

        plant.setName(request.name());
        plant.setVariety(request.variety());
        plant.setPlantedOn(request.plantedOn());
        plant.setLocation(request.location());

        Plant saved = repo.save(plant);

        return toResponse(saved);
    }

    public void delete (Long id) {
        Plant plant = repo.findById(id).orElseThrow(() -> new NotFoundException("Plant not found: " + id));
        repo.delete(plant);
    }

    private PlantResponse toResponse(Plant plant) {
        return new PlantResponse(plant.getId(), plant.getName(), plant.getVariety(), plant.getPlantedOn(), plant.getLocation());
    }
}
