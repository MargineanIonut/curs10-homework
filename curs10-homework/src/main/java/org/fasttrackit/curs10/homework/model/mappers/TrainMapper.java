package org.fasttrackit.curs10.homework.model.mappers;

import org.fasttrackit.curs10.homework.model.Train;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainMapper {

    Train toApi(TrainEntity entity);
    TrainEntity toEntity(Train train);
}
