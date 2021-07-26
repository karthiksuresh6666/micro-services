package com.rebel.citizen.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Vaccine {

    private Long slotId;
    private int batchSize;
    private long vaccineId;
    private LocalDateTime receivedTime;
}
