package org.fasttrackit.curs10.homework.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.TrainEntity;
import org.fasttrackit.curs10.homework.model.entities.Train;
import org.fasttrackit.curs10.homework.model.filter.TrainFilter;
import org.fasttrackit.curs10.homework.service.TrainService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("train")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService service;

    @PostMapping
    public TrainEntity saveTrain(@RequestBody Train train){
        return service.save(train);
    }

    @DeleteMapping
    public void deleteTrain(@RequestBody TrainFilter train){
         service.delete(train);
    }
}
