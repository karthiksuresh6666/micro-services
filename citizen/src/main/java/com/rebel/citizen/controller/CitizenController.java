package com.rebel.citizen.controller;

import com.rebel.citizen.dto.Citizen;
import com.rebel.citizen.dto.CitizenVaccination;
import com.rebel.citizen.service.CitizenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("citizen")
@Slf4j
public class CitizenController {

    private CitizenService citizenService;

    CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping("/add")
    private void saveIndividualVacDetails(@RequestBody final Citizen citizen) {
        log.info(">>saveIndividualVacDetails");
        citizen.setVaccinationTime(LocalDateTime.now());
        citizenService.saveIndividualVacDetails(citizen);
    }

//    @GetMapping("/{aadhar}")
//    private Citizen fetchCitizenDetails(@PathVariable("aadhar") Long aadhar) {
//        log.info(">>fetchCitizenDetails");
//        return citizenService.fetchCitizenDetails(aadhar);
//    }

    @GetMapping("/{aadhar}")
    private ResponseEntity<CitizenVaccination> fetchCitizenWithVaccinationDetails(@PathVariable("aadhar") Long aadhar) {
        log.info(">>fetchCitizenWithVaccinationDetails");
        return ResponseEntity.ok(citizenService.fetchCitizenDetails(aadhar));
    }
}
