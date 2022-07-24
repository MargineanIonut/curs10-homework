package org.fasttrackit.curs10.homework.repository;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.filter.TrainFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Optional.*;
import static org.springframework.data.support.PageableExecutionUtils.*;

@Repository
@RequiredArgsConstructor
public class TrainDao {

    private final MongoTemplate mongoTemplate;
    private final LocationRepository locationRepository;


    public Page<TrainEntity> getTrains(TrainFilter filter, Pageable pageable) {
        Criteria criteriaQuery = new Criteria();
        ofNullable(filter.model())
                .ifPresent(model -> criteriaQuery.and("model").is(model));
        ofNullable(filter.location())
                .ifPresent(location -> criteriaQuery.and("location").is(locationRepository.findByCity(filter.location().city())));
        ofNullable(filter.minCartsNumber())
                .ifPresent(minCartsNumber -> criteriaQuery.and("minCartsNumber").gt(minCartsNumber));
        ofNullable(filter.maxCartsNumber()).ifPresent(maxCartsNumber -> criteriaQuery.and("maxCartsNumber").lt(maxCartsNumber));

        Query query = Query.query(criteriaQuery).with(pageable);
        List<TrainEntity> content = mongoTemplate.find(query,TrainEntity.class);

        return getPage(content, pageable,
                () -> mongoTemplate.count(Query.query(criteriaQuery), TrainEntity.class));
    }
}
