package com.rebel.citizen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenVaccination {

    private Citizen Citizen;
    private VaccineType vaccineType;
}
