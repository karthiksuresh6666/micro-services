package com.rebel.vaccine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vaccineId;
    private String name;
    private short efficacy;
    private short storageTempLevel;
    private short durationInDays;
}
