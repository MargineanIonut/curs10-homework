package org.fasttrackit.curs10.homework.repository;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.Train;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.filter.TrainFilter;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Optional.*;
import static org.springframework.data.support.PageableExecutionUtils.*;

@Repository
@RequiredArgsConstructor
public class TrainDao {

    private final MongoTemplate mongoTemplate;
    private final LocationRepository locationRepository;
    private final TrainMapper mapper;

    public Page<Train> getTrains(TrainFilter filter, Pageable pageable) {
        Criteria criteriaQuery = new Criteria();
        ofNullable(filter.model())
                .ifPresent(model -> criteriaQuery.and("model").is(model));
        ofNullable(filter.location())
                .ifPresent(city -> criteriaQuery.and("currentTrainLocation.city").is(city));
        ofNullable(filter.minCartsNumber())
                .ifPresent(minCartsNumber -> criteriaQuery.and("carts").gte(minCartsNumber));
        ofNullable(filter.maxCartsNumber())
                .ifPresent(maxCartsNumber -> criteriaQuery.and("carts").lt(maxCartsNumber));

        Query query = Query.query(criteriaQuery).with(pageable);
        List<TrainEntity> content = mongoTemplate.find(query,TrainEntity.class);
        List<Train> trains = content.stream().map(mapper::toApi).toList();
        return getPage(trains, pageable,
                () -> mongoTemplate.count(Query.query(criteriaQuery), TrainEntity.class));
    }
}
