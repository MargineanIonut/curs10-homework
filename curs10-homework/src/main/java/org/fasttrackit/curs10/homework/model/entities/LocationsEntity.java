package org.fasttrackit.curs10.homework.model.entities;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("collection")
public record LocationsEntity(String id, String city) {
    @Builder(toBuilder = true) public LocationsEntity {}
}
