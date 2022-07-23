package org.fasttrackit.curs10.homework.model.mappers;
import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.entities.LocationEntity;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toApi(TrainEntity trainEntity);
    LocationEntity toEntity(Location location);
}
