package org.example.controller;

import org.example.model.Citizen;
import org.example.model.City;
import org.example.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cities")
public class CitiyController {

    @Autowired
    List<City> cities;

    @GetMapping
    public List<City> users() {
        return cities.subList(0,100);
    }

}
