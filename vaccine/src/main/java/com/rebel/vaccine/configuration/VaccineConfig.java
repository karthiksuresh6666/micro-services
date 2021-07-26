package com.rebel.vaccine.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaccineConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
