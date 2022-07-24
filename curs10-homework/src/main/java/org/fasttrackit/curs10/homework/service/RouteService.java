package org.fasttrackit.curs10.homework.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.exception.LocationNotFoundException;
import org.fasttrackit.curs10.homework.exception.TrainNotFoundException;
import org.fasttrackit.curs10.homework.model.Route;
import org.fasttrackit.curs10.homework.model.entities.LocationsEntity;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.mappers.LocationMapper;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.fasttrackit.curs10.homework.repository.LocationRepository;
import org.fasttrackit.curs10.homework.repository.TrainRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final LocationRepository location;
    private final TrainRepository train;
    private final LocationMapper locationMapper;
    private final TrainMapper trainMapper;

    public Route createRoute(String start, String destination, String trainId) {
        LocationsEntity locationStart = location.findByCity(start).orElseThrow(LocationNotFoundException::new);
        LocationsEntity locationDestination = location.findByCity(destination).orElseThrow(LocationNotFoundException::new);
        TrainEntity trainEntity = train.findById(trainId).orElseThrow(TrainNotFoundException::new);
        return Route.builder()
                .start(locationStart.city())
                .destination(locationDestination.city())
                .distanceInKm(new Random().ints(0,Integer.MAX_VALUE).findFirst().getAsInt())
                .train(trainMapper.toApi(trainEntity))
                .build();
    }
}
