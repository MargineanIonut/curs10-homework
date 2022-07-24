package org.fasttrackit.curs10.homework.model.entities;

import lombok.Builder;
import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.Route;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "train")
public record TrainEntity(String id,
                          String model,
                          Integer carts,
                          LocationsEntity currentTrainLocation
)
{
    @Builder(toBuilder = true) public TrainEntity {}
}
