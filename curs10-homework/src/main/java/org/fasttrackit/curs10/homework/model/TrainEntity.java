package org.fasttrackit.curs10.homework.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "train")
public record TrainEntity(String id, String model, Integer carts, Location location)
{
    @Builder public TrainEntity {}
}
