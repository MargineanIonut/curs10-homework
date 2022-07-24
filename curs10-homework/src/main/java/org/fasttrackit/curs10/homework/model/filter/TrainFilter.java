package org.fasttrackit.curs10.homework.model.filter;

import org.fasttrackit.curs10.homework.model.entities.LocationEntity;

public record TrainFilter(String id, String model, Integer carts, LocationEntity locationEntity) {
}
