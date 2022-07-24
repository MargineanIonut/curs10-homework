package org.fasttrackit.curs10.homework.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.mappers.LocationMapper;
import org.fasttrackit.curs10.homework.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;
    private final LocationMapper mapper;

    public Location save(Location location) {
        repository.save(mapper.toEntity(location));
        return location;
    }
}
