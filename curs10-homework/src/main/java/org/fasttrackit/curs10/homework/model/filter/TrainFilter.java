package org.fasttrackit.curs10.homework.model.filter;

import org.fasttrackit.curs10.homework.model.Location;

public record TrainFilter(String id, String model, Integer carts, Location location) {
}
