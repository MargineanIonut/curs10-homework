package org.fasttrackit.curs10.homework.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs10.homework.model.Route;
import org.fasttrackit.curs10.homework.service.RouteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("route")
@RequiredArgsConstructor

public class RouteController {

    private final RouteService service;

    @GetMapping
    public Route createRoute(String start,String destination,String trainId){
        return service.createRoute(start,destination,trainId);
    }
}
