package com.marcell.garden_tracker_api.plant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private String variety;
    private LocalDate plantedOn;
    private String location;

    protected Plant() {}

    public Plant(String name, String variety, LocalDate plantedOn, String location) {
        this.name = name;
        this.variety = variety;
        this.plantedOn = plantedOn;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVariety() {
        return variety;
    }

    public LocalDate getPlantedOn() {
        return plantedOn;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setPlantedOn(LocalDate plantedOn) {
        this.plantedOn = plantedOn;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
