package org.fasttrackit.curs10.homework.model;

import lombok.Builder;

public record Train(
      String model,
      Integer carts,
      String city)
{
    @Builder public Train {}
}
