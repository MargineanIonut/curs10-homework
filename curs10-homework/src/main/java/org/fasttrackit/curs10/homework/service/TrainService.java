package org.fasttrackit.curs10.homework.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.exception.TrainNotFoundException;
import org.fasttrackit.curs10.homework.model.TrainEntity;
import org.fasttrackit.curs10.homework.model.entities.Train;
import org.fasttrackit.curs10.homework.model.filter.TrainFilter;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.fasttrackit.curs10.homework.repository.TrainRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository repository;
    private final TrainMapper mapper;

    public TrainEntity save(Train train){
        return repository.save(mapper.toEntity(train));
    }

    public void delete(@RequestBody TrainFilter train) {
        TrainEntity trainEntity = repository.findById(train.id()).orElseThrow(() -> new TrainNotFoundException());
        repository.delete(trainEntity);

    }
}
