package org.fasttrackit.curs10.homework.model;

import lombok.Builder;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;

import java.util.List;

public record Route(
        String start,
        String destination,
        Integer distanceInKm,
        List<TrainEntity> trains
) {
    @Builder public Route {}
}

