package com.rebel.citizen.dto;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class Citizen {

    private Long aadharNumber;
    private LocalDateTime vaccinationTime;
    private long slotId;
    private int batchNo;
}
