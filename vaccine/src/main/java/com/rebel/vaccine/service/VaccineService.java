package com.rebel.vaccine.service;

import com.rebel.vaccine.dto.Vaccine;
import com.rebel.vaccine.dto.VaccineType;
import com.rebel.vaccine.repository.VaccineRepository;
import com.rebel.vaccine.repository.VaccineTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccineService {

    private ModelMapper modelMapper;

    private VaccineRepository vaccineRepository;

    private VaccineTypeRepository vaccineTypeRepository;

    @Autowired
    VaccineService(VaccineRepository vaccineRepository, VaccineTypeRepository vaccineTypeRepository, ModelMapper modelMapper) {
        this.vaccineRepository = vaccineRepository;
        this.vaccineTypeRepository = vaccineTypeRepository;
        this.modelMapper = modelMapper;
    }

    public void saveVaccineType(VaccineType vaccineType) {
        com.rebel.vaccine.entity.VaccineType savedEntity = vaccineTypeRepository.save(modelMapper.map(vaccineType, com.rebel.vaccine.entity.VaccineType.class));
    }

    public com.rebel.vaccine.dto.VaccineType fetchVaccineType(Long vaccineId) {
        Optional<com.rebel.vaccine.entity.VaccineType> fetchedEntity = vaccineTypeRepository.findById(vaccineId);
        if (fetchedEntity.isPresent()) {
            return modelMapper.map(fetchedEntity.get(), com.rebel.vaccine.dto.VaccineType.class);
        }
        return new VaccineType();
    }

    public void saveVaccineDose(Vaccine vaccine) {
        com.rebel.vaccine.entity.Vaccine savedEntity = vaccineRepository.save(modelMapper.map(vaccine, com.rebel.vaccine.entity.Vaccine.class));
    }

    public com.rebel.vaccine.dto.Vaccine fetchVaccineDoses(Long vaccineId) {
        Optional<com.rebel.vaccine.entity.Vaccine> fetchedEntity = vaccineRepository.findById(vaccineId);
        if (fetchedEntity.isPresent()) {
            return modelMapper.map(fetchedEntity.get(), com.rebel.vaccine.dto.Vaccine.class);
        }
        return new Vaccine();
    }

}
