package org.example.controller;

import org.example.model.Citizen;
import org.example.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenService fileBasedCitizenService;

    @GetMapping
    public List<Citizen> users() {
        return fileBasedCitizenService.getAllCitizens();
    }

    @PostMapping
    public Citizen createCitizen(@RequestBody Citizen citizen) {
        return fileBasedCitizenService.addCitizen(citizen);
    }
}
