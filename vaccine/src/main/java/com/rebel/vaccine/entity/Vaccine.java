package com.rebel.vaccine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long slotId;
    private int batchSize;
    private long vaccineId;
    private LocalDateTime receivedTime;
}
