package com.marcell.garden_tracker_api.plant;

import com.marcell.garden_tracker_api.common.ApiPaths;
import com.marcell.garden_tracker_api.plant.dto.PlantCreateRequest;
import com.marcell.garden_tracker_api.plant.dto.PlantResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.API_V1 + "/plants")
public class PlantControllerV1 {
    private final PlantService service;

    public PlantControllerV1(PlantService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlantResponse create(@Valid @RequestBody PlantCreateRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public PlantResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PlantResponse> list() {
        return service.list();
    }
}
