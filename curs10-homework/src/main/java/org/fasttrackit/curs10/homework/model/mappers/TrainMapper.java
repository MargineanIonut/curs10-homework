package org.fasttrackit.curs10.homework.model.mappers;

import org.fasttrackit.curs10.homework.model.TrainEntity;
import org.fasttrackit.curs10.homework.model.entities.Train;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TrainMapper {

    public TrainEntity toEntity(Train entity){
        return TrainEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .model(entity.getModel())
                .carts(entity.getCarts())
                .location(entity.getLocation())
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
