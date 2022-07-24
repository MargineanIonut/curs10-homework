package org.fasttrackit.curs10.homework.repository;

import org.fasttrackit.curs10.homework.model.entities.LocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {
    LocationEntity findByCity(String city);
}
