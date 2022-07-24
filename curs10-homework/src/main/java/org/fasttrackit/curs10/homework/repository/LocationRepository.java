package org.fasttrackit.curs10.homework.repository;

import org.fasttrackit.curs10.homework.model.entities.LocationsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LocationRepository extends MongoRepository<LocationsEntity, String> {
    Optional<LocationsEntity> findByCity(String currentLocation);
}
