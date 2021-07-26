package com.rebel.vaccine.controller;

import com.rebel.vaccine.dto.Vaccine;
import com.rebel.vaccine.dto.VaccineType;
import com.rebel.vaccine.service.VaccineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("vaccine")
@Slf4j
public class VController {

    private VaccineService vaccineService;

    @Autowired
    VController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping("/type/add")
    public void saveVaccineType(@RequestBody final VaccineType vaccineType) {
        log.info(">>saveVaccineType");
        vaccineService.saveVaccineType(vaccineType);
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<VaccineType> fetchVaccineType(@PathVariable("id") Long vaccineId) {
        log.info(">>fetchVaccineType");
        return ResponseEntity.ok(vaccineService.fetchVaccineType(vaccineId));
    }

    @PostMapping("/add")
    public void saveVaccineDose(@RequestBody final Vaccine vaccine) {
        log.info(">>saveVaccineDose");
        vaccine.setReceivedTime(LocalDateTime.now());
        vaccineService.saveVaccineDose(vaccine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> fetchVaccineDose(@PathVariable("id") Long slotId) {
        log.info(">>fetchVaccineDose");
        return ResponseEntity.ok(vaccineService.fetchVaccineDoses(slotId));
    }

}
