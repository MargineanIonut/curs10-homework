package org.fasttrackit.curs10.homework.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.service.LocationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService service;

    @PostMapping
    public Location saveLocation(Location city){
        return service.save(city);
    }
}
