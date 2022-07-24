package org.fasttrackit.curs10.homework.model;

import lombok.Builder;
import org.fasttrackit.curs10.homework.model.entities.LocationEntity;

public record Train(
      String model,
      Integer carts,
      LocationEntity location)
{
    @Builder public Train {}
}
