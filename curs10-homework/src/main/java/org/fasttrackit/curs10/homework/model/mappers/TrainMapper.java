package org.fasttrackit.curs10.homework.model.mappers;

import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.Train;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class TrainMapper {

    public TrainEntity toEntity(Train train){

        String trainID = String.valueOf(UUID.randomUUID());
        return TrainEntity.builder()
                .id(trainID)
                .model(train.model())
                .carts(train.carts())
                .location(new Location(trainID, new ArrayList<>()))
                .build();
    }

    public Train toApi(TrainEntity trainEntity){
        return Train.builder()
                .model(trainEntity.model())
                .carts(trainEntity.carts())
                .city(trainEntity.location().id())
                .build();
    }
}
