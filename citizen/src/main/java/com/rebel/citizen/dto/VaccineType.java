package com.rebel.citizen.dto;

import lombok.Data;

@Data
public class VaccineType {

    private Long vaccineId;
    private String name;
    private short efficacy;
    private short storageTempLevel;
    private short durationInDays;
}
