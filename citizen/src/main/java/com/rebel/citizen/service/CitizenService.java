package com.rebel.citizen.service;

import com.rebel.citizen.dto.Citizen;
import com.rebel.citizen.dto.CitizenVaccination;
import com.rebel.citizen.dto.Vaccine;
import com.rebel.citizen.dto.VaccineType;
import com.rebel.citizen.repository.CitizenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CitizenService {

    private ModelMapper modelMapper;

    private CitizenRepository citizenRepository;

    private RestTemplate restTemplate;

    @Autowired
    CitizenService(ModelMapper modelMapper, CitizenRepository citizenRepository, RestTemplate restTemplate) {
        this.modelMapper = modelMapper;
        this.citizenRepository = citizenRepository;
        this.restTemplate = restTemplate;
    }

    public void saveIndividualVacDetails(Citizen citizen) {
        Vaccine vaccine = restTemplate.getForObject("http://VACCINE-SERVICE/vaccine/" + citizen.getSlotId(), Vaccine.class);
        if (citizen.getBatchNo() <= vaccine.getBatchSize()) {
            com.rebel.citizen.entity.Citizen savedEntity = citizenRepository.save(modelMapper.map(citizen, com.rebel.citizen.entity.Citizen.class));
        }
    }

//    public Citizen fetchCitizenDetails(Long aadhar) {
//        Optional<com.rebel.citizen.entity.Citizen> fetchedEntity = citizenRepository.findById(aadhar);
//        if (fetchedEntity.isPresent()) {
//            return modelMapper.map(fetchedEntity.get(), com.rebel.citizen.dto.Citizen.class);
//        }
//        return new Citizen();
//    }

    public CitizenVaccination fetchCitizenDetails(Long aadhar) {
        CitizenVaccination cv = new CitizenVaccination();
        Optional<com.rebel.citizen.entity.Citizen> fetchedEntity = citizenRepository.findById(aadhar);
        if (fetchedEntity.isPresent()) {
            Citizen ct = modelMapper.map(fetchedEntity.get(), com.rebel.citizen.dto.Citizen.class);
            Vaccine vaccine = restTemplate.getForObject("http://VACCINE-SERVICE/vaccine/" + ct.getSlotId(), Vaccine.class);
            VaccineType vaccineType = restTemplate.getForObject("http://VACCINE-SERVICE/vaccine/type/" + vaccine.getVaccineId(), VaccineType.class);
            cv.setCitizen(ct);
            cv.setVaccineType(vaccineType);
        }
        return cv;
    }
}
