package org.fasttrackit.curs10.homework.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.fasttrackit.curs10.homework.model.Location;

@Data
@AllArgsConstructor
public class TrainEntity {
    private  String id;
    private  String model;
    private  Byte carts;
    private  Location location;
}
