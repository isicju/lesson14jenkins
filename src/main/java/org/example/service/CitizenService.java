package org.example.service;

import org.example.model.Citizen;
import java.util.List;

public interface CitizenService {

    List<Citizen> getAllCitizens();

    Citizen addCitizen(Citizen citizen);

    boolean deleteById(Long id);

    List<Citizen> getAllCitizenByCountry(String country);
}
