package org.fasttrackit.curs10.homework.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.exception.LocationNotFoundException;
import org.fasttrackit.curs10.homework.exception.OperationNotCompletedException;
import org.fasttrackit.curs10.homework.exception.TrainNotFoundException;
import org.fasttrackit.curs10.homework.model.entities.LocationsEntity;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.Train;
import org.fasttrackit.curs10.homework.model.filter.TrainFilter;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.fasttrackit.curs10.homework.repository.LocationRepository;
import org.fasttrackit.curs10.homework.repository.TrainDao;
import org.fasttrackit.curs10.homework.repository.TrainRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository repository;
    private final LocationRepository locationRepository;
    private final TrainMapper mapper;
    private final TrainDao trainDao;

    public Train save(Train train){
        repository.save(mapper.toEntity(train));
        return train;

    }

    public void delete(TrainFilter train) {
        repository.delete(
                repository.findById(train.id())
                          .orElseThrow(TrainNotFoundException::new));

    }

    public void deleteCity(TrainFilter train) {
        TrainEntity byId = repository.findById(train.id()).orElseThrow(TrainNotFoundException::new);
        repository.save(byId.toBuilder()
                .currentTrainLocation(LocationsEntity.builder().build())
                .build());
    }

    public Train updateTrain(String id, JsonPatch train) {
        TrainEntity trainEntity = repository.findById(id)
                .map(dbEntity -> applyPatch(dbEntity, train))
                .map(dbEntity -> replaceTrain(id, dbEntity))
                .orElseThrow(OperationNotCompletedException::new);
        return mapper.toApi(trainEntity);
    }

    private TrainEntity replaceTrain(String id, TrainEntity updatedEntity) {
        TrainEntity trainEntity = repository.findById(id).orElseThrow(TrainNotFoundException::new);
        return repository.save(trainEntity.toBuilder()
                .carts(updatedEntity.carts())
                .currentTrainLocation(updatedEntity.currentTrainLocation())
                .build());
    }

    private TrainEntity applyPatch(TrainEntity dbEntity, JsonPatch jsonPatch) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.convertValue(dbEntity, JsonNode.class);
            JsonNode patchedJson = jsonPatch.apply(jsonNode);
            return jsonMapper.treeToValue(patchedJson, TrainEntity.class);
        } catch (JsonProcessingException | JsonPatchException e) {
            throw new RuntimeException(e);
        }
    }

    public Page<Train> getTrains(TrainFilter filter, Pageable pageable) {
        return trainDao.getTrains(filter, pageable);
    }


    public void addCity(TrainFilter dto) {
        TrainEntity byId = repository.findById(dto.id()).orElseThrow(TrainNotFoundException::new);

        LocationsEntity byCity = locationRepository.findByCity(dto.location()).orElseThrow(LocationNotFoundException::new)
                .toBuilder().city(dto.location()).build();

        repository.save(byId.toBuilder()
                .currentTrainLocation(byCity).build());

    }
}
