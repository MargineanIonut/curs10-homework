package org.fasttrackit.curs10.homework.repository;

import org.fasttrackit.curs10.homework.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
