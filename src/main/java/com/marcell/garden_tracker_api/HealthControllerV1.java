package com.marcell.garden_tracker_api;

import com.marcell.garden_tracker_api.common.ApiPaths;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(ApiPaths.API_V1 + "/health")
public class HealthControllerV1 {

    @GetMapping()
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }
}
