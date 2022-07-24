package org.fasttrackit.curs10.homework.model;

import lombok.Builder;

public record Route(
        String start,
        String destination,
        Integer distanceInKm,
        Train train
) {
    @Builder public Route {}
}

