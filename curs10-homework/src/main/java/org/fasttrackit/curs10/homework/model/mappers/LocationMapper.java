package org.fasttrackit.curs10.homework.model.mappers;

import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.entities.LocationsEntity;

import java.util.UUID;

public class LocationMapper {

    public LocationsEntity toEntity(Location route){

        return LocationsEntity.builder()
                .id(UUID.randomUUID().toString())
                .city(route.city())
                .build();
    }
}
