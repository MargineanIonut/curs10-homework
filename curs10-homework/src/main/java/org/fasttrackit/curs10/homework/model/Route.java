package org.fasttrackit.curs10.homework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;

public record Route(
        String start,
        String destination,
        Byte length,
        TrainEntity trainEntity)
{
    @Builder public Route{};
}
