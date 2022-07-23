package org.fasttrackit.curs10.homework.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.TrainEntity;
import org.fasttrackit.curs10.homework.model.entities.Train;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.fasttrackit.curs10.homework.repository.TrainRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository repository;
    private final TrainMapper mapper;

    public TrainEntity save(Train train){
        return repository.save(mapper.toEntity(train));
    }
}
