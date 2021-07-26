package com.rebel.vaccine.repository;

import com.rebel.vaccine.entity.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineTypeRepository extends JpaRepository<VaccineType,Long> {
}
