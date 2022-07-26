package org.fasttrackit.curs10.homework.controller;

import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.Train;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.filter.TrainFilter;
import org.fasttrackit.curs10.homework.service.TrainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("train")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService service;

    @PostMapping
    public Train saveTrain(@RequestBody Train train) {
        return service.save(train);
    }

    @PostMapping("city")
    public void addCity(TrainFilter city) {
        service.addCity(city);
    }

    @DeleteMapping
    public void deleteTrain(TrainFilter train) {
        service.delete(train);
    }

    @DeleteMapping("city")
    public void deleteCity(TrainFilter train) {
        service.deleteCity(train);
    }

    @PatchMapping({"id"})
    public Train updateTrain(@PathVariable String id, @RequestBody JsonPatch train) {
        return service.updateTrain(id, train);
    }

    @GetMapping
    public Page<Train> getAll(TrainFilter filter, Pageable pageable) {
        return service.getTrains(filter, pageable);
    }
}
