package org.fasttrackit.curs10.homework.model.mappers;

import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.Train;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TrainMapper {

    public TrainEntity toEntity(Train train){
        return TrainEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .model(train.model())
                .carts(train.carts())
                .location(train.location())
                .build();
    }

    public Train toEntity(TrainEntity trainEntity){
        return Train.builder()
                .model(trainEntity.model())
                .carts(trainEntity.carts())
                .location(trainEntity.location())
                .build();
    }
}
