package org.fasttrackit.curs10.homework.model.mappers;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.exception.LocationNotFoundException;
import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.Train;
import org.fasttrackit.curs10.homework.model.entities.LocationsEntity;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.repository.LocationRepository;

import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
public class TrainMapper {

    private final LocationRepository repository;

    public TrainEntity toEntity(Train train) {
        String trainID = String.valueOf(UUID.randomUUID());
        LocationsEntity byCity = repository.findByCity(train.currentLocation()).orElseThrow(LocationNotFoundException::new);

        return TrainEntity.builder()
                .id(trainID)
                .model(train.model())
                .carts(train.carts())
                .currentTrainLocation(byCity)
                .route(train.route())
                .build();

    }

    public Train toApi(TrainEntity trainEntity) {
        return Train.builder()
                .model(trainEntity.model())
                .carts(trainEntity.carts())
                .city(trainEntity.currentTrainLocation().id())
                .build();
    }
}
