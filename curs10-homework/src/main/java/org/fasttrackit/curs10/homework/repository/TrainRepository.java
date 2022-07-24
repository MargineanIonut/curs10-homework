package org.fasttrackit.curs10.homework.repository;

import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainRepository extends MongoRepository<TrainEntity,String> {

}
