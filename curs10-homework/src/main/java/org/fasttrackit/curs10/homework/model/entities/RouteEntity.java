package org.fasttrackit.curs10.homework.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.fasttrackit.curs10.homework.model.Train;

@Data
@AllArgsConstructor
public class RouteEntity {
    private final String start;
    private final String destination;
    private final Byte length;
    private final Train train;
}
