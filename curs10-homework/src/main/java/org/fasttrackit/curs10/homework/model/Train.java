package org.fasttrackit.curs10.homework.model;

import lombok.Builder;

public record Train(
      String model,
      Integer carts,
      String city,
      String startOfDestination,
      String currentLocation,
      String endOfDestination,
      Route route,
      Integer distanceInKm
)
{
    @Builder public Train {}
}
