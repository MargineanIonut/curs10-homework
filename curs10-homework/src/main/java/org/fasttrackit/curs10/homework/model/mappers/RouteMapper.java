package org.fasttrackit.curs10.homework.model.mappers;

import org.fasttrackit.curs10.homework.model.Route;
import org.fasttrackit.curs10.homework.model.entities.RouteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    Route toApi(RouteEntity routeEntity);
    RouteEntity toEntity(Route route);
}
