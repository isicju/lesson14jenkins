package org.example.service;

import org.example.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileBasedCitizenService implements CitizenService {

    @Autowired
    private List<Citizen> citizens;

    @Override
    public List<Citizen> getAllCitizens() {
        return citizens;
    }

    @Override
    public Citizen addCitizen(Citizen citizen) {
        if(citizens.contains(citizen)){
            throw new IllegalArgumentException("Citizen already exist!" + citizen.getId());
        }
        citizens.add(citizen);
        return citizen;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Citizen> getAllCitizenByCountry(String country) {
        return citizens.stream().filter(citizen -> citizen.getCountry().equals(country)).collect(Collectors.toList());
    }

}
