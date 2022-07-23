package org.fasttrackit.curs10.homework.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.fasttrackit.curs10.homework.model.Location;

@Data
@AllArgsConstructor
@Builder
public class Train {
    private  String model;
    private  Integer carts;
    private  Location location;
}
